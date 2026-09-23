import java.util.Scanner;


public class exo2{
    public static void main(String[] args){
        Scanner scan;
        scan = new Scanner(System.in);

        int note;
        System.out.println("Entrer une note comprise entre 0 et 500");
        note = scan.nextInt();

        while ((note<0) || (note>500)) {
            System.out.println("Entrer une note comprise entre 0 et 500");
            note = scan.nextInt();
        }

        if ((note/5)>=97){
            System.out.println("Le grade est A+");
        }else if ( ((note/5)>=93) && ((note/5)<=96) ){
            System.out.println("Le grade est A");
        }else if ( ((note/5)>=90) && ((note/5)<=92) ){
            System.out.println("Le grade est A-");
        }else if ( ((note/5)>=87) && ((note/5)<=89) ){
            System.out.println("Le grade est B+");
        }else if ( ((note/5)>=83) && ((note/5)<=86) ){
            System.out.println("Le grade est B");
        }else if ( ((note/5)>=80) && ((note/5)<=82) ){
            System.out.println("Le grade est B-");
        }else if ( ((note/5)>=77) && ((note/5)<=79) ){
            System.out.println("Le grade est C+");
        }else if ( ((note/5)>=73) && ((note/5)<=76) ){
            System.out.println("Le grade est C");
        }else if ( ((note/5)>=70) && ((note/5)<=72) ){
            System.out.println("Le grade est C-");
        }else if ( ((note/5)>=67) && ((note/5)<=69) ){
            System.out.println("Le grade est D+");
        }else if ( ((note/5)>=63) && ((note/5)<=66) ){
            System.out.println("Le grade est D");
        }else if ( ((note/5)<63)){
            System.out.println("Le grade est F");
        }
    }
}