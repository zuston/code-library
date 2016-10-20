#ifndef JSON_H__
#define JSON_H__

typedef enum {
  JSON_NULL,
  JSON_STRING,
  JSON_BOOLEAN,
  JSON_ARRAY,
  JSON_NUMBER
}json_type;

typedef struct {
  json_type type;
}z_type;

enum {
  Z_PARSE_OK = 0,
  Z_PARSE_EXPECT_VALUE,
  Z_PARSE_INVAILD_VALUE
};

int z_parse(z_type *v,const char *json);

json_type z_get_value(const z_type* v);

#endif
