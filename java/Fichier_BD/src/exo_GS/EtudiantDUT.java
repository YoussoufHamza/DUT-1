package exo_GS;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class EtudiantDUT implements Etudiant{
	double moyenne;
	int idEtudiant;

	@Override
	public boolean inscrireMatiere(int id_matiere, double note) {
		try {
			Connection con = DriverManager.getConnection(DATABASE_URL, "root", "");
			Statement stat = null;
			ResultSet rs =  null;
			stat = con.createStatement();
			
			rs  = stat.executeQuery("SELECT nom_etudiant from Etudiant Where id_etudiant = "+this.idEtudiant+"");
			if(rs.next()) {
				String nomE = rs.getString(1);
				rs = stat.executeQuery("SELECT id_matiere, nom_matiere from matiere where id_matiere ="+id_matiere+"");
				if(rs.next()) {
					String nomM = rs.getString(2);
					if((stat.execute("INSERT INTO inscription values ("+this.idEtudiant+", "+id_matiere+", now(), "+note+")") == false)) {
						JOptionPane.showMessageDialog(null, "Inscription de  "+nomE+" en "+nomM+" réussit avec succès ", "Inscription", JOptionPane.INFORMATION_MESSAGE);
						return true;
					}else {
						JOptionPane.showMessageDialog(null, "Inscription de  "+nomE+"en "+nomM+" impossible", "Inscription", JOptionPane.WARNING_MESSAGE);
						return false;
					}
				}
			}
		}catch(SQLException ex) {
			
		}
		return false;
		
	}

	@Override
	public double calculerMoyenne() {
		double moy =0;
		double somMat = 0;
		int somCoef = 0;
		try {
			Connection con = DriverManager.getConnection(DATABASE_URL, "root", "");
			Statement stat = null;
			Statement stat2 = null;
			ResultSet rs =  null;
			ResultSet rs2 =  null;
			stat = con.createStatement();
			stat2 = con.createStatement();
			
			rs  = stat.executeQuery("SELECT note, id_matiere from inscription as ins, etudiant as et Where (ins.id_etudiant = "+this.idEtudiant+")");
			while(rs.next()) {
				int idMat = rs.getInt(2);
				rs2 = stat2.executeQuery("SELECT note*coefficient, coefficient from matiere as mat, inscription as ins where (ins.id_matiere = "+idMat+" AND ins.id_matiere = mat.id_matiere)");
				if(rs2.next()) {
					somMat+=rs2.getDouble(1);
					somCoef+=rs2.getInt(2);
				}
			}
			moy = somMat/somCoef;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return moy;
	}

	@Override
	public void desinscrireMatiere(int id_matiere) {
		try {
			Connection con = DriverManager.getConnection(DATABASE_URL, "root", "");
			Statement stat = null;
			
			stat = con.createStatement();
			if((stat.execute("DELETE FROM inscription as ins where (ins.id_matiere = "+id_matiere+" AND ins.id_etudiant = "+this.idEtudiant+")"))== false) {
				JOptionPane.showMessageDialog(null, "Desinscription effectué avec succès ", "Désinscription", JOptionPane.INFORMATION_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, "Desinscription impossible ", "Désinscription", JOptionPane.WARNING_MESSAGE);
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void payerFraisScolaire(double montant) {
		try {
			Connection con = DriverManager.getConnection(DATABASE_URL, "root", "");
			Statement stat = null;
			
			stat = con.createStatement();
			if(montant>FRAIS_SCOLARITE_DUT) {
				if((stat.execute("INSERT INTO paiement(id_etudiant, montant, date_payement) values ("+this.idEtudiant+", "+montant+", now())"))== false) {
					JOptionPane.showMessageDialog(null, "Paiement effectué avec succès ", "Paiement", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Paiement impossible ", "Paiement", JOptionPane.WARNING_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(null, "Paiement impossible montant insuffisant / au dessus du montant attendu", "Paiement", JOptionPane.WARNING_MESSAGE);
			}
			
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public JScrollPane afficherBulletin() {
		String Mat;
		String Coef;
		String decision, decisionf="Validée";
		String[] head= {"Matière", "Coefficient", "Note", "Décision"};
		String[][] data;
		
		try {
			Connection con = DriverManager.getConnection(DATABASE_URL, "root", "");
			Statement stat = null;
			Statement stat2 = null;
			ResultSet rs =  null;
			ResultSet rs2 =  null;
			stat = con.createStatement();
			stat2 = con.createStatement();
			rs  = stat.executeQuery("SELECT count(*) from inscription as ins, etudiant as et Where (ins.id_etudiant = "+this.idEtudiant+" AND et.id_etudiant = "+this.idEtudiant+")");
			int nbrMat = 0;
			if(rs.next()) {
				nbrMat = rs.getInt(1);
			}
			data = new String[nbrMat+3][4];
			
			rs  = stat.executeQuery("SELECT note, id_matiere from inscription as ins, etudiant as et Where (ins.id_etudiant = "+this.idEtudiant+" AND et.id_etudiant = "+this.idEtudiant+")");
			int k = 0;
			while(rs.next()) {
				double note = rs.getDouble(1);
				int idMat = rs.getInt(2);
				
				rs2 = stat2.executeQuery("SELECT coefficient, nom_matiere from matiere as mat, inscription as ins where (ins.id_matiere = "+idMat+" AND ins.id_matiere = mat.id_matiere)");
				if(rs2.next()) {
					Mat = rs2.getString(2);
					Coef = rs2.getInt(1)+"";
					if(note >= 12) {
						decision = "Validée";
					}else {
						decision = "Non validée";
						decisionf = "Non Validé";
					}
					
					data[k][0] = Mat;
					data[k][1] = Coef;
					data[k][2] = note+"";
					data[k][3] = decision;
					
					k++;
				}
			}
			data[nbrMat+1][0] = "Moyenne : ";
			data[nbrMat+1][3] = this.calculerMoyenne()+"";
			data[nbrMat+2][0] = "Décision finale : ";
			data[nbrMat+2][3] = decisionf;
			JScrollPane bulletin= tableDefaut(head, data);
			return bulletin;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public void setIdEtudiant(int id_etudiant) {
		try {
			Connection con = DriverManager.getConnection(DATABASE_URL, "root", "");
			Statement stat = null;
			ResultSet rs =  null;
			stat = con.createStatement();
			
			rs  = stat.executeQuery("SELECT nom_etudiant from Etudiant Where id_etudiant = "+id_etudiant+"");
			if(rs.next()) {
				this.idEtudiant = id_etudiant;
			}else {
				JOptionPane.showMessageDialog(null, "Etudiant(e) inconnu(e) ","Etudiant", JOptionPane.WARNING_MESSAGE);
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
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

}
