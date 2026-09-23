#include<stdio.h>
#include<stdlib.h>
#include<string.h>


int main(){
    int *pI;
    float *pF;
    char *pC;

    pI = (int *)malloc(sizeof(int));
    pF = (float *)malloc(sizeof(float));
    pC = (char *)malloc(50 * sizeof(char));
    
    if((pI == NULL) || (pC == NULL) || (pF == NULL)){
    	printf("Echec d'allocation de la memoire !\n");
	}else{
		*pI = 12;
	    *pF = 12.12;
	    *pC = 'C';

	    printf("Pointeur sur entier %d \nPointeur sur reel %f \nEt Pointeur sur caractere %c\n", *pI, *pF, *pC);:
	    	
	    free(pI);
	    free(pF);
	    free(pC);	
	}

    
    return 0;

}
