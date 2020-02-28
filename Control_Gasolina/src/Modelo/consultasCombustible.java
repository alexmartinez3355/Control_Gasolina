package Modelo;

import Vista.home;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author alexmartinez
 */
public class consultasCombustible extends conexion{
    private home vistaCombus;
    public boolean guardar(combustible combus){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO combustible (tipo, precio, proveedor) VALUES (?,?,?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, combus.getTipo());
            ps.setDouble(2, combus.getPrecio());
            ps.setInt(3, combus.getProveedor());
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
    
    public boolean actualizar(combustible combus){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "UPDATE combustible SET tipo = ?, precio = ?, proveedor = ? WHERE id_combustible = ?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, combus.getTipo());
            ps.setDouble(2, combus.getPrecio());
            ps.setInt(3, combus.getProveedor());
            ps.setInt(4, combus.getId_combustible());
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
