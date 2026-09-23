#include<stdio.h>
#include<stdlib.h>
#include<string.h>



int main(){
    FILE *fichier;
    char chaine[100];
    char carac;
    printf("Entrer le nom du fichier .txt svp \n");
    gets(chaine);

    fichier = fopen(chaine, "r");

    if(fichier == NULL){
        printf("Echec d'ouverture du fichier \n");
    }else{
        printf("Ouverture reussi du fichier \n\n\n");
        carac = fgetc(fichier);
        while( carac != EOF){
            putchar(carac);
            carac = fgetc(fichier);
        }

        fclose(fichier);
    }

    
    
    return 0;

}
