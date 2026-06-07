#include <stddef.h>
#include <stdint.h>
#include <stdio.h>
int main() {
  uint64_t a = 0;
  uint64_t b = 1;
  for (size_t i = 0; i < 100; i++) {
    printf("%llu\n", a);
    uint64_t c = a + b;
    a = b;
    b = c;
  }
  return 0;
}
