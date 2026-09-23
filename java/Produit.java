
public class Produit{
    private String nom;
    private int code;
    private static int compteur=0;

    public Produit(String name, int code){
        this.nom = name;
        this.code = code;
        compteur++;
    }

    public void setNom(String name){
        this.nom = name;
    }

    public void setCode(int code){
        this.code = code;
    }

    public String getNom(){
        return this.nom;
    }

    public int getCode(){
        return this.code;
    }

    public int getCompteur(){
        return this.compteur;
    }

    public void finalyse(){
        System.out.println("Le produit "+this.nom+" dont le code est "+this.code+" a ete supprime avec succes");
        compteur--;
    }

}



