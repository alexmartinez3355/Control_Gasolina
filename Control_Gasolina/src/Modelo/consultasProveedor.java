package Modelo;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author alexmartinez
 */
public class consultasProveedor extends conexion{
    
    public boolean guardar(proveedor prove){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO proveedor (razon_social, direccion, rfc, telefono) VALUES (?,?,?,?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, prove.getRazon_Social());
            ps.setString(2, prove.getDireccion());
            ps.setString(3, prove.getRfc());
            ps.setString(4, prove.getTelefono());
            ps.execute();           
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        } finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }   
    }
    
    public boolean actualizar(proveedor prove){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "UPDATE proveedor SET razon_social = ?, direccion = ?, rfc = ?, telefono = ? WHERE id_proveedor = ?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, prove.getRazon_Social());
            ps.setString(2, prove.getDireccion());
            ps.setString(3, prove.getRfc());
            ps.setString(4, prove.getTelefono());
            ps.setString(5, prove.getId_Proveedor());
            
            ps.execute();           
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        } finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    
    public boolean eliminar(proveedor prove){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "DELETE FROM proveedor WHERE id_proveedor=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, prove.getId_Proveedor());
            ps.execute();           
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        } finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
}
