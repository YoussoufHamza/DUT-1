import java.util.Scanner;


public class Exo_S_4_2{
    public static void main(String[] args){
        Scanner scan;
        scan = new Scanner(System.in);

        double A,B,m,M;
        System.out.println("Entrer un nombre réel ");
        A = scan.nextDouble();
        System.out.println("Entrer un autre nombre réel ");
        B = scan.nextDouble();
        
        m = min(A, B);
        M = max(A, B);

        System.out.println("Le minimum est "+m+" et le maximum est "+M);

        scan.close();
    }

    public static double min(double x1, double x2){      
        return (x1<x2)?x1:x2;
    }

    public static double max(double x1, double x2){
        return (x2<x1)?x1:x2;
    }
}