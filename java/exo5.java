import java.util.Scanner;


public class exo5{
    public static void main(String[] args){
        Scanner scan;
        scan = new Scanner(System.in);

        int x1,x2;
        char op;
        System.out.println("Entrer un nombre");
        x1 = scan.nextInt();

        System.out.println("Entrer un second nombre");
        x2 = scan.nextInt();

        System.out.println("Entrer une opération pour Addition : A, Soustraction : S, Multiplication : M, Division : D, Egalité : E");
        op = scan.next().charAt(0);

        switch(op){
            case 'A' : System.out.println(x1+" + "+x2+" = "+(x1+x2)); 
            break;
            case 'S' : System.out.println(x1+" - "+x2+" = "+(x1-x2)); 
            break;
            case 'M' : System.out.println(x1+" X "+x2+" = "+(x1*x2));  
            break;
            case 'D' : {
                if(x2 == 0) System.out.println("Division par 0 impossible ");  
                else System.out.println(x1+" / "+x2+" = "+(x1/x2)); 
            } ;
            break;
            case 'E' : {
                if(x2 == x1) System.out.println(x1+" = "+x2);  
                else System.out.println(x1+" != "+x2); 
            } ;
            break;

            default: System.out.println("Entrer une opération valide");
        }
    }
}