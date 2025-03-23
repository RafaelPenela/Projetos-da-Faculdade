#include <iostream>
using namespace std;
#define TAMANHO 8192

int main(int argc, char** argv){
    FILE *entrada, *saida;
    int qtd;
    char buffer[TAMANHO];

    if(argc != 3){
        fprintf(stderr, "Erro na chamada do comando.\n");
        fprintf(stderr,"Uso: %s [ARQUIVO ORIGEM] [ARQUIVO DESTINO]", argv[0]);
        return 1;
    }
    entrada = fopen(argv[1], "rb");
    if(!entrada){
        fprintf(stderr, "Arquivo %s não pode ser aberto para leitura", argv[1]);
        return 1;
    }
    saida = fopen(argv[2], "wb");
    if(!saida){
        fclose(entrada);
        fprintf(stderr, "Arquivo %s nõ pode ser aberto para escrita", argv[2]);
        return 1;
    }


    qtd = fread(buffer, sizeof(char),TAMANHO, entrada);
    while (qtd>0){
        fwrite(buffer,sizeof(char),qtd,saida);
        qtd = fread(buffer, sizeof(char),TAMANHO, entrada);
    }
    fclose(entrada);
    fclose(saida);
    return 0;
}
