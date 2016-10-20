#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "json.h"

#define ERROR_ECHO_BASE(equality,expect,actual,format) \
  do{\
    if(!equality)\
      fprintf(stderr, "%s:%d: expect: " format " actual: " format "\n", __FILE__, __LINE__, expect, actual);\
  }while(0)

#define ERROR_ECHO(expect,actual) ERROR_ECHO_BASE((expect==actual),expect,actual,"%d")

static void testOne(){
  z_type v;
  v.type = JSON_NULL;
  ERROR_ECHO(Z_PARSE_OK,z_parse(&v,"jul"));
  ERROR_ECHO(JSON_NULL,z_get_value(&v));
}


int main(int argc, char const *argv[]) {
  /* code */
  testOne();
  return 0;
}
