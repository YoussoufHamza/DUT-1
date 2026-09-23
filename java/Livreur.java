public class Livreur{
    private String nom;
    private String numTele;

    public Livreur(){
        
    }

    public Livreur(String nom, String numTele){
        this.nom = nom;
        this.numTele = numTele;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public void setNumTele(String numTele){
        this.numTele = numTele;
    }

    public String getNom(){
        return this.nom;
    }

    public String getNumTele(){
        return this.numTele;
    }

    public void livrerPizza(Pizza pizzaL, Pizza pizzaC, Client client){
        if(client.commanderPizza(pizzaC) == pizzaL){
            System.out.println(client.toString()+" votre pizza "+ pizzaL.toString()+" a ete livre avec succès");
        }else{
            System.out.println("erreur dans la livraison de la pizza de mr "+client.toString());
        }
    }


    @Override

    public String toString(){
        String info;
        info = " - "+this.nom+" - "+this.numTele;
        return info;
    }
}



