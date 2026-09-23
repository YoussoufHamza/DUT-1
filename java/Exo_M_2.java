import java.util.Scanner;



public class Exo_M_2{
    public static void main(String[] args){
        Scanner scan;
        scan = new Scanner(System.in);

        String mot;
        System.out.println("Entrer une chaine svp");
        mot = scan.next();
        int test = EstPalindrome(mot);
        if(test == 1){
            System.out.println("La chaine "+mot+" est palindrome");
        }else{
            System.out.println("La chaine "+mot+" n'est pas palindrome");
        }

        scan.close();
    }

    public static int EstPalindrome(String mot){
        mot = mot.toLowerCase();
        int taille = mot.length();
        for (int i = 0; i < mot.length(); i++) {
            if(mot.charAt(i) != mot.charAt(taille-1)){
                return 0;
            }
            taille--;
        }

        return 1;
    }

}



