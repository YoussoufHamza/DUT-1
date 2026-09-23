
import java.util.Scanner;


public class TestLivre{
    public void main(String[] args){
        Scanner scan;
        scan = new Scanner(System.in);
        int n,i;
        System.out.println("Entrer le nombre de livre à remplir");
        Livre[] l1;
        Livre l;
        l = new Livre();
        n = scan.nextInt();
        l1 = new Livre[n];
        for (i = 0; i < n; i++) {
            System.out.println("Remplisser les informations des livres \n\n");

            System.out.println(" Donner le titre du livre N"+(i+1));
            l.setTitre(scan.next());

            System.out.println(" Donner l'auteur du livre N"+(i+1));
            l.setAuteur(scan.next());

            System.out.println(" Donner le prix du livre N"+(i+1));
            l.setprix(scan.nextDouble());

            l1[i] = new Livre(l.getTitre(), l.getAuteur(), l.getPrix());
        }

        System.out.println("Informations sur les livres Nombre total de livre : "+l1[0].getCompteur()+"\n");
        for (i = 0; i < n; i++) {

            System.out.println(l1[i].toString()); 
        }

        System.out.println("\n\n");
        scan.close();
    }    
}