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


int main(){
	
	char nom_f[100];
	int choix,count=0;
    FILE * fichier;
    FILE * tempfile;
    
    tache : printf("Entrer le nom du fichier a remplir extension .txt\n");
    scanf("%s", &nom_f);
    fichier = fopen(nom_f, "r");
    
    if(fichier != NULL){
    	prod P,temp;
    	do{
    		printf("Donner un numero d'enregistrement (0 pour fin) : ");
    		scanf("%d", &choix);
    		count=0;
    		while(fscanf(fichier, " %d %s %f %d %d \n", &P.refProduit, &P.designation, &P.prixUnitaire, &P.QuantiteStock, &P.QuantiteSeuil) != EOF){
				count++;
				if(count == choix) break;
			}
			fclose(fichier);
			if(count == choix){
				count = 0;
				printf("Reference : %d \n Designation : %s \n Prix unitaire : %f \n Quantite en stock : %d \n Quantite seuil : %d \n\n",P.refProduit, P.designation, P.prixUnitaire, P.QuantiteStock, P.QuantiteSeuil);	
				
				printf("Entrer les nouvelles informations : \n");
				tempfile = fopen("temp.txt", "w");
				fichier = fopen(nom_f, "r");
				while(fscanf(fichier, " %d %s %f %d %d \n", &P.refProduit, &P.designation, &P.prixUnitaire, &P.QuantiteStock, &P.QuantiteSeuil) != EOF){
					count++;
					if(count == choix){
						temp.refProduit = P.refProduit;
						printf("Designation : ");
						scanf(" %[^\n]", temp.designation);
									
					
						printf("Prix unitaire : ");
						scanf("%f", &temp.prixUnitaire);
						
						printf("Quantite en stock : ");
						scanf("%d", &temp.QuantiteStock);
						
						printf("Quantite seuil : ");
						scanf("%d", &temp.QuantiteSeuil);
						
						fprintf(tempfile, " %d  %s %f %d %d \n", temp.refProduit, temp.designation, temp.prixUnitaire, temp.QuantiteStock, temp.QuantiteSeuil);
					}else{
						fprintf(tempfile, " %d  %s %f %d %d \n", P.refProduit, P.designation, P.prixUnitaire, P.QuantiteStock, P.QuantiteSeuil);
					}
				}
				fclose(tempfile);
				fclose(fichier);
				remove("Produit.txt");
				rename("temp.txt","Produit.txt");
			}else{
				printf("Numero invalide \n");
			}	
		}while(choix != 0);
    }else{
        printf("\tOuverture du fichier impossible \n \tEntrer un fichier valide\n");
        goto tache;
    }

    return 0;

}
