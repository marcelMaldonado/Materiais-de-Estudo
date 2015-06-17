#include"bibliotecaOrdenaca.h"

void troca(int a, int b){

    int aux=0;
    aux=a;
    a=b;
    b=aux;
}

void InsertionSort(int c[], int n){

    int i,j,chave;

    for(j=1;j<n;j++){

        chave=c[j];
        i=j-1;
        while((i>=0)&&(c[i]>chave)){

            c[i+1]=c[i];
            i=i-1;

        }
        c[i+1]=chave;
    }

}

int Particionamento(int v[], int i, int f){

    int pivo,k,j,q,c;
    pivo=v[i];
    k=1;
    j=2;
    q=0;
    c=1;

    while(c<=f){

        if(j>k){
            if((v[k]>pivo)&&(v[j]<pivo)){

                troca(v[k],v[j]);
                k++;
                j++;
            }
            if((v[k]>pivo)&&(v[j]>pivo))
                j++;

            if((v[k]<pivo)&&(v[j]>pivo)){
                j++;
                k++;
            }
        }
        c++;
    }

    troca(v[0],v[k-1]);
    q=k-1;
    return q;
}

void QuickSort(int v[], int i, int f){

    int q=0;
    if(i<f){

        q=Particionamento(v,i,f);
        QuickSort(v,i,q-1);
        QuickSort(v,q+1,f);
    }

}
