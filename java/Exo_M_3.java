import java.util.Scanner;



public class Exo_M_3{
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

        System.out.println("La moyenne des élements du tableau est de "+moyTableau(n, tab)+" et le max des éléments du tableau est "+maxTableau(n, tab));

        scan.close();
    }

    public static void ajouter(int n, int tab[]){
        int i;
        for(i=0; i<n; i++){
            tab[i] = (int) (Math.random()*100);
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

    public static double moyTableau(int n, int tab[]){
        int i;
        double moy=0;
        for(i=0; i<n; i++){
            moy += tab[i];
        }
        moy = moy/(n*1.0);
        return moy;
    }

    public static int maxTableau(int n, int tab[]){
        int i,max=tab[0];
        for(i=1; i<n; i++){
            if(max < tab[i]) max = tab[i];
        }
        return max;
    }


}




