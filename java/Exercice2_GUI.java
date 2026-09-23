
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Exercice2_GUI{
    public static void main(String[] args){
        String[] choix = {"Panini", "Sandwiche","Pizza","hot dog", "Burger"};
        String Commande; String Sauce; String Disposition;
        
        JCheckBox checkBox1 =  new JCheckBox("Sauce Marocaine");
        JCheckBox checkBox2 =  new JCheckBox("Sauce algerienne");
        JCheckBox checkBox3 = new JCheckBox("Sauce Tomate");
        

        JLabel texte1 = new JLabel( "Choissisez un plat");
        JLabel texte2 = new JLabel( "Choissisez un mode de livraison");
        JLabel texte3 = new JLabel( "Choissisez une ou plusieurs sauces");
   
        JComboBox liste;
        liste = new JComboBox<>(choix);
        liste.setSize(20, 20);

        JLabel  text = new JLabel("Bienvenue sur notre interface de commande des plats");

     
        Color c= new Color(0, 255, 0);

        JRadioButton Button1 = new JRadioButton("Sur place");
        JRadioButton Button2 = new JRadioButton("Emporté");
        ButtonGroup group = new ButtonGroup();
        group.add(Button1);
        group.add(Button2);
      

        JButton bouton;
        bouton = new JButton("Commander");
        bouton.setSize(100, 40);
        bouton.setBackground(c);

        JFrame fenetre;
        fenetre =  new JFrame("Commande Client");
        fenetre.setSize(500,280);
        fenetre.setLayout(new BoxLayout(fenetre.getContentPane(), BoxLayout.Y_AXIS));

        fenetre.add(text);
   
        fenetre.add(texte1);
       
        fenetre.add(liste);
       
        fenetre.add(texte2);

        fenetre.add(Button1);
        fenetre.add(Button2);

        fenetre.add(texte3);
        fenetre.add(checkBox1);
        fenetre.add(checkBox2);
        fenetre.add(checkBox3);
        
        fenetre.add(bouton);
        

        bouton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sauce2="", sauce1="", sauce3="", livraison="", plat="";
                if(checkBox2.isSelected()){
                    sauce2  = checkBox2.getText(); 
                }if(checkBox1.isSelected()){
                    sauce1  = checkBox1.getText(); 
                }if(checkBox3.isSelected()){
                    sauce3  = checkBox3.getText(); 
                }  
                if(Button1.isSelected()){
                    livraison  = Button2.getText(); 
                }else if(Button2.isSelected()){
                    livraison  = Button1.getText(); 
                }
                plat = liste.getItemAt(liste.getSelectedIndex()).toString();
                

                JOptionPane display = new JOptionPane();
                display.showMessageDialog(fenetre, "Votre commande : "+plat+" avec comme sauce : "+sauce1+" "+sauce2+" "+sauce3+" choix de livraison : "+livraison);
            }
        });


        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        fenetre.setVisible(true);
    }
    
    public static JFrame Display(){
        JFrame fenetre;
        fenetre =  new JFrame("Recapitulatif");
        fenetre.setSize(500,280);
        JLabel Text = new JLabel("Bonjour");
        fenetre.add(Text);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setVisible(true);
        return fenetre;
    }

}