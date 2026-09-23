public class Joueur{
    private int numero;
    private String nom;
    private String prenom;
    private String poste;

    public Joueur(){
        
    }

    public Joueur(String nom, String prenom, String poste, int numero){
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
        this.numero = numero;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public void setPrenom(String prenom){
        this.prenom = prenom;
    }

    public void setPoste(String poste){
        this.poste = poste;
    }

    public void setPoste(int numero){
        this.numero = numero;
    }

    public String getNom(){
        return this.nom;
    }

    public String getPrenom(){
        return this.prenom;
    }

    public String getPoste(){
        return this.poste;
    }

    public int getNumero(){
        return this.numero;
    }

    @Override

    public String toString(){
        String info;
        info = this.numero+" - "+this.nom+" - "+this.prenom+" - "+this.poste;
        return info;
    }
}



