
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Exercice5_GUI{
    public static void main(String[] args){
        JTextArea Edition = new JTextArea();
        JMenuBar Menu = new JMenuBar();
        JMenuItem OpenFi= new JMenuItem("Ouvrir"); 
        JMenuItem SauveFi= new JMenuItem("Enregistrer");
        Menu.add(OpenFi);
        Menu.add(SauveFi);
        OpenFi.setBackground(new Color(0,200,100));
        OpenFi.setCursor(new Cursor(12));
        SauveFi.setCursor(new Cursor(12));
        SauveFi.setBackground(new Color(0,200,100));
        JFileChooser selection = new JFileChooser();
        JFrame fenetre = new JFrame("Inscription");
        
        ActionListener ouvrirFichier = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int result = selection.showOpenDialog(null);
                    if(result == JFileChooser.APPROVE_OPTION){
                        File fichierO = selection.getSelectedFile();
                        Scanner scan = new Scanner(fichierO);
                        Edition.setText("");
                        while(scan.hasNextLine()){
                            String texte = scan.nextLine();
                            String textedis = texte+"\n";
                            Edition.setText(Edition.getText()+textedis);
                        }
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            
        };

        ActionListener EnregisterFichier = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int result = selection.showSaveDialog(null);
                    if(result == JFileChooser.APPROVE_OPTION){
                        File fichierO = selection.getSelectedFile();
                        FileWriter write = new FileWriter(fichierO);
                        write.write(Edition.getText());
                        write.close();
                        
                        JOptionPane Dis = new JOptionPane();
                        Dis.showMessageDialog(fenetre, "Enregistrement reussi ");
                        Edition.setText("");
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            
        };

        Edition.setAutoscrolls(true);
        OpenFi.addActionListener(ouvrirFichier);
        SauveFi.addActionListener(EnregisterFichier);
        

        fenetre.setSize(900, 500);
        fenetre.setLayout(new BoxLayout(fenetre.getContentPane(), BoxLayout.Y_AXIS));
        fenetre.add(Menu);
        fenetre.add(Edition);

        fenetre.setResizable(true);
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

}