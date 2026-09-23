import java.util.Scanner;


public class exo4{
    public static void main(String[] args){
        Scanner scan;
        scan = new Scanner(System.in);

        int nbr;
        System.out.println("Entrer un nombre");
        nbr = scan.nextInt();

        if(nbr%2==0){
            System.out.println("Le nombre "+nbr+" est pair");
        }else{
            System.out.println("Le nombre "+nbr+" est impair");
        }

    }
}