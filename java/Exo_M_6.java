


public class Exo_M_6{
    public static void main(String[] args){

        int[][] recap;
        recap = new int[100][2];
        vacances(recap);
        Afficher(recap);
        Stat(recap);
    }

    public static void vacances(int[][] recap){

        for (int i = 0; i < 100; i++) {
            int j=0;
            recap[i][j]=(int) (Math.random()*55);
            recap[i][j+1]=(int) (Math.random()*30);
        }
    }

    public static void Afficher(int[][] recap){
        System.out.println("\tCode     | Durée du sejour (en jour)");
        for (int i = 0; i < 100; i++) {
            int j=0;
            System.out.println("\t\t"+recap[i][j]+" | "+recap[i][j+1]);
            
        }
    }

    public static void Stat(int[][] recap){
        int nbreEtrangerA = 0;
        int dureeMoyA = 0;
        int nbreEtranger= 0;
        int dureeMoy = 0;
        int nbreEtrangerE = 0;
        int dureeMoyE = 0;
        for (int i = 0; i < 100; i++) {
            if((recap[i][0] != 0) && (recap[i][0]!=1) && (recap[i][0]<50)){
                nbreEtrangerA++;
                nbreEtranger++;
                dureeMoyA+=recap[i][1];
                dureeMoy+=recap[i][1];
            }else if((recap[i][0] != 0) && (recap[i][0]!=1) && (50<=recap[i][0])){
                nbreEtrangerE++;
                nbreEtranger++;
                dureeMoyE+=recap[i][1];
                dureeMoy+=recap[i][1];
            }
        }

        dureeMoyE = dureeMoyE/nbreEtrangerE;
        dureeMoyA = dureeMoyA/nbreEtrangerA;
        dureeMoy = dureeMoy/nbreEtranger;
        System.out.println("Le nombre de marocain partie en vaccance à l'etranger sont de "+nbreEtranger+" et la durée moyenne de leur sejour est de "+dureeMoy);
        System.out.println(nbreEtrangerA+" sont en Afrique et la durée moyenne de leur sejour est de "+dureeMoyA);
        System.out.println(nbreEtrangerE+" sont en Europe et la durée moyenne de leur sejour est de "+dureeMoyE);
    }

}



