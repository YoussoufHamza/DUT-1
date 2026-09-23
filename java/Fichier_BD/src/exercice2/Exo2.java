package exercice2;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class Exo2 {
	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DATABASE_URL = "jdbc:mysql://localhost/java_bd";
	
	public static void main(String[] args) {
		
		
		JTextField nom, tel, service;
		nom = new JTextField();
		tel = new JTextField();
		service = new JTextField();
		
		JLabel nomL, telL, serviceL, titre;
		nomL= new JLabel("Nom :");
		telL= new JLabel("Telephone :");
		serviceL= new JLabel("Service :");
		titre= new JLabel("Bienvenue dans notre application de gestion des employés ");
		
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
		fenetre.setSize(300,200);
		fenetre.setVisible(true);
		fenetre.setLayout(new BorderLayout());
		fenetre.add(InfoTitre, BorderLayout.NORTH);
		fenetre.add(InfoEntry, BorderLayout.CENTER);
		fenetre.add(InfoButton, BorderLayout.SOUTH);
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
