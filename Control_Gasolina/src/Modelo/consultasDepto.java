package Modelo;


import com.mysql.jdbc.Connection;
import java.sql.*;
/**
 *
 * @author alexmartinez
 */
public class consultasDepto extends conexion {
    
    public boolean guardar(departamento depto){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO departamento (nombre_departamento, nombre_encargado) VALUES (?,?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, depto.getNombre_departamento());
            ps.setString(2, depto.getNombre_encargado());
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
    
    public boolean actualizar(departamento depto){
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE departamento SET nombre_departamento = ?, nombre_encargado = ? WHERE id_departamento = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, depto.getNombre_departamento());
            ps.setString(2, depto.getNombre_encargado());
            ps.setString(3, depto.getId_depto());
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
    
    public boolean eliminar(departamento depto){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "DELETE FROM departamento WHERE id_departamento=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, depto.getId_depto());
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
