#include <iostream>
using namespace std;


int main(int argc, char** argv){
    int ocorrencias[256]={0};
    if (argc != 2){
        fprintf(stderr, "Erro na chamada do comando.\n");
        fprintf(stderr,"Uso: %s [ARQUIVO ORIGEM]", argv[0]);
        return 1;
    }
    FILE *entrada = fopen(argv[1], "rb"); 
    int c = fgetc(entrada);
    while( c !=EOF){
        ocorrencias[c]++;
        c=fgetc(entrada);
    }
    fclose(entrada);
    cout << ocorrencias;
    return 0; 

}
