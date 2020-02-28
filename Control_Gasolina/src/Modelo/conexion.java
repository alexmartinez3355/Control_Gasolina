package Modelo;


import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author alexmartinez
 */
public class conexion {
    private final String base = "control_gazolina";
    private final String user = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://localhost:3306/"+base;
    private Connection con = null;
   
    public Connection getConexion(){
       try{
           Class.forName("com.mysql.jdbc.Driver");
           con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
           
       } catch(SQLException e){
           System.err.println(e);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
       }
       
      return con;
    }
   
    Statement createStatement(){
        throw new UnsupportedOperationException("No Soportado");  
    }
    
}
