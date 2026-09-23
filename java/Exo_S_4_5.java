import java.util.Scanner;


public class Exo_S_4_5{
    public static void main(String[] args){
        Scanner scan;
        scan = new Scanner(System.in);

        double A;
        int p;
        System.out.println("Entrer un nombre réel ");
        A = scan.nextDouble();
        System.out.println("Entrer la puissance du nombre ");
        p = scan.nextInt();
        
 
        System.out.println(A+" puissance "+p+" = "+puis(A,p));

        scan.close();
    }

    public static double puis(double x1, int p){      
        double puis = 1;
        if (p==0) {
            return puis;
        }else if(0<p){
            puis = x1 * puis(x1, p-1);
            return puis;
        }else{
            return 1/puis(x1,-p);
        }
    }

}