#include<stdio.h>
#include<stdlib.h>
#include<string.h>


int main(){
	
	char nom_f[100];
	char donnees[200];
	char choix;
    FILE * fichier;
    
    
    printf("Entrer le nom du fichier a remplir extension .txt\n");
    scanf("%s", &nom_f);
    fichier = fopen(nom_f, "a");
    
    
    
    if(fichier != NULL){
    	do{
		    printf("Entrer le contenu du fichier svp \n");
		    scanf(" %[^\n]", donnees);
	    	printf("Voulez vous ajouter cette ligne au fichier O/o N/n \n");
	    	getchar();
	    	scanf("%s", &choix);
	    	
	    	if((choix == 'O') || (choix == 'o')){
	    		fprintf(fichier, "%s", donnees);
	    		fprintf(fichier, "%s", "\n");	
			} 
			
			printf("Voulez vous ajouter une nouvelle ligne O/o N/n \n");
	    	getchar();
	    	scanf("%s", &choix);
	    	
		}while((choix == 'O') || (choix == 'o'));
	    fclose(fichier);
    }else{
        printf("Ouverture du fichier impossible \n");
    }

    return 0;

}




