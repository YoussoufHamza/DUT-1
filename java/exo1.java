import java.util.Scanner;


public class exo1{
    public static void main(String[] args){
        Scanner scan;
        scan = new Scanner(System.in);

        int x1,x2;
        System.out.println("Entrer un nombre");
        x1 = scan.nextInt();

        System.out.println("Entrer un second nombre");
        x2 = scan.nextInt();

        int max = (x1<x2)?x2:x1;

        System.out.println("Le nombre est "+max);

    }
}