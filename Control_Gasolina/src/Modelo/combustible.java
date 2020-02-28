package Modelo;

/**
 *
 * @author alexmartinez
 */
public class combustible {
    private int id_combustible;
    private String tipo;
    private double precio;
    private int proveedor;

    public int getId_combustible() {
        return id_combustible;
    }

    public void setId_combustible(int id_combustible) {
        this.id_combustible = id_combustible;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getProveedor() {
        return proveedor;
    }

    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }
}
