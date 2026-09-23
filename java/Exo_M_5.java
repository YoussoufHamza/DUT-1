import java.util.Scanner;



public class Exo_M_5{
    public static void main(String[] args){
        Scanner scan;
        scan = new Scanner(System.in);

        
        String mot1 = "Id perspiciatis expedita laboriosam officia.\n\nMollitia deserunt iure expedita sint commodi praesentium ratione atque optio quam! Lorem ipsvm dolor sit, avet consectetur adipisicing elit.\n\nMolvitia deserunt ivre exvedita sint commodi praesentium ratvone atque opvtio quam!";
        System.out.println(mot1);

        TraitementTexte(mot1);
    }

    public static void TraitementTexte(String texte){
        int nbrMots =1;
        int nbrCV =0;
        int nbrPhrase =0;
        int nbPara =1;

        for (int i = 0; i < texte.length(); i++) {
            if((texte.charAt(i) == 'c' ) || (texte.charAt(i) == 'v' ) || (texte.charAt(i) == 'C' ) || (texte.charAt(i) == 'V')){
                nbrCV++;
            }
            if((texte.charAt(i) == ' ') || (texte.charAt(i) == '.')){
                nbrMots++;
            }
            if((texte.charAt(i) == '\n') && (texte.charAt(i+1) == '\n')){
                nbPara++;
            }
            if((texte.charAt(i) == '.') || (texte.charAt(i) == '!') || (texte.charAt(i) == '?')){
                nbrPhrase++;
            }
        }
        System.out.println("\t\tLe texte compte "+nbrCV+" caractere 'C' et 'V'");
        System.out.println("\t\tLe texte compte "+nbrMots+" mots");
        System.out.println("\t\tLe texte compte "+nbrPhrase+" phrases");
        System.out.println("\t\tLe texte compte "+nbPara+" paragraphes");

    }

}



