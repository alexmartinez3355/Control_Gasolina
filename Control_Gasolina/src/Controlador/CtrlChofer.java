package Controlador;

import Modelo.chofer;
import Modelo.consultasChofer;
import Vista.home;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author alexmartinez
 */
public class CtrlChofer implements ActionListener {

    private chofer choferM;
    private consultasChofer Cchofer;
    private home vistaChofer;

    public CtrlChofer(chofer choferM, consultasChofer Cchofer, home chofer) {
        this.choferM = choferM;
        this.Cchofer = Cchofer;
        this.vistaChofer = chofer;
        this.vistaChofer.btnGuardarChofer.addActionListener(this);
        this.vistaChofer.btnActualizarChofer.addActionListener(this);
        this.vistaChofer.btnEliminarChofer.addActionListener(this);
        this.vistaChofer.btnLimpiarChofer.addActionListener(this);
        this.vistaChofer.rscSangreChofer.addActionListener(this);
        this.vistaChofer.rscLicenciaChofer.addActionListener(this);
        this.vistaChofer.rscDeptoChofer.addActionListener(this);
        this.vistaChofer.rscMetodoPagoChofer.addActionListener(this);
        this.vistaChofer.btnChofer.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //-----------------PASAR A MODULO CHOFER----------------------->
        if (e.getSource() == vistaChofer.btnChofer) {
            vistaChofer.jpnInicio.setVisible(false);
            vistaChofer.jpnTicket.setVisible(false);
            vistaChofer.jpnEstadisticas.setVisible(false);
            vistaChofer.jpnCombustible.setVisible(false);
            vistaChofer.jpnChofer.setVisible(true);
            vistaChofer.jpnDepartamento.setVisible(false);
            vistaChofer.jpnProveedor.setVisible(false);
            vistaChofer.jpnVehiculo.setVisible(false);

            vistaChofer.jpnTituloInicio.setVisible(false);
            vistaChofer.jpnTituloTicket.setVisible(false);
            vistaChofer.jpnTituloEstadisticas.setVisible(false);
            vistaChofer.jpnTituloCombustible.setVisible(false);
            vistaChofer.jpnTituloChofer.setVisible(true);
            vistaChofer.jpnTituloDepto.setVisible(false);
            vistaChofer.jpnTituloProveedor.setVisible(false);
            vistaChofer.jpnTituloVehiculo.setVisible(false);

            vistaChofer.consultarChofer();
            vistaChofer.llena_comboDeptoChofer();
            vistaChofer.rstDatosChofer.getTableHeader().setReorderingAllowed(false);
        }
        //-----------------GUARDAR----------------------->
        if (e.getSource() == vistaChofer.btnGuardarChofer) {
            choferM.setNumero_empleado(vistaChofer.txtNumEmpleadoChofer.getText());
            choferM.setNombre(vistaChofer.txtNombreChofer.getText());
            choferM.setEdad(Integer.parseInt(vistaChofer.txtEdadChofer.getText()));
            choferM.setNss(vistaChofer.txtNSSChofer.getText());
            choferM.setTipo_sangre(vistaChofer.rscSangreChofer.getSelectedItem().toString());
            choferM.setTipo_licencia(vistaChofer.rscLicenciaChofer.getSelectedItem().toString());
            choferM.setDepartamento(Integer.parseInt(vistaChofer.txtIdDeptoChofer.getText()));
            choferM.setMetodo_pago(vistaChofer.rscMetodoPagoChofer.getSelectedItem().toString());

            if (Cchofer.guardar(choferM)) {
                JOptionPane.showMessageDialog(null, "Datos guardados");
                vistaChofer.consultarChofer();
                limpiarChofer();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
                vistaChofer.consultarChofer();
                limpiarChofer();
            }
        }
        //-----------------ACTUALIZAR----------------------->
        if (e.getSource() == vistaChofer.btnActualizarChofer) {
            choferM.setNumero_empleado(vistaChofer.txtNumEmpleadoChofer.getText());
            choferM.setNombre(vistaChofer.txtNombreChofer.getText());
            choferM.setEdad(Integer.parseInt(vistaChofer.txtEdadChofer.getText()));
            choferM.setNss(vistaChofer.txtNSSChofer.getText());
            choferM.setTipo_sangre(vistaChofer.rscSangreChofer.getSelectedItem().toString());
            choferM.setTipo_licencia(vistaChofer.rscLicenciaChofer.getSelectedItem().toString());
            choferM.setDepartamento(Integer.parseInt(vistaChofer.txtIdDeptoChofer.getText()));
            choferM.setMetodo_pago(vistaChofer.rscMetodoPagoChofer.getSelectedItem().toString());
            choferM.setId_Chofer(vistaChofer.txtIdChofer.getText());

            if (Cchofer.actualizar(choferM)) {
                JOptionPane.showMessageDialog(null, "Datos actualizados");
                vistaChofer.consultarChofer();
                limpiarChofer();
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar");
                vistaChofer.consultarChofer();
                limpiarChofer();
            }
        }
        //-----------------ELIMINAR----------------------->
        if (e.getSource() == vistaChofer.btnEliminarChofer) {
            choferM.setId_Chofer(vistaChofer.txtIdChofer.getText());
            if (Cchofer.eliminar(choferM)) {
                JOptionPane.showMessageDialog(null, "Datos eliminados");
                vistaChofer.consultarChofer();
                limpiarChofer();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                vistaChofer.consultarChofer();
                limpiarChofer();
            }
        }
        //-----------------LIMPIAR----------------------->
        if (e.getSource() == vistaChofer.btnLimpiarChofer) {
            limpiarChofer();
        }
        //-----------------CARGAR ID DEL DEPARTAMENTO DEL CHOFER--------------->
        if (e.getSource() == vistaChofer.rscDeptoChofer) {
            vistaChofer.consultarIdDeptoToChofer();
        }

        
    }

    public void limpiarChofer() {
        vistaChofer.txtNumEmpleadoChofer.setText("");
        vistaChofer.txtNombreChofer.setText("");
        vistaChofer.txtEdadChofer.setText("");
        vistaChofer.txtNSSChofer.setText("");
        vistaChofer.rscSangreChofer.setSelectedIndex(0);
        vistaChofer.rscLicenciaChofer.setSelectedIndex(0);
        vistaChofer.rscMetodoPagoChofer.setSelectedIndex(0);
        vistaChofer.rscDeptoChofer.setSelectedIndex(0);
        vistaChofer.txtIdDeptoChofer.setText("");
        vistaChofer.txtIdChofer.setText("");
    }
}
