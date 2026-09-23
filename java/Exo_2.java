import java.util.Scanner;


public class Exo_2{
    public static void main(String[] args){
        Scanner scan;
        scan = new Scanner(System.in);

        int J;
        int fact = 1;
        System.out.println("Entrer un nombre ");
        J = scan.nextInt();

        int som = 0;
        if (J < 0) {
            System.out.println("Entrer un nombre positif");
        }else{
          if(J == 0){
            System.out.println(J+"! = "+fact);
          }else{

                for (int i = 1; i <= J; i++) {
                    fact = fact*i;
                }
        
                System.out.println(J+"! = "+fact);
          }
        }
        
    }
}