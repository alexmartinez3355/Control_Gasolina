package Modelo;

/**
 *
 * @author alexmartinez
 */
public class proveedor {
    private String id_Proveedor;
    private String razon_Social;
    private String direccion;
    private String rfc;
    private String telefono;

    public String getId_Proveedor() {
        return id_Proveedor;
    }

    public void setId_Proveedor(String id_Proveedor) {
        this.id_Proveedor = id_Proveedor;
    }

    public String getRazon_Social() {
        return razon_Social;
    }

    public void setRazon_Social(String razon_Social) {
        this.razon_Social = razon_Social;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
