public class Livre{
    private int id =0;
    private static int nbrelivre=0;
    private String titre;
    private String auteur;
    private double prix;

    public Livre(){
        
    }

    public Livre(String titre, String auteur, double prix){
        this.titre = titre;
        this.auteur = auteur;
        this.prix = prix;
        this.nbrelivre++;
        this.id = this.nbrelivre;
    }

    public void setTitre(String titre){
        this.titre = titre;
    }

    public void setAuteur(String auteur){
        this.auteur = auteur;
    }

    public void setprix(double prix){
        this.prix = prix;
    }

    public String getTitre(){
        return this.titre;
    }

    public String getAuteur(){
        return this.auteur;
    }

    public double getPrix(){
        return this.prix;
    }

    public int getCompteur(){
        return this.nbrelivre;
    }

    @Override

    public String toString(){
        String info;
        info = new String();
        info = this.id+" - "+this.titre+" - "+this.auteur+" - "+this.prix;
        return info;
    }
}



