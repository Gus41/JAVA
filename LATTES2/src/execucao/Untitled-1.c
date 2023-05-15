#include <stdio.h>
#include <stdlib.h>
#include <string.h>
//--------------------------------STRUCT
struct nodo{
	char palavra[30];
	int qnt;
	struct nodo *prox;
};
typedef struct nodo PALAVRA;
PALAVRA *inicio;
//------------------------------- INSERE
void insere(char p[]){
	PALAVRA *novo, *aux;
	int flag = 0;
	novo = (PALAVRA *)malloc(sizeof(PALAVRA));
	strcpy(novo->palavra , p );
	novo->qnt = 1;
	if( inicio == NULL ){
		novo->prox = NULL;
		inicio = novo;
	}else{
		aux = inicio;
		while ( aux != NULL ){
			if( strcmp(aux->palavra , p ) == 0){
				aux->qnt++;
				flag = 1;
			}
			aux = aux->prox;
		}
		if( flag == 0 ){
			novo->prox = inicio;
			inicio = novo;
		}
	}
}
//-------------------------------- EXECUTE
void execute(char frase[]){
        
    int i,j,p,vazio,vazioANT;
    char palavra[30];
    vazioANT = 0;
    
    int cont = 0;
    for ( i = 0 ; frase[i] != '\0' ; i++ ){
    	if( (frase[i] == ' ' && frase [i+1] == ' ') || (frase[i] == ' ' && frase[i+1] == '\0' && strlen(frase) < 2 ) ){
    		printf("Muitos espaços vazios seguidos, por favor insira a frase novamente:\n");
    		return;
		}
	}
    printf("\n----EXECUTE FRASE : %s \n",frase);
    for ( i = 0 ; frase[i] != '\0' ; i++ ){
        p = 0;
        if(frase[i] == ' ' || frase[i+1] == '\0'){ // checagem de caractere vazio (separação de palavras)
        
            if(frase[i+1] == '\0'){
                vazio = i+1;
            }else{
                vazio = i;
            }
            for( j = vazioANT+1 ; j < vazio ; j ++ ){
                if( j == 1 && p == 0 ){
                    j=0;
                }
                palavra[p] = frase[j];    
                p++;    
            }
            if(palavra[p-1] == ' ' || palavra[p-1] == '\n'){
            	palavra[p-1] = '\0';
            	printf("----CARACTERE VAZIO  RETIRADO---");
			}else{
				palavra[p] = '\0';
			}
            printf("\n-----executando palavra: %s------\n",palavra);
            insere(palavra);    
            vazioANT = vazio;
            for ( j = 0 ; j < p ; j ++){
                palavra[j] = '\0';
            }    
        }
    }
    printf("\n-----TEXTO INSERIDO COM SUCESSO------\n");
    printf("-Digite qulquer tecla para continuar:\n");
	getchar();
}
//-------------------------------ARQUIVO
void arquivo(char arq[]){
	FILE *pont;
	char Frase[200];
	pont = fopen(arq,"r");
	
	if( pont == NULL ){
		printf("Arquivo não encontrado");
		exit(0);
	}else{
		printf("Arquivo encontrado\n");
	}
	
	
    fgets(Frase, 100, pont); 
    fclose(pont);
	printf("--\n%s \n",Frase);
	execute(Frase);
}
//---------------------------------
void consultafrase(){
	char palavra[30];
	int i;
	
	printf("\n---------------------\n");
	printf("Digite a palavra que deseja consultar: ");
	gets(palavra);
	
	i = 0;
	while( palavra[i] != '\0' ){
		i++;
	}
	if(palavra[i-1] == ' ' || palavra[i-1] == '\n'){
    	palavra[i-1] = '\0';
    	printf("\n----CARACTERE VAZIO RETIRADO---\n");
	}
	PALAVRA *aux = inicio;
	int flag = 0;
	while( aux != NULL ){
		if( strcmp(aux->palavra , palavra) == 0 ){
			printf("\n---PALAVRA ENCONTRADA---\n");
			printf("Palavra: %s\n",aux->palavra);
			printf("Quantidade: %d\n",aux->qnt);
			printf("---------------\n");
			flag = 1;
			break;
		}
		aux = aux->prox;
	}
	if( flag == 0 ){
		printf("--ERRO--\n--Palavra nao encontrada na lista atual--\n");
	}
	printf("-Digite qulquer tecla para continuar:\n");
	getchar();
	
	
}
//--------------------------------- REMOVE
void remove(){
	char palavra[30];
	PALAVRA *aux = inicio, *ant = inicio;;
	printf("Digite a palavra que deseja remover: ");
	gets(palavra);
	int flag = 0;
	if( inicio == NULL ){
		return;
	}else if ( strcmp(inicio->palavra , palavra) == 0 ){
		inicio = inicio->prox;
		flag = 1;
	}else{
		while ( aux != NULL ){
			if( strcmp(aux->palavra , palavra) == 0 ){
				ant->prox = aux->prox;
				flag = 1;
			}
			ant = aux;
			aux = aux->prox;
		}
	}
	if( flag == 0 ){
		printf("\n==PALAVRA NAO ENCONTRADA NA LISTA==\n");
	}else{
		printf("\n==PALAVRA REMOVIDA COM SUCESSO==\n");
	}
	
}
//---------------------------------- CONTA OCORRENCIAS
void contaOC(){
	char palavra[30];
	int cont = 0;
	PALAVRA *aux = inicio;
	printf("--Digite a palavra que deseja pesquisar: ");
	gets(palavra);
	while(aux != NULL ){
		if(strcmp(aux->palavra , palavra ) == 0){
			cont = aux->qnt;
			break;
		}
		aux = aux->prox;
	}
	printf("\nA palavra %s ocorre %d vezes\n",palavra,cont);
	printf("-Digite qulquer tecla para continuar:\n");
	getchar();
}
//---------------------------------- CONTA PALAVRAS
void contaP(){
	PALAVRA *aux = inicio;
	int cont = 0;
	while( aux != NULL ){
		aux = aux->prox;
		cont++;
	}
	printf("\n====SUA LISTA TEM %d ELEMENTOS====\n",cont);
	printf("-Digite qulquer tecla para continuar:\n");
	getchar();
}
//--------------------------------- MENU
int menu(){
	int n;
	
	printf("==============MENU==============\n");
	printf("1 - INSERIR UMA PALAVRA/TEXTO\n");
	printf("2 - MOSTRAR A LISTA ATUAL DE PALAVRAS\n");
	printf("3 - CONSULTAR PALAVRA\n");
	printf("4 - REMOVER PALAVRA\n");
	printf("5 - CONTAR QUANTAS PALAVRAS TEM\n");
	printf("6 - CONTA OCORRENCIAS\n");
	printf("0 - SAIR\n");
	scanf("%d",&n);
	getchar();
	
	return n;
	
}
//--------------------------- ESCREVE
void escreve(){
	PALAVRA *aux = inicio;
	printf("===PALAVRAS===\n");
	while ( aux != NULL ){
		printf("Palavra : %s\n",aux->palavra);
		printf("Quantidade : %d\n", aux->qnt);
		aux = aux->prox;
		printf("-------\n");
	}
	printf("-Digite qulquer tecla para continuar:\n");
	getchar();
}
//--------------------------- ESCREVE ALF
void escrevealf(){
	
	
}
//--------------------------- MAIN
int main(){
	
	int n = -1;
	int op;
	char frase[200];
	char arq[20];
	
	
	while ( n != 0 ){
		n = menu();
		if( n == 1 ){
			printf("Digite a maneira que deseja insereir a frase: \n");
			printf("1 - Digitar \n");
			printf("2 - Por arquivo txt \n");
			scanf("%d",&op);
			getchar();
			if( op == 1 ){
				printf("Digite a frase: ");
				gets(frase);
				execute(frase);
			}else{
				printf("Digite o nome do arquivo de texto: ");
				gets(arq);
				arquivo(arq);		
				
			}
		}else if( n == 2 ){
			printf("Digite a forma que deseja consultar: \n");
			printf("1 - Em ordem alfabetica: \n");
			printf("2 - Em ordem de aparicao: \n");
			scanf("%d",&op);
			if( op == 1 ){
				escrevealf(); // a fazer
			}else{
				escreve();
			}
		}else if( n == 3 ){
			consultafrase();
		}else if( n == 4 ){
			remove();
		}else if( n == 5 ){
			contaP();
		}else if ( n == 6 ){
			contaOC();
		}
	}
}