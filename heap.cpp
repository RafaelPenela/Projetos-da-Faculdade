#include <iostream>
using namespace std;
#define MAXSIZE 100


void subir(int* arrayPtr, int l ){
    int a = (l/2);
    if(l!=0 && arrayPtr[l]>arrayPtr[a]){
        int temp = arrayPtr[l];
        arrayPtr[l] = arrayPtr[a];
        arrayPtr[a] = temp;
        subir(arrayPtr,a);
    }
}

void inserir(int* arrayPtr, int* pPtr, int valor){  
    if (*pPtr < MAXSIZE) {
        arrayPtr[*pPtr] = valor;
        subir(arrayPtr,*pPtr);  
        (*pPtr) ++;                          
    } else {                      
        cout << "heap is full";
    }
}

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

void excluir(int* arrayPtr, int* pPtr){
    if (*pPtr == 0) {
        cout << "Heap is empty!" << endl;
        return;
    } else {
        arrayPtr[0]=arrayPtr[*pPtr-1];
        (*pPtr)--;
        descer(arrayPtr, 0, *pPtr);
    }
}


int main(){
    int array[MAXSIZE];
    int* arrayPtr = array;
    int p = 0;
    int* pPtr = &p;
    return 0;
}
