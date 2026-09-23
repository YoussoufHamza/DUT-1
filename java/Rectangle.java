
public class Rectangle{
    private float longueur;
    private float largeur;
    private static int compteur=0;

    public Rectangle(){
        this.largeur = 1;
        this.longueur = 1;
        compteur++;
    }

    public void setLongueur(float longueur){
        if((longueur <= 20 ) && (longueur >= 0)) {
            this.longueur = longueur;
        }else{
            System.out.println("Entrer une valeur comprise entre 0 et 20");
        }
    }

    public void setLargeur(float largeur){
        if((largeur <= 20 ) && (largeur >= 0)) {
            this.largeur = largeur;
        }else{
            System.out.println("Entrer une valeur comprise entre 0 et 20");
        }
    }

    public float Surface(){
        return (this.longueur*this.largeur);
    }

    public float Perimetre(){
        return ((this.longueur+this.largeur)*2);
    }

    public float getLongueur(){
        return this.longueur;
    }

    public float getLargeur(){
        return this.largeur;
    }

    public int getCompteur(){
        return this.compteur;
    }

    public void finalyse(){
        compteur--;
    }

}



