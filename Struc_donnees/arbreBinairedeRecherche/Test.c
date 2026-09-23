#include<stdio.h>
#include<stdlib.h>
#include<string.h>

typedef struct Arbre{
	int valeur;
	struct Arbre *parent;
	struct Arbre *left;
	struct Arbre *right;	
}Arbre;

Arbre *parent;

Arbre *init_Arbre(){
	return NULL;
}

void Menu(){
	printf("\ti - Ajout d'un elt \n");
	printf("\tp - Affichage de l'abre \n");
	printf("\ts - rechercher dans l'arbre \n\n");
	printf("\n\n\tFaite un choix \n\n");
}

void AfficherArbre(Arbre *abr){
	if(abr==NULL){
		return;
	}
	else{
		AfficherArbre((abr->left));
		printf(" - %d ", abr->valeur);
		AfficherArbre((abr->right));
	}
}

Arbre* RechercherValeur(Arbre *abr, int x){
	if(abr==NULL){
		return NULL;
	}else{
		if(abr->valeur == x){
			return abr;
		}else if(abr->valeur>x){
			RechercherValeur((abr->left), x);
		}else{
			RechercherValeur((abr->right), x);
		}
	}
}

void InsererValeur(Arbre **abr, int x, Arbre *parent){
	Arbre *temp;
	if(*abr == NULL){
		temp = (Arbre *)malloc(sizeof(abr));
		temp->valeur = x;
		temp->parent = parent;
		temp->right = temp->left = NULL;
		*abr = temp;
		return;		
	}	
	if((*abr)->valeur>=x){
		InsererValeur(&((*abr)->left), x, *abr);
	}else{
		InsererValeur(&((*abr)->right), x, *abr);
	}
}


int main(){
   	char choix;
   	int d;
   	Arbre *abr;
   	Arbre *tmp;
   	tmp = init_Arbre();
   	abr = init_Arbre();
   	
   		tache : Menu();
   		while (scanf("%c", &choix) != EOF) {
		    if (tolower(choix) == 'p') {
			    AfficherArbre(abr);
			    printf("\n");
			    goto tache;
		    }
		    if (tolower(choix) == 'i') {
		    	printf("Entrer un elet \n\n");
			    scanf("%d", &d);
			    printf("Nouvelle elt: %d\n", d);
			   	InsererValeur(&abr, d, NULL);
			    goto tache;
		    }
		    if (tolower(choix) == 's') {
		    	printf("Entrer un elet \n\n");
			    scanf("%d", &d);
			    tmp = RechercherValeur(abr, d);
			    if (tmp == NULL) {
			        printf("Elt %d non trouve\n",d);
			    } else {
			        printf("Elt %d trouve\n",d);
			    }
			    goto tache;
		    }
	    }
	
    return 0;

}




