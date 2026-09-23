public class Client{
    private String nom;
    private String adresse;

    public Client(){
        
    }

    public Client(String nom, String adresse){
        this.nom = nom;
        this.adresse = adresse;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public void setAdresse(String adresse){
        this.adresse = adresse;
    }

    public String getNom(){
        return this.nom;
    }

    public String getAdresse(){
        return this.adresse;
    }

    public Pizza commanderPizza(Pizza pizza){
        return pizza;
    }

    @Override

    public String toString(){
        String info;
        info = " - "+this.nom+" - "+this.adresse;
        return info;
    }
}



