package Modelo;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author alexmartinez
 */
public class consultasChofer extends conexion {
    
    public boolean guardar(chofer chofer){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO chofer (numero_empleado, nombre, edad, nss, tipo_sangre, tipo_licencia, departamento, m_pago) VALUES (?,?,?,?,?,?,?,?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, chofer.getNumero_empleado());
            ps.setString(2, chofer.getNombre());
            ps.setInt(3, chofer.getEdad());
            ps.setString(4, chofer.getNss());
            ps.setString(5, chofer.getTipo_sangre());
            ps.setString(6, chofer.getTipo_licencia());
            ps.setInt(7, chofer.getDepartamento());
            ps.setString(8, chofer.getMetodo_pago());
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
    
    public boolean actualizar(chofer chofer){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "UPDATE chofer SET nombre = ?, numero_empleado = ?, nss = ?, tipo_sangre = ?, edad = ?, tipo_licencia = ?, m_pago = ?, departamento = ? WHERE id_chofer = ?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, chofer.getNombre());
            ps.setString(2, chofer.getNumero_empleado());
            ps.setString(3, chofer.getNss());
            ps.setString(4, chofer.getTipo_sangre());
            ps.setInt(5, chofer.getEdad());
            ps.setString(6, chofer.getTipo_licencia());
            ps.setString(7, chofer.getMetodo_pago());
            ps.setInt(8, chofer.getDepartamento());
            ps.setString(9, chofer.getId_Chofer());
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
    
    public boolean eliminar(chofer chofer){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "DELETE FROM chofer WHERE id_chofer=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, chofer.getId_Chofer());
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
