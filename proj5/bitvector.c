#include <stdlib.h>
#include "bitvector.h"

int
numBytes(int bits) {
  return bits/8;
}

struct bit_vector *
bv_create(int size)
{
  struct bit_vector *newbv = malloc(sizeof(struct bit_vector));
  newbv -> size = size;
  newbv -> vector = malloc(numBytes(size));
  
  return newbv;
}

void
bv_destroy(struct bit_vector *v)
{
  free(v-> vector);
  free(v);
}

int
bv_contains(struct bit_vector *v, int i)
{
  int bytes = i / 8;
  int bitNum = i % 8;
  //checking if true, 1 & 1 = 1 (true)
  return v -> vector[bytes] & (1 << bitNum);
}

void
bv_insert(struct bit_vector *v, int i)
{
  int bytes = i/8;
  int bitNum = i%8;
  v -> vector[bytes] = v -> vector[bytes] | (1 << bitNum);
}

void
bv_remove(struct bit_vector *v, int i)
{
  int bytes = i/8;
  int bitNum = i%8;
  v -> vector[bytes] = v -> vector[bytes] & ~(1 << bitNum);
}

struct bit_vector *
bv_complement(struct bit_vector *v)
{
  struct bit_vector *cbv = bv_create(v -> size);
  int x;
  for (x = 0; x <= numBytes(v->size) ; x++) {
    cbv -> vector[x] = ~(v -> vector[x]);
  }
  return cbv;
}

struct bit_vector *
bv_union(struct bit_vector *v1, struct bit_vector *v2)
{
  struct bit_vector *cbv = bv_create(v1 -> size);
  int x;
  for (x = 0; x <= numBytes(v1->size) ; x++) {
    cbv -> vector[x] = (v1->vector[x] | v2->vector[x]);
  }
  return cbv;
}

struct bit_vector *
bv_intersection(struct bit_vector *v1, struct bit_vector *v2)
{
  struct bit_vector *cbv = bv_create(v1 -> size);
  int x;
  for (x = 0; x <= numBytes(v1->size) ; x++) {
    cbv -> vector[x] = (v1 -> vector[x] & v2 -> vector[x]);
  }
  return cbv;
}

struct bit_vector *
bv_difference(struct bit_vector *v1, struct bit_vector *v2)
{
  struct bit_vector *cbv = bv_create(v1 -> size);
  int x;
  for (x = 0; x <= numBytes(v1->size) ; x++) {
    cbv -> vector[x] = (v1 -> vector[x] & ~( v2 -> vector[x]));
  }
  return cbv;
}
