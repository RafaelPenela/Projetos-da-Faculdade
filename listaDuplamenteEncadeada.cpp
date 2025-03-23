/*Código de exclusão e inserção em listas duplamente encadeada, desconsiderando 
alguns casos de nullptr*/

#include <iostream>
using namespace std;

struct no{
    int info;
    struct no* prox;
    struct no* ant;
};

void main(){
    no* primeiro = new no;
    no* ultimo = new no;
    primeiro->ant=nullptr;
    primeiro->info=1;
    primeiro->prox=ultimo;
    ultimo->ant=primeiro;
    ultimo->info=4;
    ultimo->prox=nullptr;
    no* topo = primeiro;
    no* fim = ultimo;
}

void excluiinicio(no* &topo){
    no* aux =topo;
    topo = aux->prox;
    topo->ant=nullptr;
    delete aux;
}

void excluifim(no* &fim){
    no* aux =fim;
    fim = aux->ant;
    fim->prox=nullptr;
    delete aux;
}

void excluimeio(no* &anterior,no* &proximo,no* &escolhido){
    no* aux =escolhido;
    anterior->prox = escolhido->prox;
    proximo->ant=escolhido->ant;
    delete aux;
}

//adiciona um no ao inicio da fila duplamente encadeada 
void adicionainicio(no* &topo,int valor){
    no* novo = new no{valor,topo,nullptr};
    if(topo!=nullptr){
        topo->ant=novo;
    }
    topo = novo;
}

void adicionafim(no* &fim,int valor){
    no* novo = new no{valor,nullptr,fim};
    if(fim!=nullptr){
        fim->prox=novo;
    }
    fim = novo;
}

void adicionameio(no* &anterior,no* &proximo,int valor){
    no* novo = new no{valor,proximo,anterior};
    anterior->prox=novo;
    proximo->ant=novo;
}
