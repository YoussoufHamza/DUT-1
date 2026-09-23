public class Match{
    private Equipe[] equipe;

    public Match(){
        
    }

    public void JouerMatch(){
        String[] NomJouer = {"Cristiano", "Vinicius", "Bellingham", "Valverde", "Mbappe", "Goula", "Tchouameni", "Rodrygo", "Courtois", "Rudiger", "Benzema"};
        String[] PrenomJouer = {"Ronaldo", "Junior", "Jude", "Valverde", "Kylian", "Arda", "Aurelien", "Rodrygo ", "Tibaut", "Rudiger", "Alaba"};
        String[] Poste = {"Attaquant", "Defenseur", "Gardien", "Lateral gauche", "Lateral droit", "Avant centre"};
        int[] numero={1, 2, 9, 10, 11, 24, 8, 14, 26, 5, 6,3};
        String[] Action = {"Marquer", "perdre", "drible", "Coup franc", "penalty", "Possesion de ballon"};

        this.equipe= new Equipe[2];

        this.equipe[0] = new Equipe("Team un");
        this.equipe[1] = new Equipe("Team deux");

        int i;
        for (i = 0; i <= 10; i++) {
            this.equipe[0].ajouterJouer(new Joueur(NomJouer[(int)(Math.random()*10)], PrenomJouer[(int)(Math.random()*10)], Poste[(int)(Math.random()*5)], numero[(int)(Math.random()*11)])); 
            this.equipe[1].ajouterJouer(new Joueur(NomJouer[(int)(Math.random()*10)], PrenomJouer[(int)(Math.random()*10)], Poste[(int)(Math.random()*5)], numero[(int)(Math.random()*11)])); 
        }

        System.out.println("Equipe 1 "+this.equipe[0].getNom());
        this.equipe[0].afficherEquipe();

        System.out.println("Equipe 2 "+this.equipe[1].getNom());
        this.equipe[1].afficherEquipe();

        System.out.println("Le Match vient de debuter \n\n");
        int point=0, point1=0;
        for (i = 0; i < 30; i++) {
            
            System.out.println(Action[(int)(Math.random()*5)]+" pour l'equipe "+equipe[(int)(Math.random()*2)].getNom()+" \n");
            if ((Action[(int)(Math.random()*5)] == "Marquer") && (equipe[(int)(Math.random()*2)] == equipe[0])) {
                point++;
            }else if ((Action[(int)(Math.random()*5)] == "Marquer") && (equipe[(int)(Math.random()*2)] == equipe[1])){ 
                point1++;
            }
        }
        if(point1 < point){
            System.out.println("Resultat du match \n\t"+point+" - "+point1+"\n En faveur de "+equipe[0].getNom());
        }else{
            System.out.println("Resultat du match \n\t"+point+" - "+point1+"\n En faveur de "+equipe[1].getNom());
        }
        

        System.out.println("\n\n");
    }
}



