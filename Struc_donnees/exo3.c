#include<stdio.h>
#include<stdlib.h>
#include<string.h>



int main(){
	
    FILE *fichier;
    char chaine[100];

    fichier = fopen("test.txt", "a");

    if(fichier == NULL){
        printf("Echec d'ouverture du fichier \n");
    }else{
        printf("Entrer une chaine svp \n");
        gets(chaine);
        fprintf(fichier,"%s \n", chaine);
        printf("Ajout de la chaine reussi \n");
        fclose(fichier);
    }

    
    
    return 0;

}
