#include <iostream>
#include <stdlib.h>
#include <time.h>
using namespace std;

struct Carta{
    int valor;
    char naipe;
    Carta* prox;
};

struct Pilha {
    Carta* topo;
    Pilha(){
        topo = nullptr;
    }

    void empilhar(int valor, char naipe){
        Carta* nova = new Carta{valor, naipe, topo};
        topo = nova;
    }
    Carta* desempilhar(){
        if (!topo) {
            return nullptr;
        }
        Carta* carta = topo;
        topo=topo->prox;
        return carta;
    }
    
    void mostrar(){
        Carta* atual = topo;
        while(atual){
            cout<<atual->valor << atual->naipe << " ";
            atual = atual->prox;
        }
        cout << endl;
    }
};

void inicializar(Pilha &baralho){
    char naipes[]= {'C','O','P','E'};
    for(int v =1 ; v<14; v++){
        for(char n : naipes){
            baralho.empilhar(v,n);
        }
    }
}

void distribuir(Pilha &baralho, Pilha colunas[],int numColunas){
    for (int i=0; i< numColunas; i++){
        int numCartas=6;
        if(i<4){
            numCartas = 7;
        }
        for(int j=0; j<numCartas; j++){
            Carta* c = baralho.desempilhar();
            if(c){
                colunas[i].empilhar(c->valor,c->naipe);
            }
            delete c;
        }
    }
}

int main (){
    srand(time(0));
    Pilha baralho, coluna[8];
    inicializar(baralho);
    distribuir(baralho,coluna, 8);

    while(true){
        cout << "\nEstado atual:\n";
        for (int i = 0; i < 8; i++) {
            cout << "Coluna " << i + 1 << ": ";
            coluna[i].mostrar();
        }
        int origem, destino;
        cout << "Mover de (1-8): "; cin >> origem;
        cout << "Para (1-8): "; cin >> destino;
        Carta* carta = coluna[origem-1].desempilhar();
        if(carta){
            coluna[destino-1].empilhar(carta->valor,carta->naipe);
            delete carta;            
        }
    }
    return 0;
}
