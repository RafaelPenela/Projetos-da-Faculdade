#include <iostream>
#include <stdlib.h>

using namespace std;

struct Linha{
    string info; 
    Linha* prox;
    Linha* ant;    
};
Linha* Topo=nullptr;
Linha* Fim=nullptr;


void inserir(){
    string frase;
    cout << "Digite sua frase" <<endl;
    cin.ignore();
    getline(cin, frase);
    Linha* novo = new Linha();
    novo->info = frase;
    novo->prox=nullptr;
    novo->ant=Fim;
    if (Fim!=nullptr){
        Fim->prox=novo;
    } else {
        novo->ant=nullptr;
        Topo= novo;
    }
    Fim = novo;
    cout << novo->info << endl;
}

void excluir(int p){
    Linha* aux = Topo;
    int c=1;
    for(int c=1;c!=p;c++){
        aux=aux->prox;
    }

  if(aux==Topo && aux==Fim){
        Topo=nullptr;
        Fim=nullptr;
    } else if(aux==Topo){
        aux->prox->ant=nullptr;
        Topo=aux->prox;
    } else if (aux==Fim){
        aux->ant->prox=nullptr;
        Fim=aux->ant;
    } else {
        aux->prox->ant=aux->ant;
        aux->ant->prox=aux->prox;
    }

    delete aux;
    cout << "Linha " << p << " excluído com sucesso!" << endl;
} 



void listar(){
    Linha* aux=Fim;
    while(aux!=nullptr){
        cout << aux->info <<endl;
        aux=aux->ant;
    }

}


void mover(int pi, int pf){
    Linha* aux1=Topo;
    Linha* aux2=Topo;
    for(int c1=1;c1!=pi;c1++){
        aux1=aux1->prox;                
    }
    for(int c2=1;c2!=pf;c2++){
        aux2=aux2->prox;                
    }


    if(aux2==nullptr){
        string temp = aux1->info; 
        aux1->info=Fim->info;
        Fim->info=temp;
    } else {
        string temp = aux1->info;
        aux1->info=aux2->info;
        aux2->info=temp;
    }
}



int exibirMenu() {
    int escolha;
    std::cout << "\n=== Editor de Texto ===" << std::endl;
    std::cout << "1. Inserir linha" << std::endl;
    std::cout << "2. Excluir linha" << std::endl;
    std::cout << "3. Listar texto" << std::endl;
    std::cout << "4. Mover linha" << std::endl;
    std::cout << "0. Sair" << std::endl;
    std::cout << "Escolha uma opção: ";
    std::cin >> escolha;
    return escolha;
}


void executarEditor() {
    int opcao;
    do {
        opcao = exibirMenu();
        switch (opcao) {
            case 1: {
                inserir();
                break;
            }
            case 2: {
                int linha;
                std::cout << "Digite o número da linha a ser excluída: ";
                std::cin >> linha;
                excluir(linha);
                break;
            }
            case 3: {
                listar();
                break;
            }
            case 4: {
                int linhaOrigem, linhaDestino;
                std::cout << "Digite o número da linha a ser movida: ";
                std::cin >> linhaOrigem;
                std::cout << "Digite a nova posição da linha: ";
                std::cin >> linhaDestino;
                mover(linhaOrigem, linhaDestino);
                break;
            }
            case 0: {
                std::cout << "Saindo do editor..." << std::endl;
                break;
            }
            default: {
                std::cout << "Opção inválida! Tente novamente." << std::endl;
                break;
            }
        }
    } while (opcao != 0);
}

int main() {
    executarEditor();
    return 0;
}
