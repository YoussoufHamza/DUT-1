#include<stdio.h>
#include<stdlib.h>
#include<string.h>

typedef struct voiture{
	char modele[100];
	int annee;
	char type[100];
	float prix;
}voiture;

typedef struct noeud{
	voiture *v1;
	struct noeud *suivant;
}noeud;

typedef struct liste_voiture{
	noeud *liste;
}liste_voiture; 

int menu();
voiture* ajout();
void ajouterVoiture(liste_voiture *lv);
void afficherVoiture(liste_voiture *lv);
void supprimerVoiture(liste_voiture *lv, char *modele);

int main(){
	int choix,m;
	char *modele;
	modele = (char *)malloc(100 * sizeof(char));
	liste_voiture *liste;
	liste = (liste_voiture*)malloc(sizeof(liste_voiture));
	liste->liste = NULL;
	menu : choix = menu();
	
	
	switch(choix){
		case 1 : {
			
			ajouterVoiture(liste);
			
			printf("\t\nVoulez vous reconsulter le menu ? 1 - oui ");
			scanf("%d", &m);
			if(m==1){
				goto menu;
			}else{
				return 1;
				
			}
			
		}
		break;
		
		case 2 : {
			
			afficherVoiture(liste);
			
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
			
			printf("Entrer le modele a supprimer \n\n");
			scanf(" %[^\n]", modele);
			
			supprimerVoiture(liste, modele);
			
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

voiture* ajout(){
	voiture *v1;
	v1 = (voiture *)malloc(sizeof(voiture));
	if(v1 != NULL){
			
		printf("Rmplissage de la voiture \n");
		
		printf("Donner son modele ");
		scanf(" %[^\n]", &v1->modele);
		
		printf("Donner son annee ");
		scanf("%d", &v1->annee);
		
		printf("Donner son type ");
		scanf(" %[^\n]", &v1->type);
		
		printf("Donner son prix en DH ");
		scanf("%f", &v1->prix);
		
		printf("\n\n Remplissage reussi \n\n");
		
		return v1;
	}
	else{
		printf("Echec d'alloction de la memoire ");
		return NULL;
	}

}

void ajouterVoiture(liste_voiture *lv){
	noeud *n1;
	n1 = (noeud *)malloc(sizeof(noeud));
	if(n1!=NULL){
		n1->v1 = ajout();
		n1->suivant = lv->liste;
		lv->liste = n1;	
	}else{
		printf("Echec d'alloction de la memoire ");	
	}
}

void afficherVoiture(liste_voiture *lv){
	int i=1;
	noeud *n1;
	n1 = (noeud *)malloc(sizeof(noeud));
	
	n1 = lv->liste;
	while(n1 != NULL){
		printf("INformations concernant la %d voiture \n\n", i);
		printf("Modele : %s - Annee : %d - Type : %s - Prix : %f DH \n\n", n1->v1->modele, n1->v1->annee, n1->v1->type, n1->v1->prix);
		i++;
		n1 = n1->suivant;
	}
	
}

void supprimerVoiture(liste_voiture *lv, char *modele){
	noeud *n1;
	n1 = (noeud *)malloc(sizeof(noeud));
	
	n1 = lv->liste;
	if((n1 == NULL)){
		printf("Liste vide");	
		return;
	}
	while((n1->suivant != NULL)){
		if((strcmp(n1->suivant->v1->modele, modele)==0) && (n1->suivant->suivant != NULL)){
			n1->suivant = n1->suivant->suivant;
			lv->liste = n1;
			break;
		}else if((strcmp(n1->v1->modele, modele)==0) && (n1->suivant != NULL)){
			n1 = n1->suivant;
			lv->liste = n1->suivant;	
			break;
		}else{
			n1 = n1->suivant;
		}
	}
}


int menu(){
    int choix;
	printf("\t\n\n--------------------------------MEMU----------------------------------------\n\n");
	printf("\t\t 1 -  Ajouter une voiture au parc \n");
	printf("\t\t 2 -  Afficher le parc  \n");
	printf("\t\t 3 -  Supprimer une voiture du parc grace a son modele \n");
	printf("\t\t 4 -  Quitter \n");
	printf("\t\n-------------------------------------------------------------------------------\n\n");
	
	printf("\t Veiller entrer votre choix svp\n");
	scanf("%d", &choix);
	return choix;
}
