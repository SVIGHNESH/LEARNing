#include <stdio.h>
#include <string.h>
#define M 20

int enfa[M][M][M], enc[M][M];
int ecl[M][M], eclc[M];

int nfa[M][M][M], nfc[M][M];

int finalE[M], fn;
int finalN[M], fnn = 0;

int st, sg; // states, symbols (epsilon is symbol sg)

/* Compute epsilon closure recursively */
void eps(int s, int *vis) {
  vis[s] = 1;
  for (int i = 0; i < enc[s][sg]; i++) {
    int ns = enfa[s][sg][i];
    if (!vis[ns])
      eps(ns, vis);
  }
}

/* Build epsilon closure for every state */
void buildClosure() {
  for (int s = 0; s < st; s++) {
    int vis[M] = {0};
    eclc[s] = 0;

    eps(s, vis);

    for (int i = 0; i < st; i++)
      if (vis[i])
        ecl[s][eclc[s]++] = i;
  }
}

/* Check final state in epsilon-NFA */
int isFinal(int x) {
  for (int i = 0; i < fn; i++)
    if (finalE[i] == x)
      return 1;
  return 0;
}

/* Build equivalent NFA */
void buildNFA() {

  for (int s = 0; s < st; s++) {

    /* Final-state propagation */
    for (int i = 0; i < eclc[s]; i++) {
      if (isFinal(ecl[s][i])) {
        int dup = 0;
        for (int k = 0; k < fnn; k++)
          if (finalN[k] == s)
            dup = 1;

        if (!dup)
          finalN[fnn++] = s;
        break;
      }
    }

    /* For each real input symbol */
    for (int a = 0; a < sg; a++) {

      int reach[M] = {0};

      /* move from epsilon closure(s) */
      for (int i = 0; i < eclc[s]; i++) {

        int t = ecl[s][i];

        for (int j = 0; j < enc[t][a]; j++) {

          int ns = enfa[t][a][j];

          /* add epsilon closure of reached state */
          for (int k = 0; k < eclc[ns]; k++)
            reach[ecl[ns][k]] = 1;
        }
      }

      /* store NFA transition */
      for (int i = 0; i < st; i++)
        if (reach[i])
          nfa[s][a][nfc[s][a]++] = i;
    }
  }
}

int main() {

  memset(enc, 0, sizeof(enc));
  memset(nfc, 0, sizeof(nfc));

  printf("Enter number of states and alphabet size: ");
  scanf("%d%d", &st, &sg);

  printf("Enter transitions (state symbol next_state)\n");
  printf("Use symbol %d for epsilon, -1 to stop\n", sg);

  int s, a, ns;

  while (1) {
    scanf("%d", &s);
    if (s == -1)
      break;

    scanf("%d%d", &a, &ns);

    enfa[s][a][enc[s][a]++] = ns;
  }

  printf("Enter number of final states: ");
  scanf("%d", &fn);

  printf("Enter final states: ");
  for (int i = 0; i < fn; i++)
    scanf("%d", &finalE[i]);

  buildClosure();

  printf("\nEpsilon Closures:\n");
  for (int i = 0; i < st; i++) {
    printf("E(%d)={ ", i);
    for (int j = 0; j < eclc[i]; j++)
      printf("%d ", ecl[i][j]);
    printf("}\n");
  }

  buildNFA();

  printf("\nEquivalent NFA Transitions:\n");

  for (int s = 0; s < st; s++) {
    for (int a = 0; a < sg; a++) {

      printf("d(%d,%d)={ ", s, a);

      for (int j = 0; j < nfc[s][a]; j++)
        printf("%d ", nfa[s][a][j]);

      printf("}\n");
    }
  }

  printf("\nFinal States in NFA: { ");
  for (int i = 0; i < fnn; i++)
    printf("%d ", finalN[i]);
  printf("}\n");

  return 0;
}
