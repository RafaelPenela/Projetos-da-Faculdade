#include <iostream>
using namespace std;
#define MAXSIZE 100


void descer(int* arrayPtr, int l, int p){
    int e=(2*l);
    int d=((2*l)+1);
    int maior = l;
    if(e<p && arrayPtr[e]>arrayPtr[maior]){
        maior = e;
    } if (d<p && arrayPtr[d]>arrayPtr[maior]){
        maior = d;
    } if(maior!=l){
        int temp = arrayPtr[l];
        arrayPtr[l] = arrayPtr[maior];
        arrayPtr[maior] = temp;
        descer(arrayPtr,maior,p);
    }

}

void heapSort(int* arrayPtr,int* tPtr){
    int a=(*tPtr);
     for (int i = (a / 2) - 1; i >= 0; i--) {
        descer(arrayPtr, i, a);
    }
    for(int i=(a-1); i>1; i-- ){
        descer(arrayPtr,i , a);
    }
}


int main(){
    int array[MAXSIZE];
    int* arrayPtr = array;
    int t = MAXSIZE;
    int* tPtr = &t;
    return 0;
}
