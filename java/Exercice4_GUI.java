
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Exercice4_GUI{
    public static void main(String[] args){
        JLabel Ecran=new JLabel();
        String op="";
        JButton B1, B2, B3, B4, B5, B6, B7, B8, B9, B0, Badd, Bsous, Bmult, Bdiv;
        JButton valider = new JButton("=");
        JFrame fenetre = new JFrame("Calculatrice");
        JPanel info = new JPanel(new GridLayout(5,3, 2,3));
        JPanel titreinfo = new JPanel(new BorderLayout());
        Ecran.setSize(100, 0);
        titreinfo.add(Ecran);

        B0 = new JButton("0");
        B1 = new JButton("1");
        B2 = new JButton("2");
        B3 = new JButton("3");
        B4 = new JButton("4");
        B5 = new JButton("5");
        B6 = new JButton("6");
        B7 = new JButton("7");
        B8 = new JButton("8");
        B9 = new JButton("9");
        Badd = new JButton("+");
        Bsous = new JButton("-");
        Bmult = new JButton("*");
        Bdiv = new JButton("/");

        ActionListener AffichageSurEcran=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton select = (JButton)e.getSource();
                Ecran.setText(Ecran.getText()+select.getText());
            }
        };

        B0.addActionListener(AffichageSurEcran);
        B1.addActionListener(AffichageSurEcran);
        B2.addActionListener(AffichageSurEcran);
        B3.addActionListener(AffichageSurEcran);
        B4.addActionListener(AffichageSurEcran);
        B5.addActionListener(AffichageSurEcran);
        B6.addActionListener(AffichageSurEcran);
        B7.addActionListener(AffichageSurEcran);
        B8.addActionListener(AffichageSurEcran);
        B9.addActionListener(AffichageSurEcran);
        Badd.addActionListener(AffichageSurEcran);
        Bsous.addActionListener(AffichageSurEcran);
        Bdiv.addActionListener(AffichageSurEcran);
        Bmult.addActionListener(AffichageSurEcran);

        info.add(B0);
        info.add(B1);
        info.add(B2);
        info.add(B3);
        info.add(B4);
        info.add(B5);
        info.add(B6);
        info.add(B7);
        info.add(B8);
        info.add(B9);
        info.add(Badd);
        info.add(Bsous);
        info.add(Bmult);
        info.add(Bdiv);
        info.add(valider);
        

        valider.setBackground(new Color(0, 253, 40));
        
        valider.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String op = Ecran.getText();
                
            }
        });

        
        
        
        fenetre.setSize(400, 300);
        fenetre.setLayout(new BoxLayout(fenetre.getContentPane(), BoxLayout.Y_AXIS));
        fenetre.add(titreinfo);
        fenetre.add(info, BorderLayout.CENTER);
        

        fenetre.setResizable(false);
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

}