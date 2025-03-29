#include <iostream>
using namespace std;

#include <stdio.h>



int main(int argc, char** argv){
    if (argc != 2){
        fprintf(stderr, "Erro na chamada do comando.\n");
        fprintf(stderr,"Uso: %s [ARQUIVO ORIGEM]", argv[0]);
        return 1;
    }
    FILE *entrada = fopen(argv[2], "rb"); 
    int linhas = 1;
    char caracter = fgetc(entrada);
    while(caracter!=EOF){}
        if(caracter == '\n'){
            linhas++;
            caracter = fgetc(entrada);
    }
    fclose(entrada);
    cout << linhas;
    return 0; 

}


/*void gera() {
    FILE *file = fopen("dados.txt", "w");
    if (file == NULL) {
        printf("Erro ao criar o arquivo!\n");
        return;
    }
    fprintf(file, "Nome: João\n");
    fprintf(file, "Idade: 25\n");
    fprintf(file, "Cidade: São Paulo\n");
    fclose(file);
    printf("Arquivo 'dados.txt' criado com sucesso!");
}*/ //usado para testar o codigo 
