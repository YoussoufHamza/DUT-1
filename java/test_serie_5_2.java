
import java.util.Scanner;


public class test_serie_5_2{
    public static void main(String[] args){
        Rectangle r1 = new Rectangle();
        Scanner scan;
        scan = new Scanner(System.in);

        float l,L;

        System.out.println("Donnez la longueur et la largeur du rectangle \n");
        L = scan.nextFloat();
        l = scan.nextFloat();

        r1.setLongueur(L);
        r1.setLargeur(l);

        System.out.println("Le perimetre de ce rectangle est "+r1.Perimetre()+" et sa surface est "+r1.Surface());

    
    }

}



