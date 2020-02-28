package Modelo;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author alexmartinez
 */
public class consultasVehiculo extends conexion {

    public boolean guardar(vehiculo coche) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO vehiculo (marca, modelo, color, anio, placa, tipo, departamento) VALUES (?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, coche.getMarca());
            ps.setString(2, coche.getModelo());
            ps.setString(3, coche.getColor());
            ps.setString(4, coche.getAnio());
            ps.setString(5, coche.getPlaca());
            ps.setString(6, coche.getTipo());
            ps.setInt(7, coche.getDepartamento());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean actualizar(vehiculo coche){
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE vehiculo SET marca = ?, modelo = ?, color = ?, anio = ?, placa = ?, tipo = ?, departamento = ? WHERE id_vehiculo = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, coche.getMarca());
            ps.setString(2, coche.getModelo());
            ps.setString(3, coche.getColor());
            ps.setString(4, coche.getAnio());
            ps.setString(5, coche.getPlaca());
            ps.setString(6, coche.getTipo());
            ps.setInt(7, coche.getDepartamento());
            ps.setInt(8, coche.getId_vehiculo());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
