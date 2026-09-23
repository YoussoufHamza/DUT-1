import java.util.Scanner;



public class Exo_M_1{
    public static void main(String[] args){
        Scanner scan;
        scan = new Scanner(System.in);

        int n,x;
        System.out.println("Entrer la taille du tableau svp");
        n = scan.nextInt();

        int[] tab;
        tab = new int[n];

        ajouter(n,tab);
        System.out.println("Votre tableau");
        afficher(n, tab);

        trier(n,tab);
        System.out.println("Votre tableau après le tri dans l'ordre croissant");
        afficher(n, tab);

        System.out.println("Entrer l'élément du tableau à supprimer");
        x = scan.nextInt();

        supprimer(n, tab, x);
        System.out.println("Votre tableau après la suppression");
        n--;
        afficher(n, tab);


        scan.close();
    }

    public static void ajouter(int n, int tab[]){
        Scanner scan;
        scan = new Scanner(System.in);
        int i;
        for(i=0; i<n; i++){
            System.out.println("Remplissez l'element "+(i+1));
            tab[i] = scan.nextInt();
        }
        System.out.println("Remplissage du tableau reussit \n\n");
    }

    public static void afficher(int n, int tab[]){
        int i;
        for(i=0; i<n; i++){
            System.out.print(" "+tab[i]+" ");
        }
        System.out.println("");
    }


    public static void trier(int n, int tab[]){
        int i;
        int temp;
        for(i=0; i<n; i++){
            for (int j = i+1; j < n; j++) {
                if(tab[j]<tab[i]){
                    temp = tab[i];
                    tab[i] = tab[j];
                    tab[j] = temp;
                }
            }
        }
    }
 
    public static void supprimer(int n, int tab[], int x){
        int i,b=0,h=0;
        for(i=0; i<n; i++){
            if(tab[h] != x){
                tab[b] = tab[h];
                b++;
            }
            h++;
        }
    }


}




