
import java.util.ArrayList;


public class Inventaire{
    private String nom;
    private ArrayList TableauProduit;
    private static int nbreproduit=0;

    public Inventaire(String name){
        this.nom = name;
        this.TableauProduit = new ArrayList();
    }

    public void setNom(String name){
        this.nom = name;
    }

    public void ajouterProduit(Produit prod){
        this.TableauProduit.add(prod);
        TableauProduit.
        nbreproduit++;
    }

    public String getNom(){
        return this.nom;
    }

    public int getNbreProduit(){
        return this.nbreproduit;
    }

    public String getNomProduit(int code){
        for (int i = 0; i < nbreproduit; i++) {
            if(TableauProduit[i].getCode() == code) return TableauProduit[i].getNom();
        }
        return null;
    }  
    
    public void ListerProduit(){
        for (int i = 0; i < nbreproduit; i++) {
            System.out.println(TableauProduit[i].getNom());
        }
    } 

}



