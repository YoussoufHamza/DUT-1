public class CompteEpargne extends Compte{
    public CompteEpargne(){
        
    }

    public CompteEpargne(String RIB, String NumCompte, int cle){
        this.RIB = RIB;
        this.NumCompte = NumCompte;
        this.cleCompte =  cle;
        this.soldeEpargne = 0.0;
    }

    public CompteEpargne(String RIB, String NumCompte, int cle, double soldeE){
        this.RIB = RIB;
        this.NumCompte = NumCompte;
        this.cleCompte =  cle;
        this.soldeEpargne =  soldeE;
    }

    @Override
    public void calculer_nouveausolde(double taux){
        this.soldeEpargne += (this.soldeEpargne*taux);
    }

    @Override
    public void crediter(double montant){
        if(montant<0.0){
            System.out.println("Entrer un montant positif ");
        }else{
            this.soldeEpargne+=montant;
        }
    }

    @Override
    public void debiter(double montant){
        if(montant<0.0){
            System.out.println("Entrer un montant positif ");
        }else{
            if(this.soldeEpargne>=montant){
                this.soldeEpargne-=montant;
            }else{
                System.out.println("Solde insuffisant\n\n");
            }
        }
    }

}



