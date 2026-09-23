import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mysql

public class Connexion {
   public static void main(String[] args){
      try {
         Connection Con = DriverManager.getConnection("jdbc:mysql://localhost/apptest", "root", "");
      } catch (SQLException var2) {
         Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, (String)null, var2);
      }
   }


}