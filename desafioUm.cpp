#include <iostream>
using namespace std;


struct Consumo {
    int cod;
    Consumo* prox;
};


struct Cliente {
    int info; 
    Consumo* p; 
    Cliente* prox; 
    Cliente* ant; 
};


Cliente* T = nullptr;
Cliente* F = nullptr;


void chegadaCliente(int id) {
    Cliente* novo = new Cliente{ id, nullptr, nullptr, F };
    if (F != nullptr) {
        F->prox = novo;
    } else {
        T = novo; 
    }
    F = novo; 
    cout << "Cliente " << id << " adicionado com sucesso!" << endl;
}


void consumoCliente(int id, int cod) {
    Cliente* atual = T;
    while (atual != nullptr) {
        if (atual->info == id) {
            Consumo* novoConsumo = new Consumo{ cod, nullptr };
            if (atual->p == nullptr) {
                atual->p = novoConsumo; 
            } else {
                Consumo* temp = atual->p;
                while (temp->prox != nullptr) {
                    temp = temp->prox; 
                }
                temp->prox = novoConsumo;
            }
            cout << "Consumo " << cod << " registrado para o cliente " << id << "!" << endl;
            return;
        }
        atual = atual->prox;
    }
    cout << "Cliente " << id << " não encontrado!" << endl;
}


void saidaCliente(int id) {
    Cliente* atual = T;
    while (atual != nullptr) {
        if (atual->info == id) { 
            cout << "Consumos do cliente " << id << ":" << endl;
            Consumo* consumoAtual = atual->p;
            while (consumoAtual != nullptr) {
                cout << " - " << consumoAtual->cod << endl;
                Consumo* temp = consumoAtual;
                consumoAtual = consumoAtual->prox;
                delete temp; 
            }

            
            if (atual->ant != nullptr) {
                atual->ant->prox = atual->prox;
            } else {
                T = atual->prox; 
            }
            if (atual->prox != nullptr) {
                atual->prox->ant = atual->ant;
            } else {
                F = atual->ant; 
            }

            delete atual; 
            cout << "Cliente " << id << " removido com sucesso!" << endl;
            return;
        }
        atual = atual->prox; 
    }
    cout << "Cliente " << id << " não encontrado!" << endl;
}


void exibirMenu() {
    cout << "\n--- MENU ---" << endl;
    cout << "1. Adicionar cliente" << endl;
    cout << "2. Registrar consumo" << endl;
    cout << "3. Remover cliente" << endl;
    cout << "4. Sair" << endl;
    cout << "Escolha uma opção: ";
}

int main() {
    int opcao;
    int idCliente, codConsumo;
    int proximoIdCliente = 100;

    while (true) {
        exibirMenu();
        cin >> opcao;

        switch (opcao) {
            case 1: 
                chegadaCliente(proximoIdCliente);
                proximoIdCliente += 100; 
                break;

            case 2:
                cout << "Digite o ID do cliente: ";
                cin >> idCliente;
                cout << "Digite o código do consumo: ";
                cin >> codConsumo;
                consumoCliente(idCliente, codConsumo);
                break;

            case 3: 
                cout << "Digite o ID do cliente: ";
                cin >> idCliente;
                saidaCliente(idCliente);
                break;

            case 4: 
                cout << "Saindo..." << endl;
                return 0;

            default:
                cout << "Opção inválida! Tente novamente." << endl;
                break;
        }
    }

    return 0;
}
