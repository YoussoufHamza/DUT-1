
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Exercice3_GUI{
    public static void main(String[] args){
        JLabel titre, nom, prenom, daten, adresse, numtel;
        JTextField nomI, prenomI, datenI, adresseI, numtelI;
        JButton valider = new JButton("Valider");
        JFrame fenetre = new JFrame("Inscription");
        JPanel info = new JPanel(new GridLayout(6,2, 2,3));
        JPanel titreinfo = new JPanel(new BorderLayout());
        
        titre = new JLabel("INFORMATIONS A REMPLIR");
        titre.setForeground(new Color(482));
        titre.setHorizontalAlignment(titre.CENTER);
        titreinfo.add(titre);

        nom = new JLabel("Nom : ");
        nom.setHorizontalAlignment(nom.RIGHT);
        prenom = new JLabel("Prenom : ");
        prenom.setHorizontalAlignment(prenom.RIGHT);
        daten = new JLabel("Date naissance : ");
        daten.setHorizontalAlignment(daten.RIGHT);
        adresse = new JLabel("Adresse : ");
        adresse.setHorizontalAlignment(adresse.RIGHT);
        numtel = new JLabel("Telephone : ");
        numtel.setHorizontalAlignment(numtel.RIGHT);

        nomI = new JTextField();
        prenomI = new JTextField();
        datenI = new JTextField();
        adresseI = new JTextField();
        numtelI = new JTextField();

        valider.setBackground(new Color(0, 253, 40));
        
        valider.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomS, prenomS, datenS, adresseS, numtelS;
                nomS = nomI.getText();
                prenomS = prenomI.getText();
                adresseS = adresseI.getText();
                datenS = datenI.getText();
                numtelS = numtelI.getText();
                JOptionPane display = new JOptionPane();
                display.showMessageDialog(fenetre, nomS+" "+prenomS+" "+adresseS+" "+datenS+" "+numtelS);
            }
        });

        info.add(nom);
        info.add(nomI);
        info.add(prenom);
        info.add(prenomI);
        info.add(daten);
        info.add(datenI);
        info.add(adresse);
        info.add(adresseI);
        info.add(numtel);
        info.add(numtelI);
        
        
        fenetre.setSize(400, 300);
        fenetre.setLayout(new BorderLayout());
        fenetre.add(titreinfo, BorderLayout.NORTH);
        fenetre.add(info, BorderLayout.CENTER);
        fenetre.add(valider, BorderLayout.SOUTH);

        fenetre.setResizable(false);
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

}