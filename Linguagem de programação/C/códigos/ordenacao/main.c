#include <stdio.h>
#include <stdlib.h>

int main()
{
    int v[10],i,q;
    v[0]=3;
    v[1]=1;
    v[2]=5;
    v[3]=2;
    v[4]=9;
    v[5]=7;
    v[6]=8;
    v[7]=4;
    v[8]=6;
    v[9]=10;

    q=Particionamento(v,0,9);
    printf("%d\n",q);
    printf("%d\n",v[q]);
    //InsertionSort(v,10);
    //QuickSort(v,0,9);
    for(i=0;i<10;i++){

        printf("%d " " ",v[i]);


    }
    return 0;
}
