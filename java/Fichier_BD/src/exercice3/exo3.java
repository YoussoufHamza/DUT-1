package exercice3;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class exo3 {
	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DATABASE_URL = "jdbc:mysql://localhost/java_bd";
	
	public static void main(String[] args) {
		
		JMenuItem RechercherEm= new JMenuItem("Rechercher un employé"), serviceEm= new JMenuItem("Employés par services"), ParcourirEm= new JMenuItem("Parcourir les employés"), AjouterEm= new JMenuItem("Ajouter un employé"),SupprimerEm = new JMenuItem("Supprimer"); 
		JMenu Menu = new JMenu("Menu");
		Menu.add(RechercherEm);
		Menu.add(serviceEm);
		Menu.add(ParcourirEm);
		Menu.add(AjouterEm);
		Menu.add(SupprimerEm);
		JMenuBar MenuBar = new JMenuBar();
		MenuBar.add(Menu);
		
		JTextField nom, tel, service;
		nom = new JTextField();
		tel = new JTextField();
		service = new JTextField();
		
		JLabel nomL, telL, serviceL, titre;
		nomL= new JLabel("Nom :");
		telL= new JLabel("Telephone :");
		serviceL= new JLabel("Service :");
		titre= new JLabel("Bienvenue dans notre application de gestion des employés veillez selectionner une option ");
		
		JButton Ajouter = new JButton("Ajouter");
		
		JPanel InfoEntry =  new JPanel(new GridLayout(4,2));
		JPanel InfoTitre =  new JPanel(new GridLayout(2,1));
		JPanel InfoButton =  new JPanel(new GridLayout(2,1));
		
		InfoEntry.add(nomL);
		InfoEntry.add(nom);
		InfoEntry.add(telL);
		InfoEntry.add(tel);
		InfoEntry.add(serviceL);
		InfoEntry.add(service);
		
		InfoTitre.add(titre);
		
		InfoButton.add(Ajouter);
		
		JFrame fenetre = new JFrame("Ajout d'employé");
		fenetre.setSize(800,100);
		fenetre.setVisible(true);
		fenetre.setLayout(new BorderLayout());
		fenetre.add(MenuBar, BorderLayout.NORTH);
		fenetre.add(InfoTitre, BorderLayout.CENTER);
		
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		ActionListener AjouterEmploye = new ActionListener() {
				 @Override
				 public void actionPerformed(ActionEvent e) {
					 	Connection con = null;
						Statement stat = null;
						Statement stat1 = null;
						ResultSet result;
						ResultSetMetaData resultmeta;
						String displayResult= "";
						String nomE="test";
						String telE="test";
						String serviceE="test";
						nomE = nom.getText();
						telE = tel.getText();
						serviceE = service.getText();
		               if((nomE.isEmpty())&&(telE.isEmpty())&&(serviceE.isEmpty())) {
		            	   JOptionPane option = new JOptionPane();
		            	   option.showMessageDialog(null, "Remplir correctement les champs demandés", "Ajout d'un employés", JOptionPane.INFORMATION_MESSAGE);
		               }else{
		            	   try {
		            	   		Class.forName(JDBC_DRIVER);
		            			con =  DriverManager.getConnection(DATABASE_URL, "root", "");
		            			stat = con.createStatement();
		            			
		            			int nbreid=0;
		            			
		            			result = stat.executeQuery("SELECT count(*) from employes");
		            			if(result.next()) {
		            				nbreid = result.getInt(1);
		            			}
		            			nbreid++;
		            	   		stat1 = con.createStatement();
		            	   		stat1.execute("INSERT INTO employes VALUE ("+nbreid+", '"+nomE+"', '"+telE+"', '"+serviceE+"')");
		            	   		result = stat.executeQuery("SELECT * from employes");
		            			resultmeta = result.getMetaData();
		            			DisplayData(con, stat, result, resultmeta, displayResult);
		            	   	} catch (SQLException e1) {
						
							e1.printStackTrace();
		            	   	} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
		            	 }
		          }
		};
		Ajouter.addActionListener(AjouterEmploye);
		
		
		
		ActionListener Recherchedis = new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 fenetre.dispose();
				 JFrame rWindow =  new JFrame("Rechercher un employé");
				 rWindow.setVisible(true);
				 rWindow.setSize(800,200);
				 rWindow.setLayout(new BorderLayout());
				 
				 JPanel InfoTitreR =  new JPanel(new GridLayout(2,1));
				 JPanel InfoR =  new JPanel(new GridLayout(2,2));
				 JPanel BoutonR =  new JPanel(new GridLayout(2,1));
				 JTextField idR;
				 JButton Recher =  new JButton("Rechercher");
				 JLabel idRL =  new JLabel("Entrer L'ID :");
				 JLabel titreR =  new JLabel("Section de Recheche : Veillez entrer l'Id de l'employé recherché");
				 idR = new JTextField();
				 
				 InfoTitreR.add(titreR);
				 InfoR.add(idRL);
				 InfoR.add(idR);
				 BoutonR.add(Recher);
				 
				 
				 rWindow.add(InfoTitre, BorderLayout.NORTH);
				 rWindow.add(InfoR, BorderLayout.CENTER);
				 rWindow.add(BoutonR, BorderLayout.SOUTH);
				  
				 
				 
				 ActionListener AfiicherEmploye = new ActionListener() {
					 @Override
					 public void actionPerformed(ActionEvent e) {
						 	Connection con = null;
							Statement stat = null;
							ResultSet result;
							ResultSetMetaData resultmeta;
							String displayResult= "";
							String IdE="test";
							IdE = idR.getText();
			               if((IdE.isEmpty())) {
			            	   JOptionPane option = new JOptionPane();
			            	   option.showMessageDialog(null, "Remplir correctement le champ demandé", "Ajout d'un employés", JOptionPane.INFORMATION_MESSAGE);
			               }else{
			            	   try {
			            	   		Class.forName(JDBC_DRIVER);
			            			con =  DriverManager.getConnection(DATABASE_URL, "root", "");
			            			stat = con.createStatement();
			            			
			            	   		result = stat.executeQuery("SELECT * from employes where (IdEmp like "+IdE+")");
			            			resultmeta = result.getMetaData();
			            			DisplayData(con, stat, result, resultmeta, displayResult);
			            	   	} catch (SQLException e1) {
							
								e1.printStackTrace();
			            	   	} catch (ClassNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
			            	 }
			          }
					
			};
			
				 Recher.addActionListener(AfiicherEmploye);
				 
				 rWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				 
			 }
		};
			
		RechercherEm.addActionListener(Recherchedis);
		
		ActionListener AjouterEmp = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fenetre.dispose();
				JTextField nom, tel, service;
				nom = new JTextField();
				tel = new JTextField();
				service = new JTextField();
				
				JLabel nomL, telL, serviceL, titre;
				nomL= new JLabel("Nom :");
				telL= new JLabel("Telephone :");
				serviceL= new JLabel("Service :");
				titre= new JLabel("Ajout des employés ");
				
				JButton Ajouter = new JButton("Ajouter");
				
				JPanel InfoEntry =  new JPanel(new GridLayout(4,2));
				JPanel InfoTitre =  new JPanel(new GridLayout(2,1));
				JPanel InfoButton =  new JPanel(new GridLayout(2,1));
				
				InfoEntry.add(nomL);
				InfoEntry.add(nom);
				InfoEntry.add(telL);
				InfoEntry.add(tel);
				InfoEntry.add(serviceL);
				InfoEntry.add(service);
				
				InfoTitre.add(titre);
				
				InfoButton.add(Ajouter);
				
				JFrame AWindow = new JFrame("Ajout d'employé");
				AWindow.setSize(500,300);
				AWindow.setVisible(true);
				AWindow.setLayout(new BorderLayout());
				AWindow.add(InfoTitre, BorderLayout.NORTH);
				AWindow.add(InfoEntry, BorderLayout.CENTER);
				AWindow.add(InfoButton, BorderLayout.SOUTH);
				AWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				
				ActionListener AjouterEmploye = new ActionListener() {
						 @Override
						 public void actionPerformed(ActionEvent e) {
							 	Connection con = null;
								Statement stat = null;
								Statement stat1 = null;
								ResultSet result;
								ResultSetMetaData resultmeta;
								String displayResult= "";
				               String nomE="test";
				               String telE="test";
				               String serviceE="test";
				               nomE = nom.getText();
				               telE = tel.getText();
				               serviceE = service.getText();
				               if((nomE.isEmpty())&&(telE.isEmpty())&&(serviceE.isEmpty())) {
				            	   JOptionPane option = new JOptionPane();
				            	   option.showMessageDialog(null, "Remplir correctement les champs demandés", "Ajout d'un employés", JOptionPane.INFORMATION_MESSAGE);
				               }else{
				            	   try {
				            	   		Class.forName(JDBC_DRIVER);
				            			con =  DriverManager.getConnection(DATABASE_URL, "root", "");
				            			stat = con.createStatement();
				            			
				            			int nbreid=0;
				            			
				            			result = stat.executeQuery("SELECT count(*) from employes");
				            			if(result.next()) {
				            				nbreid = result.getInt(1);
				            			}
				            			nbreid++;
				            	   		stat1 = con.createStatement();
				            	   		stat1.execute("INSERT INTO employes VALUE ("+nbreid+", '"+nomE+"', '"+telE+"', '"+serviceE+"')");
				            	   		result = stat.executeQuery("SELECT * from employes");
				            			resultmeta = result.getMetaData();
				            			DisplayData(con, stat, result, resultmeta, displayResult);
				            	   	} catch (SQLException e1) {
								
									e1.printStackTrace();
				            	   	} catch (ClassNotFoundException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
				            	 }
				          }
				};
				Ajouter.addActionListener(AjouterEmploye);
				
			}
			
		};
		
		AjouterEm.addActionListener(AjouterEmp);
		
		ActionListener Supprimerdis = new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 fenetre.dispose();
				 JFrame rWindow =  new JFrame("Rechercher un employé");
				 rWindow.setVisible(true);
				 rWindow.setSize(800,200);
				 rWindow.setLayout(new BorderLayout());
				 
				 JPanel InfoTitreR =  new JPanel(new GridLayout(2,1));
				 JPanel InfoR =  new JPanel(new GridLayout(2,2));
				 JPanel BoutonR =  new JPanel(new GridLayout(2,1));
				 JTextField idR;
				 JButton Recher =  new JButton("Rechercher");
				 JLabel idRL =  new JLabel("Entrer L'ID :");
				 JLabel titreR =  new JLabel("Section de suppression : Veillez entrer l'Id de l'employé supprimé");
				 idR = new JTextField();
				 
				 InfoTitreR.add(titreR);
				 InfoR.add(idRL);
				 InfoR.add(idR);
				 BoutonR.add(Recher);
				 
				 
				 rWindow.add(InfoTitre, BorderLayout.NORTH);
				 rWindow.add(InfoR, BorderLayout.CENTER);
				 rWindow.add(BoutonR, BorderLayout.SOUTH);
				  
				 
				 
				 ActionListener AfiicherEmploye = new ActionListener() {
					 @Override
					 public void actionPerformed(ActionEvent e) {
						 	Connection con = null;
							Statement stat = null;
							Statement stat1 = null;
							ResultSet result;
							ResultSetMetaData resultmeta;
							String displayResult= "";
							String IdE="test";
							IdE = idR.getText();
			               if((IdE.isEmpty())) {
			            	   JOptionPane option = new JOptionPane();
			            	   option.showMessageDialog(null, "Remplir correctement le champ demandé", "Ajout d'un employés", JOptionPane.INFORMATION_MESSAGE);
			               }else{
			            	   try {
			            	   		Class.forName(JDBC_DRIVER);
			            			con =  DriverManager.getConnection(DATABASE_URL, "root", "");
			            			stat = con.createStatement();
			            			stat1 = con.createStatement();
			            			
			            			stat1.execute("DELETE FROM employes where (IdEmp like "+IdE+")");
			            			
			            			result = stat.executeQuery("SELECT * from employes");
			            			resultmeta = result.getMetaData();
			            			DisplayData(con, stat, result, resultmeta, displayResult);
			            	   	} catch (SQLException e1) {
							
								e1.printStackTrace();
			            	   	} catch (ClassNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
			            	 }
			          }
					
			};
			
				 Recher.addActionListener(AfiicherEmploye);
				 
				 rWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				 
			 }
		};
			
		SupprimerEm.addActionListener(Supprimerdis);
	}
	
	public static void DisplayData(Connection con, Statement stat, ResultSet result, ResultSetMetaData resultmeta, String displayResult) {
		try {
			
			int column = resultmeta.getColumnCount();
			for(int i=1; i<=column; i++) {
				displayResult += resultmeta.getColumnName(i) +"\t";
			}
			displayResult += "\n----------------------------------------------------- ";
			displayResult += "----------------------------------------------------- \n";
			
			while(result.next()) {
				for(int i=1; i<=column; i++) {
					displayResult += result.getObject(i) +"\t";
				}
				displayResult += "\n";
			}
			
			JOptionPane option = new JOptionPane();
			option.showMessageDialog(null, new JTextArea(displayResult), "Ajout d'un employés", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
