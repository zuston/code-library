#include "json.h"
#include <assert.h>
#include <stdlib.h>


typedef struct {
  const char * json;
}z_context;


json_type z_get_value(const z_type* v){
  assert(v!=NULL);
  return v->type;
}

static void z_parse_strip(z_context *zcontext){
  const char *p = zcontext->json;
  while(*p==' '||*p=='\n'||*p=='\t'||*p=='\r'){
    p++;
  }
  zcontext->json = p;
}

static int z_parse_null(z_context *zcontext,z_type *v){
  if(zcontext->json[0]!='n'||zcontext->json[1]!='u'||zcontext->json[2]!='l'||zcontext->json[3]!='l')
    return Z_PARSE_INVAILD_VALUE;

  zcontext->json += 4;
  v->type = JSON_NULL;
  return Z_PARSE_OK;
}


static int z_parse_value(z_context *zcontext,z_type *v){
  switch (*(zcontext->json)){
    case 'n':
      return z_parse_null(zcontext,v);
    case '\0':
      return Z_PARSE_EXPECT_VALUE;
    default:
      return Z_PARSE_INVAILD_VALUE;
  }
}


int z_parse(z_type *v,const char *json){
  z_context zcontext;
  assert(v!=NULL);
  zcontext.json = json;
  v->type = JSON_NULL;
  z_parse_strip(&zcontext);
  return z_parse_value(&zcontext,v);
}
