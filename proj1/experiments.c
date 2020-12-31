#include <stdio.h>

#include "array_util.h"
#include "sorts.h"

int main(void)
{
  int i;
  long before, after;
  int compars;

  int master[500000];
  int copy[500000];
  
  int sizes[] = {10, 50, 100, 250, 500, 10000, 15000, 20000, 25000, 30000, 35000, 40000, 45000, 50000};

  printf("\t\tbubble\t\tselection\tinsertion\tshell\t\tmerge\t\tquick\n");
  printf("comparisons\n");
  for (i=0; i<4; i++){
    printf("%d:", sizes[i]);
    random_array(master, sizes[i]);
    
    copy_array(master, copy, sizes[i]);
    compars = bubbleSort(copy, sizes[i]);

    printf("\t\t%d", compars);
    
    copy_array(master, copy, sizes[i]);
    compars = selectionSort(copy, sizes[i]);
    
    printf("\t\t%d", compars);
    
    copy_array(master, copy, sizes[i]);
    compars = insertionSort(copy, sizes[i]);

    printf("\t\t%d", compars);
    
    copy_array(master, copy, sizes[i]);
    compars = shellSort(copy, sizes[i]);

    printf("\t\t%d", compars);

    copy_array(master, copy, sizes[i]);
    compars = mergeSort(copy, sizes[i]);

    printf("\t\t%d", compars);

    copy_array(master, copy, sizes[i]);
    compars = quickSort(copy, sizes[i]);

    printf("\t\t%d\n", compars);
  }

  printf("running times\n");
  for (i = 0; i < 14; i++) {
    random_array(master, sizes[i]);
    printf("%d", sizes[i]);

    copy_array(master, copy, sizes[i]);
    before = get_time_millis();
    bubbleSort(copy, sizes[i]);
    after = get_time_millis();
    
    printf("\t\t%ld", after - before);

    copy_array(master, copy, sizes[i]);
    before = get_time_millis();
    selectionSort(copy, sizes[i]);
    after = get_time_millis();

    printf("\t\t%ld", after - before);
    
    copy_array(master, copy, sizes[i]);
    before = get_time_millis();
    insertionSort(copy, sizes[i]);
    after = get_time_millis();

    printf("\t\t%ld", after - before);

    copy_array(master, copy, sizes[i]);
    before = get_time_millis();
    shellSort(copy, sizes[i]);
    after = get_time_millis();

    printf("\t\t%ld", after - before);
    
    copy_array(master, copy, sizes[i]);
    before = get_time_millis();
    mergeSort(copy, sizes[i]);
    after = get_time_millis();

    printf("\t\t%ld", after - before);

    copy_array(master, copy, sizes[i]);
    before = get_time_millis();
    quickSort(copy, sizes[i]);
    after = get_time_millis();

    printf("\t\t%ld\n", after - before);
  }

}
