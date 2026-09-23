import java.util.Scanner;



public class Exo_S_4_6{
    public static void main(String[] args){
        Scanner scan;
        scan = new Scanner(System.in);

        String paragraphe = "le bonjour GI le vendredi";

        compterMots(paragraphe);

        scan.close();
    }

    public static void compterMots(String p){ 
        int i;  
        int nbr=0;
        int t=0;
        String mot="";
        String[] tab;
        tab = new String[100];

        p.toLowerCase();

        for(i=0; i<p.length(); i++){
            if((p.charAt(i)) != ' '){               
                mot += p.charAt(i);
            }else{
                tab[t] = mot;
                mot="";
                t++;
            }

        }
        int j;
        String[][] dic;
        dic = new String[t][2];
        int x=0,y=0;
        for(i=0; i<t; i++){
            int occ=0;
            j=i;
            while (j<t) { 
                if(tab[i].equals(tab[j])){
                    occ++;
                }
                j++;
            }
            dic[x][y] = tab[i];
            dic[x][y+1]  = (occ+" ");
            x++;
        }
        for(i=0; i<t; i++){
            for(j=0; j<2; j++){
                System.out.print(" "+dic[i][j]+" ");
            }
            System.out.println("|");
        }
    }

}



