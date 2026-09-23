
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Exercice6_GUI{
    public static void main(String[] args){
        JLabel titre,titre2, nom, prenom, daten, adresse, numtel, dated, datef, villeD, nbrePers, Transp;
        JTextField nomI, prenomI, datenI, adresseI, numtelI, datedI, datefI, nbrePersI, TranspI;
        String[] Ville = {"Rabat", "Agadir", "Marakech", "Tanger", "Oujda", "Sale", "Temara", "Kenitra"};
        JComboBox VilleM = new JComboBox<>(Ville);
        JButton valider = new JButton("Confirmer");
        JFrame fenetre = new JFrame("Gestion de voyage");
        JPanel info = new JPanel(new GridLayout(6,2, 2,3));
        JPanel TitreD = new JPanel(new GridLayout(2,1, 2,3));
        JPanel TitreD2 = new JPanel(new GridLayout(2,1, 2,3));
        JPanel infoV = new JPanel(new GridLayout(7,2, 2,3));
        
        
        titre = new JLabel("INFORMATIONS A REMPLIR SUR LE CLIENT");
        titre2 = new JLabel("INFORMATIONS SUR LE SEJOUR");
        titre.setForeground(new Color(482));
        titre.setHorizontalAlignment(titre.CENTER);
        titre2.setForeground(new Color(482));
        titre2.setHorizontalAlignment(titre.CENTER);
        TitreD.add(titre);
        TitreD2.add(titre2);

        nom = new JLabel("Nom : ");
        nom.setHorizontalAlignment(nom.RIGHT);
        prenom = new JLabel("Prenom : ");
        prenom.setHorizontalAlignment(prenom.RIGHT);
        daten = new JLabel("Date de naissance : ");
        daten.setHorizontalAlignment(daten.RIGHT);
        adresse = new JLabel("Adresse : ");
        adresse.setHorizontalAlignment(adresse.RIGHT);
        numtel = new JLabel("Telephone : ");
        numtel.setHorizontalAlignment(numtel.RIGHT);
        dated = new JLabel("Date de debut : ");
        dated.setHorizontalAlignment(numtel.RIGHT);
        datef = new JLabel("Date de fin : ");
        datef.setHorizontalAlignment(numtel.RIGHT);
        villeD = new JLabel("Selectionner une ville : ");
        villeD.setHorizontalAlignment(numtel.RIGHT);
        nbrePers = new JLabel("Nombre de personne : ");
        nbrePers.setHorizontalAlignment(nbrePers.RIGHT);
        Transp = new JLabel("Moyen de transport : ");
        Transp.setHorizontalAlignment(Transp.RIGHT);

        nomI = new JTextField();
        prenomI = new JTextField();
        datenI = new JTextField();
        adresseI = new JTextField();
        numtelI = new JTextField();
        datedI = new JTextField();
        datefI = new JTextField();
        nbrePersI = new JTextField();
        TranspI = new JTextField();

        VilleM.setVisible(false);
        villeD.setVisible(false);

        JRadioButton Local, etranger;
        Local = new JRadioButton("Maroc");
        etranger = new JRadioButton("Etranger"); 
        ButtonGroup dest = new ButtonGroup();
        dest.add(etranger);
        dest.add(Local);

        Local.setHorizontalAlignment(Local.RIGHT);
        etranger.setHorizontalAlignment(etranger.RIGHT);

        valider.setBackground(new Color(0, 253, 40));
        
        valider.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomS, prenomS, datenS, adresseS, numtelS, datedS, datefS, villedS, destS, pers, transp;
                nomS = nomI.getText();
                prenomS = prenomI.getText();
                adresseS = adresseI.getText();
                datenS = datenI.getText();
                numtelS = numtelI.getText();
                datedS = datedI.getText();
                datefS = datefI.getText();
                pers = nbrePersI.getText();
                transp = TranspI.getText();
                JOptionPane display = new JOptionPane();
                if(Local.isSelected()){
                    destS = Local.getText();
                    villedS = VilleM.getSelectedItem().toString();
                    display.showMessageDialog(fenetre, "Bienvenue Mr "+nomS+" "+prenomS+" "+adresseS+" "+datenS+" "+numtelS+"\n Recapitulatif de votre voyage : "+pers+" personne(s) en "+transp+" date de debut du sejour "+datedS+" date de fin du sejour "+datefS+" lieu du sejour "+villedS+", "+destS);
                }else{
                    destS = etranger.getText();
                    display.showMessageDialog(fenetre, "Bienvenue Mr "+nomS+" "+prenomS+" "+adresseS+" "+datenS+" "+numtelS+"\n Recapitulatif de votre voyage : "+pers+" personne(s) en "+transp+" date de debut du sejour "+datedS+" date de fin du sejour "+datefS+" lieu du sejour "+destS);
                }
            }
        });

        ActionListener afficherVille= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JRadioButton select = (JRadioButton)e.getSource();
                if(select.isSelected()){
                    villeD.setVisible(true);
                    VilleM.setVisible(true);
                }
            }
        };

        ActionListener MasquerVille= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JRadioButton select = (JRadioButton)e.getSource();
                if(select.isSelected()){
                    villeD.setVisible(false);
                    VilleM.setVisible(false);
                }
            }
        };

        Local.addActionListener(afficherVille);
        etranger.addActionListener(MasquerVille);

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

        infoV.add(dated);
        infoV.add(datedI);
        infoV.add(datef);
        infoV.add(datefI);
        infoV.add(nbrePers);
        infoV.add(nbrePersI);
        infoV.add(Transp);
        infoV.add(TranspI);
        infoV.add(Local);
        infoV.add(etranger);
        infoV.add(villeD);
        infoV.add(VilleM);
        
        
        fenetre.setSize(500, 480);
        fenetre.setLayout(new BoxLayout(fenetre.getContentPane(), BoxLayout.Y_AXIS));
        fenetre.add(TitreD);
        fenetre.add(info);
        fenetre.add(TitreD2);
        fenetre.add(infoV);
        fenetre.add(valider);
        

        fenetre.setResizable(false);
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

}