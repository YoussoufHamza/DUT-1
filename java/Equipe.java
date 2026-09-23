
import java.util.ArrayList;

public class Equipe{
    private String nom;
    private ArrayList Joueur;
    private int nbrejouer=0;

    public Equipe(){
        
    }

    public Equipe(String nom){
        this.nom = nom;
        this.Joueur = new ArrayList<Joueur>(11);
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public String getNom(){
        return this.nom;
    }

    public void ajouterJouer(Joueur joueur){
        if(this.nbrejouer <= 10 ){
            this.Joueur.add(joueur);
            this.nbrejouer++;
        }
    }

    public void afficherEquipe(){
        Joueur[] tabjoueur;
        tabjoueur = new Joueur[nbrejouer];
        tabjoueur = (Joueur[]) this.Joueur.toArray(tabjoueur); 

        int i;
        for (i = 0; i < nbrejouer; i++) {
            System.out.println("N° "+tabjoueur[i].getNumero()+" "+tabjoueur[i].getNom()+" "+tabjoueur[i].getPrenom()+" poste "+tabjoueur[i].getPoste()+"");
        }
    }
}



