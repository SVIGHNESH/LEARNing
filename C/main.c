#include <dlfcn.h>
#include <stdio.h>
#include <stdlib.h>

int main() {
  void *lib = dlopen(NULL, RTLD_NOW);
  printf("%p\n", lib);

  void *main_lib = dlsym(lib, "main");
  printf("%p\n", main_lib);
  printf("%p\n", &malloc);
  return 0;
}
