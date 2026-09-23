import java.util.Scanner;


public class Exo_4{
    public static void main(String[] args){
        Scanner scan;
        scan = new Scanner(System.in);

        int J;
        System.out.println("Entrer un nombre ");
        J = scan.nextInt();

        
        while( J > 0) {
            System.out.println("Entrer un nombre ");
            J = scan.nextInt();
        }

        System.out.println("Bravo votre nombre "+J+" est négatif");
    }
}