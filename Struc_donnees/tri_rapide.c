#include<stdio.h>
#include<stdlib.h>
#include<string.h>

void permutation(int *a, int *b);
int partitionner(int tab[], int l, int h);
void tri_rapide(int tab[], int l, int h);

int main(){
    int tab[] = {2, 9, 0, 1, 29, -1, 10, 20, 0, 3};
    int taille = sizeof(tab)/sizeof(tab[0]);
    
    int i;
    printf(" | ");
    for(i=0; i<taille; i++){
    	printf(" %d ", tab[i]);
	}
	printf(" | \n");
	
	tri_rapide(tab, 0, taille-1);
	printf("Apres le tri \n");
	
	printf(" | ");
    for(i=0; i<taille; i++){
    	printf(" %d ", tab[i]);
	}
	printf(" | \n");
    
    return 0;

}

void permutation(int *a, int *b){
	int temp;
	temp = *a;
	*a = *b;
	*b = temp;
}


int partitionner(int tab[], int l, int h){
	int i,p,pg;
	p=h;
	pg=l;
	for(i=l; i<h; i++){
		if(tab[i]<tab[p]){
			permutation(&tab[i], &tab[pg]);
			pg++;
		}
	}
	permutation(&tab[p], &tab[pg]);
	return pg;
}

void tri_rapide(int tab[], int l, int h){
	int p;
	if(l<h){
		p = partitionner(tab, l, h);
		tri_rapide(tab, l, p-1);
		tri_rapide(tab, p+1, h);
	}
}
