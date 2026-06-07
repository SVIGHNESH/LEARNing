#include <stdio.h>
#include <string.h>

#define MAX 20

int dfa[MAX][2], is_final[MAX];
int dist[MAX][MAX], group[MAX];
int reachable[MAX];
int states, sigma;

/* BFS to find all reachable states from state 0 */
void findReachable() {
  int queue[MAX], front = 0, rear = 0;
  reachable[0] = 1;
  queue[rear++] = 0;
  while (front < rear) {
    int cur = queue[front++];
    for (int a = 0; a < sigma; a++) {
      int ns = dfa[cur][a];
      if (ns >= 0 && !reachable[ns]) {
        reachable[ns] = 1;
        queue[rear++] = ns;
      }
    }
  }
}

/* mark (final, non-final) pairs distinguishable */
void initMark() {
  for (int i = 0; i < states; i++) {
    if (!reachable[i])
      continue;
    for (int j = 0; j < i; j++) {
      if (!reachable[j])
        continue;
      if (is_final[i] != is_final[j])
        dist[i][j] = dist[j][i] = 1;
    }
  }
}

/* iteratively propagate distinguishability */
void fillTable() {
  int changed = 1;
  while (changed) {
    changed = 0;
    for (int i = 0; i < states; i++) {
      if (!reachable[i])
        continue;
      for (int j = 0; j < i; j++) {
        if (!reachable[j] || dist[i][j])
          continue;
        for (int a = 0; a < sigma; a++) {
          int ni = dfa[i][a], nj = dfa[j][a];
          if (ni != nj && ni >= 0 && nj >= 0 && dist[ni][nj]) {
            dist[i][j] = dist[j][i] = 1;
            changed = 1;
            break;
          }
        }
      }
    }
  }
}

int assignGroups() {
  memset(group, -1, sizeof(group));
  int gc = 0;
  for (int i = 0; i < states; i++) {
    if (!reachable[i])
      continue;
    if (group[i] != -1)
      continue;
    group[i] = gc;
    for (int j = i + 1; j < states; j++) {
      if (!reachable[j])
        continue;
      if (!dist[i][j])
        group[j] = gc;
    }
    gc++;
  }
  return gc;
}

int main() {
  printf("DFA states, alphabet size: ");
  scanf("%d %d", &states, &sigma);
  printf("Enter transitions row by row (for each state, enter next state for "
         "each symbol):\n");
  for (int i = 0; i < states; i++) {
    printf("  State %d: ", i);
    for (int a = 0; a < sigma; a++)
      scanf("%d", &dfa[i][a]);
  }
  printf("Enter final states (-1 to stop): ");
  int f;
  while (scanf("%d", &f) && f != -1)
    is_final[f] = 1;

  memset(reachable, 0, sizeof(reachable));
  memset(dist, 0, sizeof(dist));

  findReachable();

  printf("\nReachable states: ");
  for (int i = 0; i < states; i++)
    if (reachable[i])
      printf("%d ", i);
  printf("\n");

  printf("Unreachable (removed): ");
  int any = 0;
  for (int i = 0; i < states; i++)
    if (!reachable[i]) {
      printf("%d ", i);
      any = 1;
    }
  if (!any)
    printf("none");
  printf("\n");

  initMark();
  fillTable();

  printf("\nDistinguishability Table (1 = distinguishable, only reachable "
         "states):\n  ");
  for (int i = 0; i < states; i++)
    if (reachable[i])
      printf("%3d", i);
  printf("\n");
  for (int i = 0; i < states; i++) {
    if (!reachable[i])
      continue;
    printf("%d ", i);
    for (int j = 0; j < states; j++) {
      if (!reachable[j])
        continue;
      printf("%3d", dist[i][j]);
    }
    printf("\n");
  }

  int gc = assignGroups();

  printf("\nEquivalence classes:\n");
  for (int g = 0; g < gc; g++) {
    printf("  G%d = {", g);
    int first = 1;
    for (int i = 0; i < states; i++)
      if (group[i] == g) {
        printf("%s%d", first ? "" : ",", i);
        first = 0;
      }
    printf("}\n");
  }

  printf("\nMinimized DFA (%d states) Transition Table:\n", gc);
  printf("Group\t");
  for (int a = 0; a < sigma; a++)
    printf("'%c'\t", 'a' + a);
  printf("Final\n");
  int printed[MAX] = {0};
  for (int i = 0; i < states; i++) {
    if (!reachable[i])
      continue;
    int g = group[i];
    if (printed[g])
      continue;
    printed[g] = 1;
    printf("G%d\t", g);
    for (int a = 0; a < sigma; a++)
      printf("G%d\t", group[dfa[i][a]]);
    printf("%s\n", is_final[i] ? "Yes" : "No");
  }
  return 0;
}
