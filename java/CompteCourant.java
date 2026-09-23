public class CompteCourant extends Compte{
    public CompteCourant(){
        
    }

    public CompteCourant(String RIB, String NumCompte, int cle){
        this.RIB = RIB;
        this.NumCompte = NumCompte;
        this.cleCompte =  cle;
        this.soldeCourant = 0.0;
    }

    public CompteCourant(String RIB, String NumCompte, int cle, double soldeC){
        this.RIB = RIB;
        this.NumCompte = NumCompte;
        this.cleCompte =  cle;
        this.soldeCourant =  soldeC;
    }

    @Override
    public void crediter(double montant){
        if(montant<0.0){
            System.out.println("Entrer un solde positif ");
        }else{
            this.soldeCourant+=montant;
        }
    }

    @Override
    public void debiter(double montant){
        if(montant<0.0){
            System.out.println("Entrer un montant positif ");
        }else{
            if(this.soldeCourant>=montant){
                this.soldeCourant-=montant;
            }else{
                this.soldeCourant-=montant;
                System.out.println("Vous devez à la banque\n\n");
            }
        }
    }

}



