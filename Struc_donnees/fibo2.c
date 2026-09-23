#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int fibonacci(int n);

int main(){
    int n,nbr=0,brsup,brinf,i;
    printf("Entrer l'intervalle svp ");
    scanf("%d", &brinf);
    scanf("%d", &brsup);
    int u1=0, u2=1,u3;

    for(i=0; i<100; i++){
        u3 = fibonacci(i);
        if((u3>=brinf) && (u3<=brsup)) nbr++;
        if(u3>=brsup) break;
    }

	printf("Il y'a %d chiffre(s) de fibonacci dans l'intervalle [%d - %d]  \n", nbr, brinf, brsup);
    return 0;

}



int fibonacci(int n){
    if(n<=1){
        return n;
    }else{
       return fibonacci(n-1) + fibonacci(n-2);
    }
}

