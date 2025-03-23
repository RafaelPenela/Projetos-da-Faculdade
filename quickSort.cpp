#include <iostream>
#include <utility>
using namespace std;

int aloca(int A[], int inicio, int fim) {
    int pivo = A[fim];  // Escolhendo o último elemento como pivô
    int i = inicio - 1;

    for (int j = inicio; j < fim; j++) {
        if (A[j] <= pivo) {
            i++;
            swap(A[i], A[j]);
        }
    }
    swap(A[i + 1], A[fim]);  // Coloca o pivô na posição correta
    return i + 1;  // Retorna o índice do pivô
}

void qs(int A[], int inicio, int fim) {
    if (inicio < fim) {  // Caso base
        int pivoIndex = aloca(A, inicio, fim);
        qs(A, inicio, pivoIndex - 1);  // Recursão para a parte esquerda
        qs(A, pivoIndex + 1, fim);      // Recursão para a parte direita
    }
}

int main() {
    int n;
    cout << "Digite o tamanho do array: ";
    cin >> n;
    int A[n];
    for (int c = 0; c < n; c++) {
        cout << "Digite o valor da " << c + 1 << "ª posição do array: ";
        cin >> A[c];
    }

    qs(A, 0, n - 1);  // Chama a função de ordenação

    cout << "Array ordenado: ";
    for (int c = 0; c < n; c++) {
        cout << A[c] << " ";
    }
    cout << endl;

    return 0;
}
