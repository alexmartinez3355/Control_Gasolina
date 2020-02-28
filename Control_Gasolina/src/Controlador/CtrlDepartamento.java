package Controlador;

import Modelo.consultasDepto;
import Modelo.departamento;
import Vista.home;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author alexmartinez
 */
public class CtrlDepartamento implements ActionListener {

    private departamento deptoM;
    private consultasDepto Cdepto;
    private home vistaDepto;

    public CtrlDepartamento(departamento depto, consultasDepto Cdepto, home departamento) {
        this.Cdepto = Cdepto;
        this.deptoM = depto;
        this.vistaDepto = departamento;
        this.vistaDepto.btnGuardarDepto.addActionListener(this);
        this.vistaDepto.btnActualizarDepto.addActionListener(this);
        this.vistaDepto.btnEliminarDepto.addActionListener(this);
        this.vistaDepto.btnLimpiar.addActionListener(this);
        this.vistaDepto.btnDepartamento.addActionListener(this);
    }

    public void iniciar() {
        vistaDepto.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //-------------------PASAR AL MODULO DEPARTAMENTO---------------------->
        if (e.getSource() == vistaDepto.btnDepartamento) {
            vistaDepto.jpnInicio.setVisible(false);
            vistaDepto.jpnTicket.setVisible(false);
            vistaDepto.jpnEstadisticas.setVisible(false);
            vistaDepto.jpnCombustible.setVisible(false);
            vistaDepto.jpnChofer.setVisible(false);
            vistaDepto.jpnDepartamento.setVisible(true);
            vistaDepto.jpnProveedor.setVisible(false);
            vistaDepto.jpnVehiculo.setVisible(false);

            vistaDepto.jpnTituloInicio.setVisible(false);
            vistaDepto.jpnTituloTicket.setVisible(false);
            vistaDepto.jpnTituloEstadisticas.setVisible(false);
            vistaDepto.jpnTituloCombustible.setVisible(false);
            vistaDepto.jpnTituloChofer.setVisible(false);
            vistaDepto.jpnTituloDepto.setVisible(true);
            vistaDepto.jpnTituloProveedor.setVisible(false);
            vistaDepto.jpnTituloVehiculo.setVisible(false);

            vistaDepto.consultarDepartamentos();
        }
        //-------------------GUARDAR---------------------->
        if (e.getSource() == vistaDepto.btnGuardarDepto) {

            deptoM.setNombre_encargado(vistaDepto.txtEncargadoDepto.getText());
            deptoM.setNombre_departamento(vistaDepto.txtNombredepto.getText());

            if (Cdepto.guardar(deptoM)) {
                JOptionPane.showMessageDialog(null, "Datos guardados");
                vistaDepto.consultarDepartamentos();
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }
        }
        //-------------------ACTUALIZAR---------------------->
        if (e.getSource() == vistaDepto.btnActualizarDepto) {

            deptoM.setNombre_encargado(vistaDepto.txtEncargadoDepto.getText());
            deptoM.setNombre_departamento(vistaDepto.txtNombredepto.getText());
            deptoM.setId_depto(vistaDepto.txtIdDepto.getText());

            if (Cdepto.actualizar(deptoM)) {
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
                vistaDepto.consultarDepartamentos();
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar");

            }
        }
        //-------------------ELIMINAR---------------------->
        if (e.getSource() == vistaDepto.btnEliminarDepto) {

            deptoM.setId_depto(vistaDepto.txtIdDepto.getText());

            if (Cdepto.eliminar(deptoM)) {
                JOptionPane.showMessageDialog(null, "Datos eliminados");
                vistaDepto.consultarDepartamentos();
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
            }
        }
        //-------------------LIMPIAR---------------------->
        if (e.getSource() == vistaDepto.btnLimpiar) {
            limpiar();
        }
    }

    public void limpiar() {
        vistaDepto.txtEncargadoDepto.setText("");
        vistaDepto.txtNombredepto.setText("");
        vistaDepto.txtIdDepto.setText("");
    }
}
