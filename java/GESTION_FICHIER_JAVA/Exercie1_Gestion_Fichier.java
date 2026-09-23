
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Exercie1_Gestion_Fichier{
    public static void main(String[] args){
        try {
            File fichierSource = new File("texte.txt");
            File fichierDest = new File("Dossier//fichier.txt");
            FileWriter writer = new FileWriter(fichierDest, true);
            Scanner scan =  new Scanner(fichierSource);
            while(scan.hasNextLine()){
                String ligne = scan.nextLine();
                String ligne2 = ligne+" \n";
                System.out.println(" "+ligne);
                writer.write(ligne2);
            }
            System.out.println("Copie du fichier terminée");
            scan.close();
            writer.close();
        } catch (Exception e) {
            System.out.println("Une erreur est survenue \n\n");
            e.printStackTrace();
        }
    }    
}