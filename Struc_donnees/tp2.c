#include<stdio.h>
#include<stdlib.h>
#include<string.h>

typedef struct Salle{
	int id;
    int capacite;
    char libelle[100];
}Salle;


Salle CreerSAlle(int idSalle, char* libelleSalle, int capacite);
void SaisirInfosSalle(Salle Liste[], int n);
void AfficherSalle(Salle s);
void AfficherInfosSalle(Salle Liste[], int n);
int RechercherSalle(int id,Salle Liste[], int n);
void SupprimerSalle(int id,Salle Liste[], int *n);
void TrierSallesParLibelle(Salle Liste[], int n);
void Sauvegarder(Salle Liste[], int n);
void attendre();
int menu();


int main(){

	int n;
	int i,choix, m;
	Salle *Liste;
	char *info;
	
	menu : choix = menu();
	
	
	switch(choix){
		case 1 : {
			
			printf("Entrer le nombre de salle a remplir \n");
			scanf("%d", &n);
			
			Liste = (Salle *)malloc(n * sizeof(Salle));
			if(Liste != NULL){
				SaisirInfosSalle(Liste, n);
			}else{
				printf("Echec de l'allocation de la memoire \n");
				return 1;
			}
			
			printf("\t\nVoulez vous reconsulter le menu ? 1 - oui ");
			scanf("%d", &m);
			if(m==1){
				goto menu;
			}else{
	    		free(Liste);
				return 1;
				
			}
			
		}
		break;
		
		case 2 : {
			
			AfficherInfosSalle(Liste, n);
			
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
			int idr,tr;
			printf("\n\n\t Entrer l'id de la salle\n");
			scanf("%d", &idr);
			
			tr = RechercherSalle(idr,Liste, n);
			if(tr != -1){
				printf("\n Salle trouve a la position %d et son nom est %s\n", tr, Liste[tr].libelle);
			}else{
				printf("\n Salle non presente dans la liste\n");	
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
		
		case 4 : {
			TrierSallesParLibelle(Liste, n);
			
			printf("Apres le tri\n");
			AfficherInfosSalle(Liste, n);
			printf("\t\nVoulez vous reconsulter le menu ? 1 - oui ");
			scanf("%d", &m);
			if(m==1){
				goto menu;
			}else{
				return 1;
			}
		}
		break;

        case 5 : {
        	int idr,tr;
			printf("\n\n\t Entrer l'id de la salle a supprimer\n");
			scanf("%d", &idr);
			
			SupprimerSalle(idr,Liste, &n);
			
				
			printf("Apres suppression\n");
			AfficherInfosSalle(Liste, n);
			printf("\t\nVoulez vous reconsulter le menu ? 1 - oui ");
			scanf("%d", &m);
			if(m==1){
				goto menu;
			}else{
				return 1;
			}
		}
		break;

        case 6 : {
			printf("\tMerci d'avoir utiliser notre programme :-) a la prochaine \n");
			free(info);
		    free(Liste);
		    return 1;
		}
		break;
		
		default :{
			printf("\t\nVeiller entrer un choix valide"); 
			goto menu;
		} 
		
	}
	free(Liste);

    return 0;

}

Salle CreerSAlle(int idSalle, char* libelleSalle, int capacite){
    Salle s;
    s.id = idSalle;
    s.capacite = capacite;
    strcpy(s.libelle, libelleSalle);
    return s;
}


void SaisirInfosSalle(Salle Liste[], int n){
	int i;
    int idSalle; 
	char* libelleSalle; 
	int capacite;
    libelleSalle = (char *)malloc(50 * sizeof(char));
	for(i=0; i<n; i++){
		printf("\n\tRemplissage de la salle n*%d \n", i+1);
		
		printf("Donner son libelle\n");
		scanf(" %[^\n]", libelleSalle);
		
		printf("Donner son id\n");
		scanf("%d", &idSalle);		

		printf("Donner sa capacite\n");
		scanf("%d", &capacite);
	
		Liste[i] = CreerSAlle(idSalle, libelleSalle, capacite);
		
		printf("\n\tRemplissage de la salle n*%d reussit\n\n", i+1);
	}
}

void AfficherSalle(Salle s){
	printf("Id : %d - Libelle : %s - Capacite : %d \n", s.id, s.libelle, s.capacite);
}

void AfficherInfosSalle(Salle Liste[], int n){
	int i;
	printf("\n\n\t Affichage des electeurs \n");
	for(i=0; i<n; i++){
		AfficherSalle(Liste[i]);
	}
}

int RechercherSalle(int id,Salle Liste[], int n){
	int i;
	for(i=0; i<n; i++){
		if(Liste[i].id == id){
			return i;
		}
	}
	return -1;
}


void SupprimerSalle(int id,Salle Liste[], int *n){
	int i;
	int x=0,v=0;	
	for(i=0; i<*n; i++){
		if(Liste[x].id != id){
			Liste[v] = Liste[x];
			v++; 
		}
		x++;
	}
	*(n)--;
}

void TrierSallesParLibelle(Salle Liste[], int n){
	int i,j;
	for(i=0; i<n; i++){
		for(j=i+1; j<n; j++){
			if(strcmp(Liste[j].libelle, Liste[i].libelle)<0){
				Salle temp;
				temp = Liste[i];
				Liste[i] = Liste[j];
				Liste[j] = temp;
			}
		}	
	}
	
}



int menu(){
    int choix;
	printf("\t\n\n--------------------------------MEMU----------------------------------------\n\n");
	printf("\t\t 1 -  Enregistrer des Salles \n");
	printf("\t\t 2 -  Afficher les Salles \n");
	printf("\t\t 3 -  Rechercher une Salle \n");
    printf("\t\t 4 -  Trier des Salles \n");
    printf("\t\t 5 -  Supprimer une Salle \n");
	printf("\t\t 6 -  Quitter \n");
	printf("\t\n-------------------------------------------------------------------------------\n\n");
	
	printf("\t Veiller entrer votre choix svp\n");
	scanf("%d", &choix);
	return choix;
}
