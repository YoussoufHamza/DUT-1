#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int fibonacci(int n,int brsup, int brinf);

int main(){
    int n,nb,brsup,brinf;
    printf("Entrer l'intervalle svp ");
    scanf("%d", &brinf);
    scanf("%d", &brsup);
   
    nb = fibonacci(100,brsup, brinf);

	printf("Il y'a %d chiffre(s) de fibonacci dans l'intervalle [%d - %d]  \n", nb, brinf, brsup);
    return 0;

}



int fibonacci(int n, int brsup, int brinf){
    int i, nbr=0;
    int u1=0, u2=1,u3;
    if(n==0){
        return u1;
    }else if(n == 1 ){
        return u2;
    }else if(n>0){
        for(i=0; i<100; i++){
            u3 = u1+u2;
            u1 = u2;
            u2 = u3;
            if((u3>=brinf) && (u3<=brsup)) nbr++;
            if(u3>=brsup) break;
        }
    }
    return nbr;
}

