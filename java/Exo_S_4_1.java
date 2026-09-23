import java.util.Scanner;


public class Exo_S_4_1{
    public static void main(String[] args){
        Scanner scan;
        scan = new Scanner(System.in);

        double A,B,m;
        System.out.println("Entrer un nombre réel ");
        A = scan.nextDouble();
        System.out.println("Entrer un autre nombre réel ");
        B = scan.nextDouble();
        
        m = average(A, B);

        System.out.println("La moyenne arithmétique est  "+m);

        scan.close();
    }

    public static double average(double x1, double x2){
        double moy;
        moy = (x1+x2)/2.0;   
        return moy;
    }
}