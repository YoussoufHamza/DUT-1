#include<stdio.h>
#include<stdlib.h>
#include<string.h>

typedef struct Produit{
	int refProduit;
	char designation[20];
	float prixUnitaire;
	int QuantiteStock;
	int QuantiteSeuil;
}prod;


FILE* Creer_produit();
prod Ajout();
void Ajouter_produit(FILE *Produit);
void Lister_prod(FILE *Produit);
void Rechercher_produit(int refProduit,FILE *Produit);
void Supprimer_produit(int refProduit,FILE *Produit);
void Augmenter_prix(FILE *Produit);
int menu();


int main(){

	int n;
	int i,choix, m;
	FILE *Liste;
	char *info;
	
	menu : choix = menu();
	
	
	switch(choix){
		case 1 : {
			
			Liste = Creer_produit();
			if(Liste != NULL){
				printf("Creation du fichier execute avec succes \n");
			}else{
				printf("Echec de la creation du fichier \n");
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
			
			Lister_prod(Liste);
			
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
			
			Ajouter_produit(Liste);
			
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
			int idr,tr;
			printf("\n\n\t Entrer la reference  du produit svp\n");
			scanf("%d", &idr);
			
			Rechercher_produit(idr,Liste);
			
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
			printf("\n\n\t Entrer la reference  du produit a supprimer\n");
			scanf("%d", &idr);
			
			Supprimer_produit(idr,Liste);
			
				
			printf("Apres suppression\n");
			Lister_prod(Liste);
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
			
			Augmenter_prix(Liste);
			
			printf("Apres augmentation\n");
			Lister_prod(Liste);
			
			printf("\t\nVoulez vous reconsulter le menu ? 1 - oui ");
			scanf("%d", &m);
			if(m==1){
				goto menu;
			}else{
				return 1;
			}
			
		}
		break;

        case 7 : {
			printf("\tMerci d'avoir utiliser notre programme :-) a la prochaine \n");
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

FILE* Creer_produit(){
	FILE *fichier = fopen("Produit.txt", "a");
	if(fichier != NULL){
		return fichier;
	}else{
		return NULL;
	}
}


prod Ajout(){
	prod P;
	
	printf("\n\tRemplissage du produit \n");
	
	printf("Donner sa reference\n");
	scanf("%d", &P.refProduit);
		
	printf("Donner sa designation\n");
	scanf(" %[^\n]", P.designation);
				

	printf("Donner son prix unitaire\n");
	scanf("%f", &P.prixUnitaire);
	
	printf("Donner sa quantite en stock\n");
	scanf("%d", &P.QuantiteStock);
	
	printf("Donner sa quantite seuil\n");
	scanf("%d", &P.QuantiteSeuil);
		
	printf("\n\tRemplissage du produit reussit\n\n");
	 
	return P;
}

void Ajouter_produit(FILE *Produit){
	prod P;
	char choix;
	Produit = fopen("Produit.txt", "a");
	do{
		P = Ajout();
		fprintf(Produit, " %d  %s %f %d %d \n", P.refProduit, P.designation, P.prixUnitaire, P.QuantiteStock, P.QuantiteSeuil);
		printf("Voulez vous ajouter un autre produit au fichier oui : O/o \n");
		scanf("%s", &choix);
	}while((choix == 'O') || (choix == 'o'));
	fclose(Produit);
	printf("Ajout des produits termines avec succes \n\n");
}

void Lister_prod(FILE *Produit){
	int i=1;
	prod P;
	Produit = fopen("Produit.txt", "r");
	while(fscanf(Produit, " %d %s %f %d %d \n", &P.refProduit, &P.designation, &P.prixUnitaire, &P.QuantiteStock, &P.QuantiteSeuil) != EOF){
		printf("id : %d - Reference : %d - Designation : %s - Prix unitaire : %f - Quantite en stock : %d - Quantite seuil : %d \n", i,P.refProduit, P.designation, P.prixUnitaire, P.QuantiteStock, P.QuantiteSeuil);	
		i++;
	}
	fclose(Produit);
}


void Rechercher_produit(int refProduit,FILE *Produit){
	int tr=0;
	prod P;
	Produit = fopen("Produit.txt", "r");
	while(fscanf(Produit, " %d %s %f %d %d \n", &P.refProduit, &P.designation, &P.prixUnitaire, &P.QuantiteStock, &P.QuantiteSeuil) != EOF){
		if(P.refProduit == refProduit){
			tr = 1;
			break;
		}
	}
	if(tr == 1){
		printf("Reference : %d - Designation : %s - Prix unitaire : %f - Quantite en stock : %d - Quantite seuil : %d \n",P.refProduit, P.designation, P.prixUnitaire, P.QuantiteStock, P.QuantiteSeuil);	
	}else{
		printf("Produit non present dans le fichier \n\n");
	}
	fclose(Produit);
}


void Supprimer_produit(int refProduit,FILE *Produit){
	int t=0;
	char choix;
	prod P;
	
	Produit = fopen("Produit.txt", "r");
	while(fscanf(Produit, " %d %s %f %d %d \n", &P.refProduit, &P.designation, &P.prixUnitaire, &P.QuantiteStock, &P.QuantiteSeuil) != EOF){
		if(P.refProduit == refProduit){
			t=1;
			break;
		}
	}
	if(t==1){
		printf("Produit trouve voulez vous le supprimer O/o \n");
		scanf("%s", &choix);
		
		if((choix == 'O') || (choix == 'o')){;
			fclose(Produit);
			FILE *temp = fopen("temp.txt","w");
			if(temp != NULL){
				Produit = fopen("Produit.txt", "r");
				while(fscanf(Produit, " %d %s %f %d %d \n", &P.refProduit, &P.designation, &P.prixUnitaire, &P.QuantiteStock, &P.QuantiteSeuil) != EOF){
					if(P.refProduit != refProduit){
						fprintf(temp, " %d  %s %f %d %d \n", P.refProduit, P.designation, P.prixUnitaire, P.QuantiteStock, P.QuantiteSeuil);
					}
				}
				fclose(Produit);
				fclose(temp);
				remove("Produit.txt");
				rename("temp.txt","Produit.txt");
				printf("Produit supprime avec succes \n\n");	
			}
		}else{
			printf("Suppression du produit annule \n\n");
		}
	}else{
		printf("Produit non trouve dans le fichier \n\n");
	}
}

void Augmenter_prix(FILE *Produit){
	int i,j;
	prod P;
	Produit = fopen("Produit.txt", "r");
	FILE *temp = fopen("temp.txt","w");
	if(temp != NULL){
		while(fscanf(Produit, " %d %s %f %d %d \n", &P.refProduit, &P.designation, &P.prixUnitaire, &P.QuantiteStock, &P.QuantiteSeuil) != EOF){
			if(P.prixUnitaire >= 100){
				fprintf(temp, " %d  %s %f %d %d \n", P.refProduit, P.designation, (P.prixUnitaire+(P.prixUnitaire*0.1)), P.QuantiteStock, P.QuantiteSeuil);
			}else{
				fprintf(temp, " %d  %s %f %d %d \n", P.refProduit, P.designation, P.prixUnitaire, P.QuantiteStock, P.QuantiteSeuil);	
			}
		}
		fclose(Produit);
		fclose(temp);
		remove("Produit.txt");
		rename("temp.txt","Produit.txt");
		printf("Prix augmente de 10 avec succes \n\n");
	}
}



int menu(){
    int choix;
	printf("\t\n\n--------------------------------MEMU----------------------------------------\n\n");
	printf("\t\t 1 -  Creer le fichier Produit \n");
	printf("\t\t 2 -  Afficher les produits contenu dans le fichier \n");
	printf("\t\t 3 -  Ajouter des produits dans le fichier \n");
	printf("\t\t 4 -  Rechercher un produit dans le fichier \n");
    printf("\t\t 5 -  Supprimer un produit dans le fichier \n");
    printf("\t\t 6 -  Augmenter les prix des produits dans le fichier \n");
	printf("\t\t 7 -  Quitter \n");
	printf("\t\n-------------------------------------------------------------------------------\n\n");
	
	printf("\t Veiller entrer votre choix svp\n");
	scanf("%d", &choix);
	return choix;
}

