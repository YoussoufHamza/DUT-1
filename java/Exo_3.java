import java.util.Scanner;


public class Exo_3{
    public static void main(String[] args){
        Scanner scan;
        scan = new Scanner(System.in);

        int J;
        System.out.println("Entrer un nombre ");
        J = scan.nextInt();

        for (int i = 0; i <= 10; i++) {
          if(J*i <= 70){
            System.out.println(J+" X "+i+" = "+(J*i));  
          }else{
            break;
          }
        }
    }
}