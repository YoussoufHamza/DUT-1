import java.util.Scanner;


public class Exo_4_3{
    public static void main(String[] args){
        Scanner scan;
        scan = new Scanner(System.in);

        int J;
        System.out.println("Entrer un nombre ");
        J = scan.nextInt();

        for(int i=0; J> 0; i++){
            System.out.println("Entrer un nombre ");
            J = scan.nextInt(); 
        }

        System.out.println("Bravo votre nombre "+J+" est négatif");
    }
}