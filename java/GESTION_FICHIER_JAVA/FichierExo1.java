import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FichierExo1{
    public static void main(String[] args){
        try {
            File fichierO = new File("test.txt");
            
            if(!fichierO.exists()){
                fichierO.createNewFile();
            }
                
            FileWriter writer = new FileWriter(fichierO); 
            String texte = "Ceci est un test pour le traitement des fichiers en java";
            writer.write(texte);
            writer.write("\n");
            writer.close();

            Scanner entry = new Scanner(fichierO);
            System.out.println("Contenu du fichier \n");
            while(entry.hasNextLine()){
                String text = entry.nextLine();
                System.out.println(text+" ");
            }
            entry.close();

            writer = new FileWriter(fichierO);
            entry = new Scanner(fichierO); 
            while(entry.hasNextLine()){
                String text = entry.nextLine();
                writer.write(text);
                writer.write("\n");
            }
            String texte2 = "Ceci est une modification dufichier en cour \n";
            writer.write(texte2);
            writer.write("\n");

            entry.close();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        

    }
}
