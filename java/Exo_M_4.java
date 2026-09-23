import java.util.Scanner;



public class Exo_M_4{
    public static void main(String[] args){
        Scanner scan;
        scan = new Scanner(System.in);

        String mot1,mot2;
        System.out.println("Entrer une chaine svp");
        mot1 = scan.next();
        System.out.println("Entrer une autre chaine svp");
        mot2 = scan.next();
        int test = EstUnAnagramme(mot1, mot2);
        if(test == 1){
            System.out.println("La chaine "+mot1+" et "+mot2+" sont des anagrammes ");
        }else{
            System.out.println("La chaine "+mot1+" et "+mot2+" ne sont pas des anagrammes ");
        }

        scan.close();
    }

    public static int EstUnAnagramme(String mot1, String mot2){
        mot1 = mot1.toLowerCase();
        mot2 = mot2.toLowerCase();
        int present=0;
        for (int i = 0; i < mot1.length(); i++) {
            for (int j = 0; j < mot2.length(); j++) {
                if(mot1.charAt(i) == mot2.charAt(j)) present =1;
            }
            if(present == 0) return -1;
        }

        return 1;
    }

}



