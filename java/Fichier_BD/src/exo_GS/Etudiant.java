package exo_GS;

import javax.swing.JScrollPane;

public interface Etudiant {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DATABASE_URL = "jdbc:mysql://localhost/java_bd";
	static final double FRAIS_SCOLARITE_DUT = 350.0;
	static final double FRAIS_SCOLARITE_LICENCE = 400.0;
	
	public abstract boolean inscrireMatiere(int id_matiere, double note);
	public abstract double calculerMoyenne();
	public abstract void desinscrireMatiere(int id_matiere);
	public abstract void payerFraisScolaire(double montant);
	public abstract JScrollPane afficherBulletin();
	public abstract void setIdEtudiant(int id_etudiant);
}
