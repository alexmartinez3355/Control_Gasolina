package Controlador;

import Modelo.consultasProveedor;
import Modelo.proveedor;
import Vista.home;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author alexmartinez
 */
public class CtrlProveedor implements ActionListener {

    private proveedor proveM;
    private consultasProveedor Cprove;
    private home vistaProve;

    public CtrlProveedor(proveedor Mprove, consultasProveedor proveC, home proveedor) {
        this.Cprove = proveC;
        this.proveM = Mprove;
        this.vistaProve = proveedor;
        this.vistaProve.btnGuardarProveedor.addActionListener(this);
        this.vistaProve.btnActualizarProveedor.addActionListener(this);
        this.vistaProve.btnBorrarProveedor.addActionListener(this);
        this.vistaProve.btnLimpiarProveedor.addActionListener(this);
        this.vistaProve.btnProveedor.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //----------------------PASAR AL MODULO PROVEEDOR---------------------->
        if (e.getSource() == vistaProve.btnProveedor) {
            vistaProve.jpnInicio.setVisible(false);
            vistaProve.jpnTicket.setVisible(false);
            vistaProve.jpnEstadisticas.setVisible(false);
            vistaProve.jpnCombustible.setVisible(false);
            vistaProve.jpnChofer.setVisible(false);
            vistaProve.jpnDepartamento.setVisible(false);
            vistaProve.jpnProveedor.setVisible(true);
            vistaProve.jpnVehiculo.setVisible(false);

            vistaProve.jpnTituloInicio.setVisible(false);
            vistaProve.jpnTituloTicket.setVisible(false);
            vistaProve.jpnTituloEstadisticas.setVisible(false);
            vistaProve.jpnTituloCombustible.setVisible(false);
            vistaProve.jpnTituloChofer.setVisible(false);
            vistaProve.jpnTituloDepto.setVisible(false);
            vistaProve.jpnTituloProveedor.setVisible(true);
            vistaProve.jpnTituloVehiculo.setVisible(false);
            
            vistaProve.llena_comboProveedorCombustible();
            vistaProve.consultarProveedor();
        }
        //----------------------GUARDAR------------------------>
        if (e.getSource() == vistaProve.btnGuardarProveedor) {
            proveM.setRazon_Social(vistaProve.txtNombreProveedor.getText());
            proveM.setDireccion(vistaProve.txtDireccionProveedor.getText());
            proveM.setRfc(vistaProve.txtRFCProveedor.getText());
            proveM.setTelefono(vistaProve.txtTelefonoProveedor.getText());

            if (Cprove.guardar(proveM)) {
                JOptionPane.showMessageDialog(null, "Datos guardados");
                vistaProve.consultarProveedor();
                limpiarProveedor();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
                vistaProve.consultarProveedor();
                limpiarProveedor();
            }
        }
        //----------------------ACTUALIZAR------------------------>
        if (e.getSource() == vistaProve.btnActualizarProveedor) {
            proveM.setRazon_Social(vistaProve.txtNombreProveedor.getText());
            proveM.setDireccion(vistaProve.txtDireccionProveedor.getText());
            proveM.setRfc(vistaProve.txtRFCProveedor.getText());
            proveM.setTelefono(vistaProve.txtTelefonoProveedor.getText());
            proveM.setId_Proveedor(vistaProve.txtIdProveedor.getText());

            if (Cprove.actualizar(proveM)) {
                JOptionPane.showMessageDialog(null, "Datos actualizados");
                vistaProve.consultarProveedor();
                limpiarProveedor();
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar");
                vistaProve.consultarProveedor();
                limpiarProveedor();
            }
        }
        //----------------------BORRAR------------------------>
        if (e.getSource() == vistaProve.btnBorrarProveedor) {
            proveM.setId_Proveedor(vistaProve.txtIdProveedor.getText());
            if (Cprove.eliminar(proveM)) {
                JOptionPane.showMessageDialog(null, "Datos eliminados");
                vistaProve.consultarProveedor();
                limpiarProveedor();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                vistaProve.consultarProveedor();
                limpiarProveedor();
            }
        }
        //----------------------LIMPIAR------------------------>
        if (e.getSource() == vistaProve.btnLimpiarProveedor) {
            limpiarProveedor();
        }
    }

    public void limpiarProveedor() {
        vistaProve.txtNombreProveedor.setText("");
        vistaProve.txtDireccionProveedor.setText("");
        vistaProve.txtRFCProveedor.setText("");
        vistaProve.txtTelefonoProveedor.setText("");
        vistaProve.txtIdProveedor.setText("");
    }
}
