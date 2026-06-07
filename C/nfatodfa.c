#include <stdio.h>
#include <string.h>
#define M 20

int nfa[M][M][M], nc[M][M];
int dfa[M][M], mark[M];
int sub[M][M], sc[M], tot = 0;
int fnfa[M], fn, fdfa[M], fd = 0, isf[M];
int st, sg;

int find(int *s, int n) {
  for (int i = 0; i < tot; i++) {
    if (sc[i] != n)
      continue;
    int ok = 1;
    for (int j = 0; j < n; j++) {
      int f = 0;
      for (int k = 0; k < sc[i]; k++)
        if (sub[i][k] == s[j])
          f = 1;
      if (!f) {
        ok = 0;
        break;
      }
    }
    if (ok)
      return i;
  }
  return -1;
}

int add(int *s, int n) {
  int id = find(s, n);
  if (id != -1)
    return id;

  sc[tot] = n;
  for (int i = 0; i < n; i++)
    sub[tot][i] = s[i];

  for (int i = 0; i < n; i++)
    for (int j = 0; j < fn; j++)
      if (s[i] == fnfa[j]) {
        isf[tot] = 1;
        fdfa[fd++] = tot;
        i = n;
        break;
      }
  return tot++;
}

void build() {
  int q[M * M], f = 0, r = 0;
  q[r++] = 0;
  mark[0] = 1;

  while (f < r) {
    int cur = q[f++];
    for (int a = 0; a < sg; a++) {
      int nxt[M], c = 0;
      for (int i = 0; i < sc[cur]; i++) {
        int x = sub[cur][i];
        for (int j = 0; j < nc[x][a]; j++) {
          int ns = nfa[x][a][j], d = 0;
          for (int k = 0; k < c; k++)
            if (nxt[k] == ns)
              d = 1;
          if (!d)
            nxt[c++] = ns;
        }
      }
      if (c == 0)
        dfa[cur][a] = -1;
      else {
        int id = add(nxt, c);
        dfa[cur][a] = id;
        if (!mark[id]) {
          mark[id] = 1;
          q[r++] = id;
        }
      }
    }
  }
}

int main() {
  memset(nc, 0, sizeof(nc));
  memset(mark, 0, sizeof(mark));
  memset(isf, 0, sizeof(isf));

  printf("States & alphabet: ");
  scanf("%d%d", &st, &sg);

  printf("Transitions (state sym next). -1 to stop:\n");
  int s, a, ns;
  while (scanf("%d", &s) && s != -1) {
    scanf("%d%d", &a, &ns);
    nfa[s][a][nc[s][a]++] = ns;
  }

  printf("Final states count: ");
  scanf("%d", &fn);
  for (int i = 0; i < fn; i++)
    scanf("%d", &fnfa[i]);

  int start[1] = {0};
  add(start, 1);

  build();

  printf("\nDFA:\nState\t");
  for (int a = 0; a < sg; a++)
    printf("%c\t", 'a' + a);
  printf("Subset\tF\n");

  for (int i = 0; i < tot; i++) {
    printf("D%d\t", i);
    for (int a = 0; a < sg; a++) {
      if (dfa[i][a] == -1)
        printf("X\t");
      else
        printf("D%d\t", dfa[i][a]);
    }
    printf("{");
    for (int j = 0; j < sc[i]; j++)
      printf("%d ", sub[i][j]);
    printf("}\t%d\n", isf[i]);
  }

  printf("\nFinal DFA states: ");
  for (int i = 0; i < fd; i++)
    printf("D%d ", fdfa[i]);

  return 0;
}
