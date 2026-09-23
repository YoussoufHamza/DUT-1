import java.util.Scanner;


public class Exo_4_2{
    public static void main(String[] args){
        Scanner scan;
        scan = new Scanner(System.in);

        int J;

        do{
            System.out.println("Entrer un nombre ");
            J = scan.nextInt();
        }while( J > 0);

        System.out.println("Bravo votre nombre "+J+" est négatif");
    }
}