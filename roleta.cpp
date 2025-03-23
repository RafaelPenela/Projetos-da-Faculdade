#include <iostream>
#include <algorithm>  
#include <random>     
#include <ctime>      

using namespace std;


struct Ciclo {
    int info;
    Ciclo* prox;
};

Ciclo* atual; //marca posição atual do ponteiro 

Ciclo* n1 = new Ciclo{0,nullptr}; 
Ciclo* n2 = new Ciclo{0,n1};
Ciclo* n3 =new Ciclo{0,n2};
Ciclo* n4 =new Ciclo{0,n3};
Ciclo* n5 =new Ciclo{0,n4};
Ciclo* n6 =new Ciclo{0,n5};
Ciclo* n7 =new Ciclo{0,n6};
Ciclo* n8 =new Ciclo{0,n7};
Ciclo* n9 =new Ciclo{0,n8};
Ciclo* n10 =new Ciclo{0,n9};
Ciclo* n11 =new Ciclo{0,n10};
Ciclo* n12 =new Ciclo{0,n11};
Ciclo* n13 =new Ciclo{0,n12};
Ciclo* n14 =new Ciclo{0,n13};
Ciclo* n15 =new Ciclo{0,n14};
Ciclo* n16 =new Ciclo{0,n15};
Ciclo* n17 =new Ciclo{0,n16};
Ciclo* n18 =new Ciclo{0,n17};
void criaValores(){
    n1->prox=n18;
    atual = n1;
}



void criaRoleta(){
    int array[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
    random_device rd;
    mt19937 g(rd()); 
    shuffle(begin(array), end(array), g);
    Ciclo* a = n1;
    for(int i=0;i<18;i++){
        a->info=array[i];
        a=a->prox;
    }

}

void giraRoleta(){
    Ciclo* atual=n1;
    int move = rand() % 42 + 1;  
    for (int i = 0; i < move; i++) {
        atual = atual->prox;
    }
}


int main(){
    srand(time(0));  
    criaValores();
    criaRoleta();    

    int escolha;
    cout << "Escolha um número entre 1-18: ";
    cin >> escolha;

    giraRoleta();
    cout << "Número sorteado: " << atual->info << endl;

    if (atual->info == escolha) {
        cout << "Você venceu!" << endl;
    } else {
        cout << "Você perdeu!" << endl;
    }
    return 0;
}
