#include <iostream>
using namespace std;

int main(int argc, char** argv){
    FILE *entrada, *saida;
    int c;
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

    c = fgetc(entrada); //<fgetc> le um byte do arquivo(primeiro)
    while(c != EOF){  //<EOF> significa 'end of file' e tem valor -1
        fputc (c, saida); //copia um valor 'c' para um arquivo 'saida'

/*OBS: em arquivos sempre que ler ou escrever em um arquivo a posição avança em um automaticamente*/

        c= fgetc(entrada);
    }

    fclose(entrada);
    fclose(saida);
    return 0;
}
