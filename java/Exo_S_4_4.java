import java.util.Scanner;


public class Exo_S_4_4{
    public static void main(String[] args){
        Scanner scan;
        scan = new Scanner(System.in);

        int A,B,C;
        System.out.println("Entrer un nombre  ");
        A = scan.nextInt();
        System.out.println("Entrer un autre nombre ");
        B = scan.nextInt();

        C = PGCD(A,B);
        System.out.println("Le PGCD de "+A+" et "+B+" est "+C);

        scan.close();
    }

    public static int PGCD (int x1, int x2){      
        int pgcd=1;
        if((x1==0) || (x2==0)){
            pgcd = (x1==0)?x2:x1;
        }else{
            if(x1<x2){
                while((x2!=0) && (x1!=0)){
                    x2-=x1;
                    pgcd = x1;
                    x1 = x2;
                    x2 = pgcd;
                }
            }else if(x2<x1){
                while((x2!=0) && (x1!=0)){
                    x1-=x2;
                    pgcd = x2;
                    x2 = x1;
                    x1 = pgcd;
                }
            }
        }
        return pgcd;   
    }

}


