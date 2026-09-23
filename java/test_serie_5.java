
public class test_serie_5{
    public static void main(String[] args){
        Produit p1,p2;
        Inventaire i1;

        i1 = new Inventaire("Magasin Magique");
        p1 = new Produit("Clavier", 10);
        p2 = new Produit("Imprimante", 12);

        System.out.println("Le nom de l'inventaire au depart est "+i1.getNom());

        i1.ajouterProduit(p1);
        i1.ajouterProduit(p2);

        i1.setNom("Magique Informatique");

        System.out.println("Son nouveau nom est "+i1.getNom());

        String nomR = i1.getNomProduit(10);

        System.out.println("Le produit donc le code est 10 se nomme "+nomR);

        System.out.println("Le nombre de produit dans l'inventaire est "+i1.getNbreProduit());

        System.out.println("Liste des produits");

        i1.ListerProduit();
    
    }

}



