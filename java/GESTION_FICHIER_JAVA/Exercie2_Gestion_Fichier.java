
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Exercie2_Gestion_Fichier{
    public static void main(String[] args){
        try {
            File fichierSource = new File("texte.txt");
            File tempfile = new File("temp.txt");
            if(!tempfile.exists()){
                tempfile.createNewFile();
            }
            FileWriter writer = new FileWriter(tempfile, true);
            String date = LocalDateTime.now().toString();
            Scanner scan =  new Scanner(fichierSource);
            String ligne = date;
            String ligne2 = ligne+" \n";
            writer.write(ligne2);
            while(scan.hasNextLine()){
                ligne = scan.nextLine();
                ligne2 = ligne+" \n";
                System.out.println(" "+ligne);
                writer.write(ligne2);
            }
            scan.close();
            writer.close();
            
            if(tempfile.renameTo(fichierSource)){
                fichierSource.deleteOnExit();
            }else{
                System.out.println("Renommage impossible \n\n");
            }
            
            System.out.println("Ajout terminée");
            
        } catch (FileNotFoundException e) {
            System.out.println("Une erreur est survenue \n\n");
            e.printStackTrace();
        }catch(IOException ex){
            System.out.println("Une erreur est survenue \n\n");
            ex.printStackTrace();
        }
    }    
}