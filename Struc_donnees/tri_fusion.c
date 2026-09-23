#include<stdio.h>
#include<stdlib.h>
#include<string.h>

void tri_fusion(int tab[], int gauche, int droite);
void fusion(int tab[], int gauche, int milieu, int droite);

int main(){
    int tab[] = {2, 9, 0, 1, 29, -1, 10, 20, 0, 3};
    int taille = sizeof(tab)/sizeof(tab[0]);
    
    int i;
    printf(" | ");
    for(i=0; i<taille; i++){
    	printf(" %d ", tab[i]);
	}
	printf(" | \n");
	
	tri_fusion(tab, 0, taille-1);
	printf("Apres le tri \n");
	
	printf(" | ");
    for(i=0; i<taille; i++){
    	printf(" %d ", tab[i]);
	}
	printf(" | \n");
    return 0;

}

void fusion(int tab[], int gauche, int milieu, int droite){
	int i,j,n1,n2,k;
	
	n1 = milieu - gauche +1;
	n2 = droite - milieu;
	
	int G[n1], D[n2];
	
	for(i=0; i<n1; i++){
		G[i] = tab[gauche + i];
		printf("%d ", G[i]);
	}
       
    
	for(j=0; j<n2; j++){
		D[j] = tab[milieu + j + 1];
		printf("%d ", D[j]);
	}
	
	printf("\n\n");
      
    
    i=0;
    j=0;
    k=gauche;
    
    while(i<n1 && j<n2){
    	if(G[i]<=D[j]){
        	tab[k] = G[i];
        	i++;
		}else{
			tab[k] = D[j];
			j++;
		}	
		k++;
	}
	
	while(i<n1){
        tab[k] = G[i];
        i++;	
		k++;
	}
	
	while(j<n2){
        tab[k] = D[j];
        j++;	
		k++;
	}
   
}

void tri_fusion(int tab[], int gauche, int droite){
	if(gauche<droite){
		int milieu = gauche + (droite - gauche)/2;
		tri_fusion(tab, gauche, milieu);
		tri_fusion(tab, milieu+1, droite);
		fusion(tab,gauche,milieu,droite);
	}
}
