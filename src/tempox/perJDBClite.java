
package tempox;
import java.sql.*;

public class perJDBClite{
   private static String nameBD="baseZ.db";

   public static void main( String args[] ) {
      
      conectarBD(nameBD);
      crearTABLA(nameBD);
      insertarBD(nameBD);
      consultarBD(nameBD);
   }


public static void conectarBD(String nameBD) {
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
    

public static void crearTABLA(String nameBD) {
      Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:"+nameBD);
         System.out.println("Opened database successfully-2");

         stmt = c.createStatement();
         String sql = "CREATE TABLE PERSONA " +
                        "(p_id INT PRIMARY KEY   NOT NULL," +
                        " p_nombre       TEXT    NOT NULL," + 
                        " p_apellido     TEXT    NOT NULL," + 
                        " p_edad         INT     NOT NULL," + 
                        " p_cedula       TEXT)"; 
         stmt.executeUpdate(sql);
         stmt.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Table created successfully");
   }

public static void insertarBD(String nameBD) {
      Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:"+nameBD);
         c.setAutoCommit(false);
         System.out.println("Opened database successfully-3");

         stmt = c.createStatement();
         String sql = "INSERT INTO PERSONA (p_id,p_nombre,p_apellido,p_edad,p_cedula) " +
                        "VALUES (1, 'Paul', 'California', 32, '0911147999' );"; 
         stmt.executeUpdate(sql);

         sql = "INSERT INTO PERSONA (p_id,p_nombre,p_apellido,p_edad,p_cedula) " +
                  "VALUES (2, 'Allen', 'Texas', 25, '0911147999' );"; 
         stmt.executeUpdate(sql);

         sql = "INSERT INTO PERSONA (p_id,p_nombre,p_apellido,p_edad,p_cedula) " +
                  "VALUES (3, 'Teddy', 'Norway', 23, '0911147999' );"; 
         stmt.executeUpdate(sql);

         sql = "INSERT INTO PERSONA (p_id,p_nombre,p_apellido,p_edad,p_cedula) " +
                  "VALUES (4, 'Paca', 'Garte', 23, '0911147999' );"; 
         stmt.executeUpdate(sql);
	 
         sql = "INSERT INTO PERSONA (p_id,p_nombre,p_apellido,p_edad,p_cedula) " +
                  "VALUES (5, 'Ana Lisa', 'Melchoto', 12, '0911147999' );"; 
         stmt.executeUpdate(sql);
	
	 sql = "INSERT INTO PERSONA (p_id,p_nombre,p_apellido,p_edad,p_cedula) " +
                  "VALUES (6, 'Rosa', 'Melpito', 43, '0911147999' );"; 
         stmt.executeUpdate(sql);

	 sql = "INSERT INTO PERSONA (p_id,p_nombre,p_apellido,p_edad,p_cedula) " +
                  "VALUES (7, 'Monica', 'Galindo', 63, '0911147999' );"; 
         stmt.executeUpdate(sql);

	 sql = "INSERT INTO PERSONA (p_id,p_nombre,p_apellido,p_edad,p_cedula) " +
                  "VALUES (8, 'Lali', 'Cuadora', 21, '0911147999' );"; 
         stmt.executeUpdate(sql);

	 sql = "INSERT INTO PERSONA (p_id,p_nombre,p_apellido,p_edad,p_cedula) " +
                  "VALUES (9, 'ana', 'Tomia', 18, '0911147999' );"; 
         stmt.executeUpdate(sql);

	 sql = "INSERT INTO PERSONA (p_id,p_nombre,p_apellido,p_edad,p_cedula) " +
                  "VALUES (10, 'Mary', 'Quita', 19, '0911147999' );"; 
         stmt.executeUpdate(sql);

	 sql = "INSERT INTO PERSONA (p_id,p_nombre,p_apellido,p_edad,p_cedula) " +
                  "VALUES (11, 'Flor D.', 'Turra', 26, '0911147999' );"; 
         stmt.executeUpdate(sql);

	 sql = "INSERT INTO PERSONA (p_id,p_nombre,p_apellido,p_edad,p_cedula) " +
                  "VALUES (12, 'German', 'Teca', 41, '0911147999' );"; 
         stmt.executeUpdate(sql);

	 sql = "INSERT INTO PERSONA (p_id,p_nombre,p_apellido,p_edad,p_cedula) " +
                  "VALUES (13, 'Evelin', 'Munda', 35, '0911147999' );"; 
         stmt.executeUpdate(sql);

	 sql = "INSERT INTO PERSONA (p_id,p_nombre,p_apellido,p_edad,p_cedula) " +
                  "VALUES (14, 'Roque', 'Joso', 27, '0911147999' );"; 
         stmt.executeUpdate(sql);
	 
	 sql = "INSERT INTO PERSONA (p_id,p_nombre,p_apellido,p_edad,p_cedula) " +
                  "VALUES (15, 'Darwin', 'Patino', 51, '0911147999' );"; 
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

  

public static void consultarBD(String nameBD) {

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
         String  apellido = rs.getString("p_apellido");
         int edad  = rs.getInt("p_edad");
         String cedula = rs.getString("p_cedula");

         
         System.out.println( "ID = " + id );
         System.out.println( "NOMBRE = " + nombre );
         System.out.println( "APELLIDO = " + apellido );
         System.out.println( "EDAD = " + edad );
         System.out.println( "CEDULA = " + cedula );
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




