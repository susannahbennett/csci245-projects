#include <stdio.h>

#include "bitvector.h"

int
main(void)
{
	int n, i, j;
	struct bit_vector *vec;

	printf("Enter max int-> ");
	scanf("%d", &n);

	vec = bv_create(n + 1);
	
	int x;
	for (x = 0; x <= n; x++) {
	  bv_insert(vec, x);
	}
	
	for (i = 2; i < n+1; i++){
	  for(j = i; j < n; j=j+i) {
	    if (j != i){
	      bv_remove(vec, j);
	    }
	  }
	}
	
        int isFirst, k;
        printf("{");
        isFirst = 1;
        for (k = 0; k < 10; k++)
	  if (bv_contains(vec, k)) {
	    if (!isFirst)
	      printf(", ");
	    printf("%d", k);
	    isFirst = 0;
	  }
        printf("} \n");
}
