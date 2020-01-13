
package tempox;
import java.sql.*;

public class perJDBClite{
   private static String nameBD="baseZ.db";

   public static void main( String args[] ) {
                        
   }


public static void conectarBD() {
      Connection c = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:"+nameBD);
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Opened database successfully-1");
   }
    

public static void crearTABLA() {
      Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:"+nameBD);
         System.out.println("Opened database successfully-2");

         stmt = c.createStatement();
         String sql = "CREATE TABLE PERSONA " +
                        "(p_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                        " p_nombre       TEXT    NOT NULL)"; 
         stmt.executeUpdate(sql);
         stmt.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Table created successfully");
   }

public static void insertarBD(String nombre) {
      Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:"+nameBD);
         c.setAutoCommit(false);
         System.out.println("Opened database successfully-3");

         stmt = c.createStatement();
         String sql = "INSERT INTO PERSONA (p_nombre) VALUES('"+nombre+"')"; 
         stmt.executeUpdate(sql);
         
         stmt.close();
         c.commit();
         c.close();

      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Records created successfully");
   }

  

public static void consultarBD() {

   Connection c = null;
   Statement stmt = null;
   try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:"+nameBD);
      c.setAutoCommit(false);
      System.out.println("Opened database successfully-4");

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM PERSONA;" );
      
      while ( rs.next() ) {
         int id = rs.getInt("p_id");
         String  nombre = rs.getString("p_nombre");         

         
         System.out.println( "ID = " + id );
         System.out.println( "NOMBRE = " + nombre );         
         System.out.println();
      }
      rs.close();
      stmt.close();
      c.close();
   } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
   }
   System.out.println("Operation done successfully");
  }

}




