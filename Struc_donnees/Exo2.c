#include<stdio.h>
#include<stdlib.h>
#include<string.h>

typedef struct{
    char nom[100];
    char prenom[100];
    int matricule;
}Personne;


int main(){

    Personne *TabPers;
    int n,i;
    printf("Entrer le nombre de personne a enregistrer \n");
    scanf("%d",&n);
    TabPers = (Personne *)malloc(n*sizeof(Personne));
    if(TabPers == NULL){
        printf("Echec de l'allocation de la memoire \n");
    }else{
        for(i=0; i<n; i++){
            printf("Entrer le nom de la personne n%d _ ", i+1);
            scanf("%s", &TabPers[i].nom);
            printf("\nEntrer le prenom de la personne n%d _ ", i+1);
            scanf("%s", &TabPers[i].prenom);
            printf("\nEntrer le matricule de la personne n%d _ ", i+1);
            scanf("%d", &TabPers[i].matricule);
        }

        printf("\n\nLes personnes enregistrees sont : \n\n");

        for(i=0; i<n; i++){
            printf("Nom  _ %s\n", TabPers[i].nom);
            printf("Prenom  _ %s\n", TabPers[i].prenom);
            printf("Matricule  _ %d\n\n ", TabPers[i].matricule);
        }
        
        free(TabPers);
    }
    
    return 0;

}
