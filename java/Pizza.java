public class Pizza{
    private String type;
    private String taille;
    private String garniture;

    public Pizza(){
        
    }

    public Pizza(String type, String garniture, String taille){
        this.type = type;
        this.garniture = garniture;
        this.taille = taille;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setGarniture(String garniture){
        this.garniture = garniture;
    }

    public void setTaille(String taille){
        this.taille = taille;
    }

    public String getType(){
        return this.type;
    }

    public String getGarniture(){
        return this.garniture;
    }

    public String getTaille(){
        return this.taille;
    }

    @Override

    public String toString(){
        String info;
        info = " - "+this.type+" - "+this.garniture+" - "+this.taille;
        return info;
    }
}



