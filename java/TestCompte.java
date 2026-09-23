public class TestCompte{
    public void main(String[] args){
       Compte compte, compte1;
       double taux = 0.05;
       compte = new CompteCourant("1YTTRRRGHK3", "451ZEA1122OOI233", 21);
       compte1= new CompteEpargne("1OIIUUUIOOJ3","78866TIOOJOOI233", 20);

       System.out.println(compte.toString());
       compte.setSoldeCourant(21000.677);
       System.out.println(compte1.toString());
       compte1.setSoldeEpargne(30987.987);


       System.out.println("Compte 1 : Solde courant "+compte.getSoldeCourant()+" DH");
       System.out.println("Compte 2 : Solde epargne "+compte1.getSoldeEpargne()+" DH");

       System.out.println("On credite le premier compte de 200DH ");
       compte.crediter(200);
       System.out.println("Compte 1 : Solde courant "+compte.getSoldeCourant()+" DH \n");
       System.out.println("On credite le second compte de 500DH ");
       compte1.crediter(500);
       System.out.println("Compte 2 : Solde epargne "+compte1.getSoldeEpargne()+" DH \n");

       System.out.println("On debite le premier compte de 2003DH ");
       compte.debiter(200300);
       System.out.println("Compte 1 : Solde courant "+compte.getSoldeCourant()+" DH \n");
       System.out.println("On debite le second compte de 1500DH ");
       compte1.debiter(1500);
       System.out.println("Compte 2 : Solde epargne "+compte1.getSoldeEpargne()+" DH \n");

       System.out.println("\n\nApres l'exercice budgetaire on calcul le solde du compte epargne à un taux de 2% ");
       compte1.calculer_nouveausolde(taux);
       System.out.println("Compte 2 : Solde epargne "+compte1.getSoldeEpargne()+" DH \n");


    }    
}