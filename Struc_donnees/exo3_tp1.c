#include<stdio.h>
#include<stdlib.h>
#include<string.h>


int main(){

    FILE * fichier;
    FILE * fichier1;
    fichier = fopen("Liste_Etudiants.txt", "r");
    fichier1 = fopen("Liste1_Etudiants.txt", "a");
    
    if((fichier != NULL) && (fichier1 != NULL)){
        char carac;
        carac = fgetc(fichier);
        while(carac != EOF){
            fprintf(fichier1, "%c", carac);
            carac = fgetc(fichier);
        }
        fclose(fichier);
        printf("Copie effectuee avec succes \n");
    }else{
        printf("Ouverture du fichier impossible \n");
    }

    return 0;

}




