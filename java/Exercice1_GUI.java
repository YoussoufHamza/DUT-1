
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Exercice1_GUI{
    public static void main(String[] args){
        String texte= "Bonjour Bienvenue sur mon premier programme GUI";
        JButton bouton;

        JLabel  text = new JLabel(texte);

        JFrame fenetre;
        Color c= new Color(952);
        Color c2= new Color(832);

        bouton = new JButton("Quitter");
        bouton.setSize(100, 40);
        bouton.setBackground(c);

        fenetre =  new JFrame("HELLO !");
        fenetre.setSize(500,100);
        fenetre.setBackground(c2);
        fenetre.setLayout(new BoxLayout(fenetre.getContentPane(), BoxLayout.Y_AXIS));
        fenetre.add(text);
        fenetre.add(bouton);
        

        bouton.addActionListener(l -> fenetre.dispose());

        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        fenetre.setVisible(true);
    }
    
}