#include<stdio.h>
#include<stdlib.h>
#include<string.h>

typedef struct electeur{
	char nom[100];
	char CIN[100];
	char prenom[100];
	char date_naissance[30];
	char NCM[50];
}elc;

void lecture(elc *t, int n);
void elecc(elc *t, int n, char *cin, char *ncm);
char* retinfo(elc *t);
void menu();


int main(){
   
	int n;
	int i,choix, m;
	elc *Tabelec;
	char *info;
	
	menu : menu();
	scanf("%d", &choix);
	
	switch(choix){
		case 1 : {
			printf("Entrer le nombre d'electeur a remplir svp \n");
			scanf("%d", &n);
		
			Tabelec = (elc *)malloc(n * sizeof(elc));
			if(Tabelec ==NULL){
				printf("Erreur d'allocation de memoire \n");
			}else{
				lecture(Tabelec, n);
			}
			
			printf("\t\nVoulez vous reconsulter le menu ? 1 - oui ");
			scanf("%d", &m);
			if(m==1){
				goto menu;
			}else{
	    		free(Tabelec);
				return 1;
				
			}
			
		}
		break;
		
		case 2 : {
			info = (char *)malloc(200 * sizeof(char));
			
			printf("\n\n\t Affichage des electeurs \n");
			for(i=0; i<n; i++){
				info = retinfo(&Tabelec[i]);
				printf(" %s \n", info);
			}
			
			printf("\t\nVoulez vous reconsulter le menu ? 1 - oui ");
			scanf("%d", &m);
			if(m==1){
				goto menu;
			}else{
				return 1;
			}
			
		}
		break;
		
		case 3 : {
			char *cin;
			cin = (char *)malloc(100 * sizeof(char));
			char *ncm;
			ncm = (char *)malloc(100 * sizeof(char));
			
			printf("\n\n\t Entrer le numero de cin de l'electeur \n");
			scanf(" %[^\n]", cin);
			
			elecc(Tabelec, n, cin, ncm);
			
			printf("\t\nVoulez vous reconsulter le menu ? 1 - oui ");
			scanf("%d", &m);
			if(m==1){
				goto menu;
			}else{
				return 1;
			}
			
		}
		break;
		
		case 4 : {
			printf("\tMerci d'avoir utiliser notre programme :-) a la prochaine \n");
			free(info);
		    free(Tabelec);
		    return 1;
		}
		break;
		
		default :{
			printf("\t\nVeiller entrer un choix valide"); 
			goto menu;
		} 
		
	}

    return 0;

}

void lecture(elc *t, int n){
	int i;
	for(i=0; i<n; i++){
		printf("\n\tRemplissage de l'electeur n*%d \n", i+1);
		
		printf("Donner son nom\n");
		scanf(" %[^\n]", &t[i].nom);
		
		printf("Donner son prenom\n");
		scanf(" %[^\n]", &t[i].prenom);		

		printf("Donner son n* de cin\n");
		scanf(" %[^\n]", &t[i].CIN);
	
		printf("Donner son numero de carte d'electeur \n");
		scanf(" %[^\n]", &t[i].NCM);

		printf("Donner sa date de naissance\n");
		scanf(" %[^\n]", t[i].date_naissance);
		
		printf("\n\tRemplissage de l'electeur n*%d reussit\n\n", i+1);
	}
}

char* retinfo(elc *t){
	char *info;
	info = (char *)malloc(200 * sizeof(char));
	if(info != NULL){

		strcpy(info, t->nom);
		strcat(info, " ");
		strcat(info, t->prenom);
		strcat(info, ", ");
		strcat(info, t->CIN);
		strcat(info, ", ");
		strcat(info, t->date_naissance);
		strcat(info, ", ");
		strcat(info, t->NCM);
	}else{
		printf("Erreur d'allocation de memoire \n");
	}
	
	return info;
}

void elecc(elc *t, int n, char *cin, char *ncm){
	int i, tr=0;
	for(i=0; i<n; i++){
		if(strcmp(t[i].CIN, cin)==0){
			tr = 1;
			break;
		}
	}	
	
	if(tr == 1){
		strcpy(ncm, t[i].NCM);
		printf(" N* d'electeur : %s \n", ncm);
	}else{
		printf(" Electeur non enregistre dans le systeme \n");
	}
}

void menu(){
	printf("\t\n\n--------------------------------MEMU----------------------------------------\n\n");
	printf("\t\t 1 -  Enregistrer des electeurs \n");
	printf("\t\t 2 -  Afficher les electeurs \n");
	printf("\t\t 3 -  Rechercher un electeur grace a sa CIN \n");
	printf("\t\t 4 -  Quitter \n");
	printf("\t\n-------------------------------------------------------------------------------\n\n");
	
	printf("\t Veiller entrer votre choix svp\n");
}
