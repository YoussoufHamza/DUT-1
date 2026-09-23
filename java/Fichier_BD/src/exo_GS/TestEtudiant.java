package exo_GS;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

import exoG_BD.Compte;
import exoG_BD.CompteCourant;
import exoG_BD.CompteEpargne;

import java.text.DecimalFormat;
import java.text.ParseException;

public class TestEtudiant {

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DATABASE_URL = "jdbc:mysql://localhost/java_bd";
	
	public static void main(String[] args) {
		JFrame displayWindow =  new JFrame("Accueil");
		displayInterface(displayWindow);
		System.gc();
	}
	
	public static void displayInterface(JFrame displayWindow) {
		
		displayWindow.dispose();
		displayWindow = DisplayCreate();

		JMenuBar MenuBar =  Menu(displayWindow);
		
		
		JLabel Titre = new JLabel("Application de gestion des etudiants");
		
		JPanel TitreETMenu =  new JPanel(new GridLayout(3,1,5,2));
		JPanel ResumeIntro = new JPanel(new GridLayout(3,1,5,2));
		JPanel StateBar = new JPanel(new GridLayout(1,1));
		
		JTextArea text =  new JTextArea();
		text.setFocusable(false);
		text.setRows(5);
		text.setColumns(1);
		text.setEditable(false);
		text.setForeground(new Color(Color.TRANSLUCENT));
		JLabel State = new JLabel("");
		StateBar.setBackground(Color.GREEN);
		State.setForeground(Color.white);
		StateBar.add(State);
		
		TitreETMenu.add(MenuBar);
		TitreETMenu.add(Titre);
		
		text.setText("\n\n\n\t\tBienvenue sur l'application de gestion \n \tIci vous pourrez effectuer plusieurs opérations : \n \t I-Rechercher un etudiant "
				+ "\n \t II-Inscrire un etudiant à une matiere"
				+ "\n \t III-Desinscrire un etudiant d'une matiere"
				+ "\n \t IV-Saisit des notes et calcul de la moyenne"
				+ "\n\t V-Gestion des payements");
		
		displayWindow.setSize(1000,400);
		displayWindow.setLayout(new BorderLayout());
		displayWindow.add(TitreETMenu, BorderLayout.NORTH);
		displayWindow.add(text,BorderLayout.CENTER);
		displayWindow.add(StateBar, BorderLayout.SOUTH);
		displayWindow.setVisible(true);
		
		
	}
	
	public static void displayAffichage(JFrame displayWindow) {
		
		displayWindow.dispose();
		displayWindow = DisplayCreate();

		JMenuBar MenuBar =  Menu(displayWindow);
		
		Connection con = null;
		Statement stat = null;
		ResultSet result;
		ResultSetMetaData resultmeta;
		
		try {
	   		Class.forName(JDBC_DRIVER);
			con =  DriverManager.getConnection(DATABASE_URL, "root", "");
			stat = con.createStatement();
			
			int nbreid=0;
			
			result = stat.executeQuery("SELECT count(*) from Etudiant");
			if(result.next()) {
				nbreid = result.getInt(1);
			}
			result = stat.executeQuery("SELECT id_etudiant, nom_etudiant, prenom, type_etudiant, date_naissance from Etudiant");
			resultmeta = result.getMetaData();
			
			int column = resultmeta.getColumnCount();
			String[] head =  new String[column];
			
			for(int i=1; i<=column; i++) {
				head[i-1]= resultmeta.getColumnName(i);
			}
			
			String[][] Data= new String[nbreid][column];
			while(result.next()) {
				for(int i=1; i<=column; i++) {
					Data[result.getRow()-1][i-1]= result.getObject(i)+"";
				}
			}
			
			JScrollPane tableau = tableDefaut(head,Data);
			
			
			JLabel Titre = new JLabel("Affichage de Etudiants");
			
			JPanel TitreETMenu =  new JPanel(new GridLayout(3,1,5,2));
			JPanel StateBar = new JPanel(new GridLayout(1,1));
			
			JLabel State = new JLabel("Affichage de Etudiants");
			State.setForeground(Color.white);
			StateBar.setBackground(Color.green);
			StateBar.add(State);
			
			TitreETMenu.add(MenuBar);
			TitreETMenu.add(Titre);
			
			displayWindow.add(TitreETMenu, BorderLayout.NORTH);
			displayWindow.add(tableau,BorderLayout.CENTER);
			displayWindow.add(StateBar, BorderLayout.SOUTH);
			displayWindow.setVisible(true);
			
			
			
			
			
	   	} catch (SQLException e1) {
	
		e1.printStackTrace();
	   	} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	

	public static void Recherche(JFrame displayWindow) {
			displayWindow.dispose();
			displayWindow = DisplayCreate();
		

			JMenuBar MenuBar =  Menu(displayWindow);
			
			JLabel Titre = new JLabel("Recherche de Etudiant");
			JLabel Recherche = new JLabel("Sélectionner l'etudiant");
			JComboBox<String> entry = ListeEtudiant();
			JTextField blank = new JTextField();
			JButton rechercher = new JButton("Rechercher");
			rechercher.setBackground(Color.green);
			rechercher.setForeground(Color.white);
		
			blank.setFocusable(false);
			blank.setEditable(false);
			
			
			JPanel TitreETMenu =  new JPanel(new GridLayout(3,1,5,2));
			JPanel RecherchePan = new JPanel(new GridLayout(15,3,5,2));
			JPanel ResultRecherche = new JPanel(new GridLayout(3,1,5,2));
			JPanel StateBar = new JPanel(new GridLayout(1,1));
			
			JLabel State = new JLabel("Recherche de Etudiant");
			State.setForeground(Color.white);
			StateBar.setBackground(Color.green);
			StateBar.add(State);
			
			TitreETMenu.add(MenuBar);
			TitreETMenu.add(Titre);
			
			ResultRecherche.setVisible(false);
			
			ActionListener Rechercher = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						Class.forName(JDBC_DRIVER);
						
						Connection con = DriverManager.getConnection(DATABASE_URL, "root", "");
						Statement stat = con.createStatement();
						ResultSet rs = null;
						ResultSetMetaData resultmeta = null;
						int idEtudiant;
						DecimalFormat decimalFormat = new DecimalFormat();
						if(!(entry.getSelectedItem().toString().isEmpty())) {
							String elt = entry.getSelectedItem().toString();
							String[] part = elt.split("-", 2);
							String id = part[0];
							idEtudiant = decimalFormat.parse(id).intValue();
							rs = stat.executeQuery("SELECT id_etudiant, nom_etudiant, prenom, type_etudiant, date_naissance from etudiant where (id_etudiant = "+idEtudiant+")");
							resultmeta = rs.getMetaData();
							String[] head = new String[resultmeta.getColumnCount()];
							for(int i=1; i<=resultmeta.getColumnCount(); i++) {
								head[i-1] = resultmeta.getColumnName(i);
							}
							String[][] data =  new String[1][resultmeta.getColumnCount()];
							if(rs.next()) {
								for(int i=1; i<=resultmeta.getColumnCount(); i++) {
									data[0][i-1] = rs.getObject(i)+"";
								}	
								JScrollPane tableau = tableDefaut(head,data);
								ResultRecherche.add(tableau);
								ResultRecherche.revalidate();
								ResultRecherche.setVisible(true);
							}else {
								ResultRecherche.setVisible(false);
								ResultRecherche.removeAll();
								ResultRecherche.revalidate();
							}
						}else {
							JOptionPane.showMessageDialog(null, "Entrer un id d'etudiant valide", "erreur", JOptionPane.ERROR_MESSAGE);
						}
					} catch (SQLException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				};
			};
			
			
			
			RecherchePan.add(Recherche);
			RecherchePan.add(blank);
			RecherchePan.add(entry);
			RecherchePan.add(blank);
			RecherchePan.add(rechercher);
			
			rechercher.addActionListener(Rechercher);

			
			blank.setBackground(displayWindow.getBackground());
			blank.setBorder(null);
			
			displayWindow.add(TitreETMenu, BorderLayout.NORTH);
			displayWindow.add(RecherchePan, BorderLayout.WEST);
			displayWindow.add(ResultRecherche,BorderLayout.CENTER);
			displayWindow.add(StateBar, BorderLayout.SOUTH);
			displayWindow.setVisible(true);
	   	
			
			
			
		
	}
	

	public static void Note_Moyenne(JFrame displayWindow) {
			displayWindow.dispose();
			displayWindow = DisplayCreate();
		

			JMenuBar MenuBar =  Menu(displayWindow);
		
	
			
			JLabel Titre = new JLabel("Notes et moyenne d'un etudiant");
			JLabel Recherche = new JLabel("Sélectionner l'etudiant");
			JComboBox<String> entry = ListeEtudiant();
			JTextField blank = new JTextField();
			JButton rechercher = new JButton("Afficher bulletin");
			rechercher.setBackground(Color.green);
			rechercher.setForeground(Color.white);
			
			blank.setFocusable(false);
			blank.setEditable(false);
			
			
			JPanel TitreETMenu =  new JPanel(new GridLayout(3,1,5,2));
			JPanel RecherchePan = new JPanel(new GridLayout(15,3,5,2));
			JPanel ResultRecherche = new JPanel(new GridLayout(1,1,5,2));
			JPanel StateBar = new JPanel(new GridLayout(1,1));
			
			JLabel State = new JLabel("Notes et moyenne d'un etudiant");
			State.setForeground(Color.white);
			StateBar.setBackground(Color.green);
			StateBar.add(State);
			
			TitreETMenu.add(MenuBar);
			TitreETMenu.add(Titre);
			
			ResultRecherche.setVisible(false);
			
			
			ActionListener Rechercher = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						Class.forName(JDBC_DRIVER);
						ResultRecherche.removeAll();
						ResultRecherche.revalidate();
						Connection con = DriverManager.getConnection(DATABASE_URL, "root", "");
						Statement stat = con.createStatement();
						ResultSet rs = null;
						ResultSetMetaData resultmeta = null;
						int idEtudiant;
						DecimalFormat decimalFormat = new DecimalFormat();
						if(!(entry.getSelectedItem().toString().isEmpty())) {
							String elt = entry.getSelectedItem().toString();
							String[] part = elt.split("-", 2);
							String id = part[0];
							idEtudiant = decimalFormat.parse(id).intValue();
							rs = stat.executeQuery("SELECT id_etudiant, nom_etudiant, prenom, type_etudiant, date_naissance from etudiant where (id_etudiant = "+idEtudiant+")");
							resultmeta = rs.getMetaData();
							String[] head = new String[resultmeta.getColumnCount()];
							for(int i=1; i<=resultmeta.getColumnCount(); i++) {
								head[i-1] = resultmeta.getColumnName(i);
							}
							String[][] data =  new String[1][resultmeta.getColumnCount()];
							if(rs.next()) {
								for(int i=1; i<=resultmeta.getColumnCount(); i++) {
									data[0][i-1] = rs.getObject(i)+"";
								}	
								Etudiant E1 = new EtudiantDUT();
								E1.setIdEtudiant(idEtudiant);
								JScrollPane bulletin = E1.afficherBulletin();
								ResultRecherche.add(bulletin);
								ResultRecherche.revalidate();
								ResultRecherche.setVisible(true);
							}else {
								ResultRecherche.setVisible(false);
								ResultRecherche.removeAll();
								ResultRecherche.revalidate();
							}
						}else {
							JOptionPane.showMessageDialog(null, "Entrer un id d'etudiant valide", "erreur", JOptionPane.ERROR_MESSAGE);
						}
					} catch (SQLException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				};
			};
			
			
			
			RecherchePan.add(Recherche);
			RecherchePan.add(blank);
			RecherchePan.add(entry);
			RecherchePan.add(blank);
			RecherchePan.add(rechercher);
			
			rechercher.addActionListener(Rechercher);
			
			
			displayWindow.add(TitreETMenu, BorderLayout.NORTH);
			displayWindow.add(RecherchePan, BorderLayout.WEST);
			displayWindow.add(ResultRecherche,BorderLayout.CENTER);
			displayWindow.add(StateBar, BorderLayout.SOUTH);
			displayWindow.setVisible(true);
	   		
	}
	
	
	public static void GestionMatiere(JFrame displayWindow) {
		displayWindow.dispose();
		displayWindow = DisplayCreate();
	
		JMenuBar MenuBar =  Menu(displayWindow);

		JLabel Titre = new JLabel(" Gestion des inscriptions/desinscriptions");
		
		JLabel DeposerT = new JLabel("Inscription");
		DeposerT.setForeground(Color.green);
		DeposerT.setHorizontalAlignment(JLabel.CENTER);
		JLabel RetirerT = new JLabel("Desinsctiption");
		RetirerT.setForeground(Color.green);
		RetirerT.setHorizontalAlignment(JLabel.CENTER);
		
		JTextField blank = new JTextField();
		JTextField blank2 = new JTextField();
		JTextField blank3 = new JTextField();
		JTextField blank4 = new JTextField();
		JTextField blank5 = new JTextField();
		JTextField blank6 = new JTextField();
		JTextField blank7 = new JTextField();
		
		JLabel numcompteD = new  JLabel("Sélectionner l'etudiant");
		JLabel numcompteR = new  JLabel("Sélectionner l'etudiant");

		JLabel montant = new JLabel("Sélectionner la matiere");
		JLabel montantD = new JLabel("Sélectionner la matiere");

		
		JComboBox<String>  montantIR =  ListeMatiere();;
		JComboBox<String> numcompteIR = ListeEtudiant();
		JComboBox<String>  montantID =  ListeMatiere();
		JComboBox<String> numcompteID = ListeEtudiant();

		
		
		JButton Deposer = new JButton("Inscrire");
		Deposer.setBackground(Color.green);
		Deposer.setForeground(Color.white);
		
		JButton Retirer = new JButton("Desinscrire");
		Retirer.setBackground(Color.green);
		Retirer.setForeground(Color.white);
		
		
		blank.setFocusable(false);
		blank.setEditable(false);
		blank2.setFocusable(false);
		blank2.setEditable(false);
		blank3.setFocusable(false);
		blank3.setEditable(false);
		blank4.setFocusable(false);
		blank4.setEditable(false);
		blank5.setFocusable(false);
		blank5.setEditable(false);
		blank6.setFocusable(false);
		blank6.setEditable(false);
		blank7.setFocusable(false);
		blank7.setEditable(false);
		
		
		JPanel TitreETMenu =  new JPanel(new GridLayout(3,1,5,2));
		JPanel operationPan =  new JPanel(new GridLayout(1,2,8,7));
		JPanel depotPan = new JPanel(new GridLayout(15,1));
		JPanel retraitPan = new JPanel(new GridLayout(15,1));
		JPanel virementPan = new JPanel(new GridLayout(15,1));
		JPanel StateBar = new JPanel(new GridLayout(1,1));
		
		JLabel State = new JLabel(" Gestion des inscriptions/desinscriptions");
		State.setForeground(Color.white);
		StateBar.setBackground(Color.green);
		StateBar.add(State);
		
		TitreETMenu.add(MenuBar);
		TitreETMenu.add(Titre);
		
		depotPan.setBackground(Color.white);
		depotPan.add(DeposerT);
		depotPan.add(blank);
		depotPan.add(numcompteD);
		depotPan.add(numcompteID);
		depotPan.add(blank2);
		depotPan.add(montant);
		depotPan.add(montantID);
		depotPan.add(blank6);
		depotPan.add(Deposer);
		
		retraitPan.setBackground(Color.WHITE);
		retraitPan.add(RetirerT);
		retraitPan.add(blank3);
		retraitPan.add(numcompteR);
		retraitPan.add(numcompteIR);
		retraitPan.add(blank4);
		retraitPan.add(montantD);
		retraitPan.add(montantIR);
		retraitPan.add(blank7);
		retraitPan.add(Retirer);
		
		
		operationPan.add(depotPan);
		operationPan.add(retraitPan);	
		
		ActionListener DeposerAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DecimalFormat decimalFormat = new DecimalFormat();
				if(!(numcompteID.getSelectedItem().toString().isEmpty())) {
					String elt = numcompteID.getSelectedItem().toString();
					String[] part = elt.split("-", 2);
					String id = part[0];
					if(!(montantID.getSelectedItem().toString().isEmpty())) {
						String eltMat = montantID.getSelectedItem().toString();
						String[] partMat = eltMat.split("-", 2);
						String id_mat = partMat[0];
						try {
							int idEtu = decimalFormat.parse(id).intValue();
							Connection con = DriverManager.getConnection(DATABASE_URL, "root", "");
							Statement stat = con.createStatement();
							ResultSet rs = null;
							rs = stat.executeQuery("SELECT type_etudiant from etudiant where id_etudiant ="+idEtu+"");
							if(rs.next()) {
								if(rs.getString(1).toLowerCase().equals("dut")) {
									Etudiant C1 = new EtudiantDUT();
									int idMat = decimalFormat.parse(id_mat).intValue();
									C1.setIdEtudiant(idEtu);
									C1.inscrireMatiere(idMat, 0);
								}else {
									Etudiant C1 = new EtudiantLicence();
									int idMat = decimalFormat.parse(id_mat).intValue();
									C1.setIdEtudiant(idEtu);
									C1.inscrireMatiere(idMat, 0);
								}
							}else {
								JOptionPane.showMessageDialog(null, "Erreur", "Erreur", JOptionPane.ERROR_MESSAGE);
							}
						} catch (ParseException e1) {
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else {
						JOptionPane.showMessageDialog(null, "Veiller renseigner le id de la matiere", "Erreur", JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Veiller entrer l'id de l'etudiant", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
		};
		
		ActionListener RetirerAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(!( numcompteIR.getSelectedItem().toString().isEmpty())) {
					String elt = numcompteIR.getSelectedItem().toString();
					String[] part = elt.split("-", 2);
					String id = part[0];
					if(!(montantIR.getSelectedItem().toString().isEmpty())) {
						String eltMat = montantIR.getSelectedItem().toString();
						String[] partMat = eltMat.split("-", 2);
						String id_mat = partMat[0];
						DecimalFormat decimalFormat = new DecimalFormat();
						try {
							int idEtu = decimalFormat.parse(id).intValue();
							Connection con = DriverManager.getConnection(DATABASE_URL, "root", "");
							Statement stat = con.createStatement();
							ResultSet rs = null;
							rs = stat.executeQuery("SELECT type_etudiant from etudiant where id_etudiant ="+idEtu+"");
							if(rs.next()) {
								if(rs.getString(1).toLowerCase().equals("dut")) {
									Etudiant C1 = new EtudiantDUT();
									int idMat = decimalFormat.parse(id_mat).intValue();
									C1.setIdEtudiant(idEtu);
									C1.desinscrireMatiere(idMat);
								}else {
									Etudiant C1 = new EtudiantLicence();
									int idMat = decimalFormat.parse(id_mat).intValue();
									C1.setIdEtudiant(idEtu);
									C1.desinscrireMatiere(idMat);
								}
							}else {
								JOptionPane.showMessageDialog(null, "Erreur", "Erreur", JOptionPane.ERROR_MESSAGE);
							}
							
						} catch (ParseException | SQLException e1) {
							e1.printStackTrace();
						}
					}else {
						JOptionPane.showMessageDialog(null, "Veiller renseigner le id de la matiere", "Erreur", JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Veiller entrer l'id de l'etudiant", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
		};
		
		
		Deposer.addActionListener(DeposerAction);
		Retirer.addActionListener(RetirerAction);
		
		blank.setBackground(depotPan.getBackground());
		blank.setBorder(null);
		blank2.setBackground(depotPan.getBackground());
		blank2.setBorder(null);
		blank3.setBackground(retraitPan.getBackground());
		blank3.setBorder(null);
		blank4.setBackground(retraitPan.getBackground());
		blank4.setBorder(null);
		blank5.setBackground(virementPan.getBackground());
		blank5.setBorder(null);
		blank6.setBackground(virementPan.getBackground());
		blank6.setBorder(null);
		blank7.setBackground(virementPan.getBackground());
		blank7.setBorder(null);
		
		displayWindow.add(TitreETMenu, BorderLayout.NORTH);
		displayWindow.add(operationPan,BorderLayout.CENTER);
		displayWindow.add(StateBar, BorderLayout.SOUTH);
		displayWindow.setVisible(true);
   	
}

	public static void Note_Modification(JFrame displayWindow) {
		displayWindow.dispose();
		displayWindow = DisplayCreate();
	
		JMenuBar MenuBar =  Menu(displayWindow);

		JLabel Titre = new JLabel("  Saisie / modification des notes");
		
		JLabel DeposerT = new JLabel("Saisie - modification des notes");
		DeposerT.setForeground(Color.green);
		DeposerT.setHorizontalAlignment(JLabel.CENTER);
		JLabel RetirerT = new JLabel("Desinsctiption");
		RetirerT.setForeground(Color.green);
		RetirerT.setHorizontalAlignment(JLabel.CENTER);
		
		JTextField blank = new JTextField();
		JTextField blank2 = new JTextField();
		JTextField blank3 = new JTextField();
		JTextField blank4 = new JTextField();
		JTextField blank5 = new JTextField();
		JTextField blank6 = new JTextField();
		JTextField blank7 = new JTextField();
		
		JLabel numcompteD = new  JLabel("Sélectionner l'etudiant");

		JLabel montant = new JLabel("Sélectionner la matiere");
		
		JLabel note = new JLabel("Entrer la note à inserer ou à modifier");

		
		JTextField noteD = new JTextField();	
		JComboBox<String>  montantID =  ListeMatiere();
		JComboBox<String> numcompteID = ListeEtudiant();

		
		
		JButton Deposer = new JButton("Inserer-Modifier");
		Deposer.setBackground(Color.green);
		Deposer.setForeground(Color.white);
		
		
		blank.setFocusable(false);
		blank.setEditable(false);
		blank2.setFocusable(false);
		blank2.setEditable(false);
		blank3.setFocusable(false);
		blank3.setEditable(false);
		blank4.setFocusable(false);
		blank4.setEditable(false);
		blank5.setFocusable(false);
		blank5.setEditable(false);
		blank6.setFocusable(false);
		blank6.setEditable(false);
		blank7.setFocusable(false);
		blank7.setEditable(false);
		
		
		JPanel TitreETMenu =  new JPanel(new GridLayout(3,1,5,2));
		JPanel operationPan =  new JPanel(new GridLayout(1,2,8,7));
		JPanel depotPan = new JPanel(new GridLayout(15,1));
		JPanel retraitPan = new JPanel(new GridLayout(15,1));
		JPanel virementPan = new JPanel(new GridLayout(15,1));
		JPanel StateBar = new JPanel(new GridLayout(1,1));
		
		JLabel State = new JLabel("  Saisie / modification des notes");
		State.setForeground(Color.white);
		StateBar.setBackground(Color.green);
		StateBar.add(State);
		
		TitreETMenu.add(MenuBar);
		TitreETMenu.add(Titre);
		
		depotPan.setBackground(Color.white);
		depotPan.add(DeposerT);
		depotPan.add(blank);
		depotPan.add(numcompteD);
		depotPan.add(numcompteID);
		depotPan.add(blank2);
		depotPan.add(montant);
		depotPan.add(montantID);
		depotPan.add(blank3);
		depotPan.add(note);
		depotPan.add(noteD);
		depotPan.add(blank4);
		depotPan.add(Deposer);
				
		operationPan.add(depotPan);
		
		ActionListener DeposerAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DecimalFormat decimalFormat = new DecimalFormat();
				if(!(numcompteID.getSelectedItem().toString().isEmpty())) {
					String elt = numcompteID.getSelectedItem().toString();
					String[] part = elt.split("-", 2);
					String id = part[0];
					if(!(montantID.getSelectedItem().toString().isEmpty())) {
						String eltMat = montantID.getSelectedItem().toString();
						String[] partMat = eltMat.split("-", 2);
						String id_mat = partMat[0];
						try {
							int idEtu = decimalFormat.parse(id).intValue();
							Connection con = DriverManager.getConnection(DATABASE_URL, "root", "");
							Statement stat = con.createStatement();
							ResultSet rs = null;
							if(!(noteD.getText().isEmpty())) {
								double note = decimalFormat.parse(noteD.getText()).doubleValue();
								rs = stat.executeQuery("SELECT type_etudiant from etudiant where id_etudiant ="+idEtu+"");
								if(rs.next()) {
									if(rs.getString(1).toLowerCase().equals("dut")) {
										Etudiant C1 = new EtudiantDUT();
										int idMat = decimalFormat.parse(id_mat).intValue();
										C1.setIdEtudiant(idEtu);
										if(C1.inscrireMatiere(idMat, note)) {
											
										}else {
											if((stat.execute("UPDATE inscription set note = "+note+" where (id_etudiant = "+idEtu+" AND id_matiere = "+idMat+")"))== false) {
												JOptionPane.showMessageDialog(null, "Note Modifiée avec succès", "Modification", JOptionPane.INFORMATION_MESSAGE);
											}
										}
									}else {
										Etudiant C1 = new EtudiantLicence();
										int idMat = decimalFormat.parse(id_mat).intValue();
										C1.setIdEtudiant(idEtu);
										if(C1.inscrireMatiere(idMat, note)) {
											
										}else {
											if((stat.execute("UPDATE inscription set note = "+note+" where (id_etudiant = "+idEtu+" AND id_matiere = "+idMat+")"))== false) {
												JOptionPane.showMessageDialog(null, "Note Modifiée avec succès", "Modification", JOptionPane.INFORMATION_MESSAGE);
											}
										}
									}
								}else {
									JOptionPane.showMessageDialog(null, "Erreur", "Erreur", JOptionPane.ERROR_MESSAGE);
								}
							}else {
									JOptionPane.showMessageDialog(null, "Erreur", "Erreur", JOptionPane.ERROR_MESSAGE);
							}
							
						} catch (ParseException e1) {
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else {
						JOptionPane.showMessageDialog(null, "Veiller renseigner le id de la matiere", "Erreur", JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Veiller entrer l'id de l'etudiant", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
		};
		
		
		
		Deposer.addActionListener(DeposerAction);
		
		blank.setBackground(depotPan.getBackground());
		blank.setBorder(null);
		blank2.setBackground(depotPan.getBackground());
		blank2.setBorder(null);
		blank3.setBackground(depotPan.getBackground());
		blank3.setBorder(null);
		blank4.setBackground(depotPan.getBackground());
		blank4.setBorder(null);
		blank5.setBackground(depotPan.getBackground());
		blank5.setBorder(null);
		blank6.setBackground(virementPan.getBackground());
		blank6.setBorder(null);
		blank7.setBackground(virementPan.getBackground());
		blank7.setBorder(null);
		
		displayWindow.add(TitreETMenu, BorderLayout.NORTH);
		displayWindow.add(operationPan,BorderLayout.CENTER);
		displayWindow.add(StateBar, BorderLayout.SOUTH);
		displayWindow.setVisible(true);
   	
}
	
	public static void Payerfrais(JFrame displayWindow) {
		displayWindow.dispose();
		displayWindow = DisplayCreate();
	
		JMenuBar MenuBar =  Menu(displayWindow);

		JLabel Titre = new JLabel("  Payer Frais de scolarité");
		
		JLabel DeposerT = new JLabel("Frais de scolarité DUT 350dh / Licence 400dh");
		DeposerT.setForeground(Color.green);
		DeposerT.setHorizontalAlignment(JLabel.CENTER);
		
		JTextField blank = new JTextField();
		JTextField blank2 = new JTextField();
		JTextField blank3 = new JTextField();
		JTextField blank4 = new JTextField();
		JTextField blank5 = new JTextField();
		JTextField blank6 = new JTextField();
		JTextField blank7 = new JTextField();
		
		JLabel numcompteD = new  JLabel("Sélectionner l'etudiant");

		
		JLabel note = new JLabel("Entrer le montant à payer");

		
		JTextField noteD = new JTextField();	
		JComboBox<String> numcompteID = ListeEtudiant();

		
		
		JButton Deposer = new JButton("Payer les frais");
		Deposer.setBackground(Color.green);
		Deposer.setForeground(Color.white);
		
		
		blank.setFocusable(false);
		blank.setEditable(false);
		blank2.setFocusable(false);
		blank2.setEditable(false);
		blank3.setFocusable(false);
		blank3.setEditable(false);
		blank4.setFocusable(false);
		blank4.setEditable(false);
		blank5.setFocusable(false);
		blank5.setEditable(false);
		blank6.setFocusable(false);
		blank6.setEditable(false);
		blank7.setFocusable(false);
		blank7.setEditable(false);
		
		
		JPanel TitreETMenu =  new JPanel(new GridLayout(3,1,5,2));
		JPanel operationPan =  new JPanel(new GridLayout(1,2,8,7));
		JPanel depotPan = new JPanel(new GridLayout(15,1));
		JPanel retraitPan = new JPanel(new GridLayout(15,1));
		JPanel virementPan = new JPanel(new GridLayout(15,1));
		JPanel StateBar = new JPanel(new GridLayout(1,1));
		
		JLabel State = new JLabel("  Payer Frais de scolarité");
		State.setForeground(Color.white);
		StateBar.setBackground(Color.green);
		StateBar.add(State);
		
		TitreETMenu.add(MenuBar);
		TitreETMenu.add(Titre);
		
		depotPan.setBackground(Color.white);
		depotPan.add(DeposerT);
		depotPan.add(blank);
		depotPan.add(numcompteD);
		depotPan.add(numcompteID);
		depotPan.add(blank3);
		depotPan.add(note);
		depotPan.add(noteD);
		depotPan.add(blank4);
		depotPan.add(Deposer);
				
		operationPan.add(depotPan);
		
		ActionListener DeposerAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DecimalFormat decimalFormat = new DecimalFormat();
				if(!(numcompteID.getSelectedItem().toString().isEmpty())) {
					String elt = numcompteID.getSelectedItem().toString();
					String[] part = elt.split("-", 2);
					String id = part[0];
					
						try {
							int idEtu = decimalFormat.parse(id).intValue();
							Connection con = DriverManager.getConnection(DATABASE_URL, "root", "");
							Statement stat = con.createStatement();
							ResultSet rs = null;
							if(!(noteD.getText().isEmpty())) {
								double note = decimalFormat.parse(noteD.getText()).doubleValue();
								rs = stat.executeQuery("SELECT type_etudiant from etudiant where id_etudiant ="+idEtu+"");
								if(rs.next()) {
									if(rs.getString(1).toLowerCase().equals("dut")) {
										Etudiant C1 = new EtudiantDUT();
										C1.setIdEtudiant(idEtu);
										C1.payerFraisScolaire(note);
									}else {
										Etudiant C1 = new EtudiantLicence();
										C1.setIdEtudiant(idEtu);
										C1.payerFraisScolaire(note);
									}
								}else {
									JOptionPane.showMessageDialog(null, "Erreur", "Erreur", JOptionPane.ERROR_MESSAGE);
								}
							}else {
									JOptionPane.showMessageDialog(null, "Erreur", "Erreur", JOptionPane.ERROR_MESSAGE);
							}
							
						} catch (ParseException e1) {
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
				}else {
					JOptionPane.showMessageDialog(null, "Veiller entrer l'id de l'etudiant", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
		};
		
		
		
		Deposer.addActionListener(DeposerAction);
		
		blank.setBackground(depotPan.getBackground());
		blank.setBorder(null);
		blank2.setBackground(depotPan.getBackground());
		blank2.setBorder(null);
		blank3.setBackground(depotPan.getBackground());
		blank3.setBorder(null);
		blank4.setBackground(depotPan.getBackground());
		blank4.setBorder(null);
		blank5.setBackground(depotPan.getBackground());
		blank5.setBorder(null);
		blank6.setBackground(virementPan.getBackground());
		blank6.setBorder(null);
		blank7.setBackground(virementPan.getBackground());
		blank7.setBorder(null);
		
		displayWindow.add(TitreETMenu, BorderLayout.NORTH);
		displayWindow.add(operationPan,BorderLayout.CENTER);
		displayWindow.add(StateBar, BorderLayout.SOUTH);
		displayWindow.setVisible(true);
   	
}

	
	public static void displayPaiements(JFrame displayWindow) {
		displayWindow.dispose();
		displayWindow = DisplayCreate();
		JMenuBar MenuBar =  Menu(displayWindow);
		
		Connection con = null;
		Statement stat = null;
		ResultSet result;
		ResultSetMetaData resultmeta;
		
		try {
	   		Class.forName(JDBC_DRIVER);
			con =  DriverManager.getConnection(DATABASE_URL, "root", "");
			stat = con.createStatement();
			
			int nbreid=0;
			
			result = stat.executeQuery("SELECT count(*) from paiement");
			if(result.next()) {
				nbreid = result.getInt(1);
			}
			result = stat.executeQuery("SELECT * from paiement");
			resultmeta = result.getMetaData();
			
			int column = resultmeta.getColumnCount();
			String[] head =  new String[column];
			
			for(int i=1; i<=column; i++) {
				head[i-1]= resultmeta.getColumnName(i);
			}
			
			
			String[][] Data= new String[nbreid][column];
			while(result.next()) {
				for(int i=1; i<=column; i++) {
					Data[result.getRow()-1][i-1]= result.getObject(i)+"";
				}
			}
			
			JScrollPane tableau = tableDefaut(head,Data);
			
			
			JLabel Titre = new JLabel(" Historique des paiements");
			
			JPanel TitreETMenu =  new JPanel(new GridLayout(3,1,5,2));
			JPanel ResumeIntro = new JPanel(new GridLayout(3,1,5,2));
			JPanel StateBar = new JPanel(new GridLayout(1,1));
			
			JLabel State = new JLabel(" Historique des paiements");
			State.setForeground(Color.white);
			StateBar.setBackground(Color.green);
			StateBar.add(State);
			
			TitreETMenu.add(MenuBar);
			TitreETMenu.add(Titre);

			
			displayWindow.add(TitreETMenu, BorderLayout.NORTH);
			displayWindow.add(tableau,BorderLayout.CENTER);
			displayWindow.add(StateBar, BorderLayout.SOUTH);
			displayWindow.setVisible(true);
			
			
			
			
			
	   	} catch (SQLException e1) {
	
		e1.printStackTrace();
	   	} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	
	public static JScrollPane tableDefaut(String[] head, String[][] data) {
		
		JTable table = new JTable(data,head);
		table.setFocusable(false);
		table.setBackground(Color.WHITE);
		table.setForeground(Color.black);
		table.setCellSelectionEnabled(false);
		table.setEnabled(false);
		table.setRowSelectionAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(table);
		
		
		return scrollPane;
	}

	public static JMenuBar Menu(JFrame displayWindow){
		JMenuItem HistoriqueDesOP =  new JMenuItem(" Historique des paiements"); 
		JMenuItem Paimentfrais =  new JMenuItem(" Payer frais de scolarité"); 
		JMenuItem rechercheEtudiant =  new JMenuItem(" Rechercher etudiant par nom/niveau");
		JMenuItem AffichageEtudiant =  new JMenuItem(" Affichage des Etudiants");
		JMenuItem ModificationEtudiant =  new JMenuItem(" Gestion des inscriptions/desinscriptions");
		JMenuItem NoteEtudiant =  new JMenuItem(" Note et Moyenne");
		JMenuItem NotesSaisies =  new JMenuItem(" Saisie / modification des notes");
		
		JMenu Menu = new JMenu("Menu");
		Menu.add(AffichageEtudiant);
		Menu.add(rechercheEtudiant);
		Menu.add(NotesSaisies);
		Menu.add(NoteEtudiant);
		Menu.add(ModificationEtudiant);
		Menu.add(Paimentfrais);
		Menu.add(HistoriqueDesOP);
		Menu.setForeground(Color.green);
		
		JMenuBar MenuB = new JMenuBar();
		MenuB.add(Menu);

		ActionListener MenuSelect = MenuSelect(displayWindow);

		AffichageEtudiant.addActionListener(MenuSelect);
		rechercheEtudiant.addActionListener(MenuSelect);
		HistoriqueDesOP.addActionListener(MenuSelect);
		NotesSaisies.addActionListener(MenuSelect);
		ModificationEtudiant.addActionListener(MenuSelect);
		NoteEtudiant.addActionListener(MenuSelect);
		Paimentfrais.addActionListener(MenuSelect);
		return MenuB;
	}

	public static ActionListener MenuSelect(JFrame displayWindow){
		ActionListener MenuSelect = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JMenuItem option = (JMenuItem)e.getSource();
				if(option.getText().equals(" Affichage des Etudiants")) {
					displayAffichage(displayWindow);
				}else if(option.getText().equals(" Rechercher etudiant par nom/niveau")) {
					Recherche(displayWindow);
				}else if(option.getText().equals(" Gestion des inscriptions/desinscriptions")) {
					GestionMatiere(displayWindow);
				}else if(option.getText().equals(" Note et Moyenne")) {
					Note_Moyenne(displayWindow);
				}else if(option.getText().equals(" Saisie / modification des notes")) {
					Note_Modification(displayWindow);
				}else if(option.getText().equals(" Historique des paiements")) {
					displayPaiements(displayWindow);
				}else if(option.getText().equals(" Payer frais de scolarité")) {
					Payerfrais(displayWindow);
				}
				
			}
			
		
		};
		return MenuSelect;
	}

	public static JFrame DisplayCreate(){
		JFrame display = new JFrame("Acuueil");
		display.setSize(1000,400);
		display.setLayout(new BorderLayout());
		display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.gc();
		return display;
	}
	
	public static JComboBox<String> ListeEtudiant() {
		JComboBox<String> Maliste = null;
		try {
			Connection con = DriverManager.getConnection(DATABASE_URL, "root", "");
			Statement stat = con.createStatement();
			ResultSet rs=null;
			
			rs  = stat.executeQuery("SELECT count(*) from etudiant");
			int nbrMat = 0;
			if(rs.next()) {
				nbrMat = rs.getInt(1);
			}
			String[] Etudiant =  new String[nbrMat];
			int i = 0;
			rs = stat.executeQuery("SELECT id_etudiant, nom_etudiant, prenom from Etudiant");
			while(rs.next()) {
				Etudiant[i] = rs.getInt(1)+""+"-"+rs.getString(2)+" "+rs.getString(3);
				i++;
			}
			Maliste = new JComboBox<String>(Etudiant);
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return Maliste;

	}
	
	public static JComboBox<String> ListeMatiere() {
		JComboBox<String> Maliste = null;
		try {
			Connection con = DriverManager.getConnection(DATABASE_URL, "root", "");
			Statement stat = con.createStatement();
			ResultSet rs=null;
			
			rs  = stat.executeQuery("SELECT count(*) from matiere");
			int nbrMat = 0;
			if(rs.next()) {
				nbrMat = rs.getInt(1);
			}
			String[] Matiere =  new String[nbrMat];
			int i = 0;
			rs = stat.executeQuery("SELECT id_matiere, nom_matiere from matiere");
			while(rs.next()) {
				Matiere[i] = rs.getInt(1)+""+"-"+rs.getString(2);
				i++;
			}
			Maliste = new JComboBox<String>(Matiere);
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return Maliste;

	}
}
