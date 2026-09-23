public abstract class Compte{
    protected String RIB;
    protected String NumCompte;
    protected double soldeCourant;
    protected double soldeEpargne;
    protected int cleCompte;

    public Compte(){
        
    }

    public Compte(String RIB, String NumCompte, int cle){
        this.RIB = RIB;
        this.NumCompte = NumCompte;
        this.cleCompte =  cle;
        this.soldeCourant = 0.0;
        this.soldeEpargne = 0.0;
    }



    public void setRIB(String RIB){
        this.RIB = RIB;
    }

    public void setNumCompte(String NumCompte){
        this.NumCompte = NumCompte;
    }

    public void setCle(int Cle){
        this.cleCompte = Cle;
    }

    public String getRIB(){
        return this.RIB;
    }

    public String getNumCompte(){
        return this.NumCompte;
    }

    public int getCle(){
        return this.cleCompte;
    }

    public double getSoldeCourant(){
        return this.soldeCourant;
    }

    public double getSoldeEpargne(){
        return this.soldeEpargne;
    }

    public void setSoldeCourant(double montant){
        this.soldeCourant = montant;
    }

    public void setSoldeEpargne(double montant){
        this.soldeEpargne = montant;
    }

    public abstract void crediter(double montant);

    public abstract void debiter(double montant);
    
    public abstract void calculer_nouveausolde(double taux);
    @Override

    public String toString(){
        String info;
        info = "Compte N° "+this.NumCompte+" -RIB "+this.RIB+" -Cle "+this.cleCompte;
        return info;
    }
}



