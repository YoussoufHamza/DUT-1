#include<stdio.h>
#include<stdlib.h>
#include<string.h>


int main(){

    FILE * fichier;
    fichier = fopen("Liste_Etudiants.txt", "r");
    
    if(fichier != NULL){
        char carac;
        carac = fgetc(fichier);
        while(carac != EOF){
            printf("%c", carac);
            carac = fgetc(fichier);
        }
        fclose(fichier);
    }else{
        printf("Ouverture du fichier impossible \n");
    }

    return 0;

}




