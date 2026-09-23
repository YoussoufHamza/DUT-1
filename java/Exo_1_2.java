import java.util.Scanner;


public class Exo_1_2{
    public static void main(String[] args){
        Scanner scan;
        scan = new Scanner(System.in);

        int J;
        System.out.println("Entrer un nombre ");
        J = scan.nextInt();

        int som = 0;
        int i = 1;
        while( i <= J) {
            som +=i;
            i++;
        }

        System.out.println("La somme des nombres de 1 à "+J+" est "+som);
    }
}