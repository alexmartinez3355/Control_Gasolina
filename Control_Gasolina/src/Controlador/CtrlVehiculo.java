package Controlador;

import Modelo.consultasVehiculo;
import Modelo.vehiculo;
import Vista.home;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author alexmartinez
 */
public class CtrlVehiculo implements ActionListener {
    private vehiculo vehiculoM;
    private consultasVehiculo vehiculoC;
    private home vistaVehiculo;

    public CtrlVehiculo(vehiculo cocheM, consultasVehiculo cocheC, home vehiculo) {
        this.vehiculoM = cocheM;
        this.vehiculoC = cocheC;
        this.vistaVehiculo = vehiculo;
        this.vistaVehiculo.btnVehiculo.addActionListener(this);
        this.vistaVehiculo.btnGuardarVehiculo.addActionListener(this);
        this.vistaVehiculo.btnActualizarVehiculo.addActionListener(this);
        this.vistaVehiculo.btnEliminarVehiculo.addActionListener(this);
        this.vistaVehiculo.btnLimpiarVehiculo.addActionListener(this);
        this.vistaVehiculo.rscDeptoVehiculo.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //------------PASAR AL MODULO DE VEHICULO------------------------------>
        if (e.getSource() == vistaVehiculo.btnVehiculo) {
            vistaVehiculo.jpnInicio.setVisible(false);
            vistaVehiculo.jpnTicket.setVisible(false);
            vistaVehiculo.jpnEstadisticas.setVisible(false);
            vistaVehiculo.jpnCombustible.setVisible(false);
            vistaVehiculo.jpnChofer.setVisible(false);
            vistaVehiculo.jpnDepartamento.setVisible(false);
            vistaVehiculo.jpnProveedor.setVisible(false);
            vistaVehiculo.jpnVehiculo.setVisible(true);

            vistaVehiculo.jpnTituloInicio.setVisible(false);
            vistaVehiculo.jpnTituloTicket.setVisible(false);
            vistaVehiculo.jpnTituloEstadisticas.setVisible(false);
            vistaVehiculo.jpnTituloCombustible.setVisible(false);
            vistaVehiculo.jpnTituloChofer.setVisible(false);
            vistaVehiculo.jpnTituloDepto.setVisible(false);
            vistaVehiculo.jpnTituloProveedor.setVisible(false);
            vistaVehiculo.jpnTituloVehiculo.setVisible(true);
            
            vistaVehiculo.llena_comboDeptoVehiculo();
            vistaVehiculo.consultarVehiculo();
        }
        
        if(e.getSource() == vistaVehiculo.btnGuardarVehiculo){
            vehiculoM.setMarca(vistaVehiculo.txtMarcaVehiculo.getText());
            vehiculoM.setModelo(vistaVehiculo.txtModeloVehiculo.getText());
            vehiculoM.setColor(vistaVehiculo.txtColorVehiculo.getText());
            vehiculoM.setAnio(vistaVehiculo.txtAnioVehiculo.getText());
            vehiculoM.setPlaca(vistaVehiculo.txtPlacavehiculo.getText());
            vehiculoM.setTipo(vistaVehiculo.rscTipoVehiculo.getSelectedItem().toString());
            vehiculoM.setDepartamento(Integer.parseInt(vistaVehiculo.txtIdDeptoVehiculo.getText()));
            
            if(vehiculoC.guardar(vehiculoM)){
                JOptionPane.showMessageDialog(null, "Datos guardados");
                limpiarVehiculo();
                vistaVehiculo.consultarVehiculo();
            }else{
                JOptionPane.showMessageDialog(null, "Error al guardar");
                limpiarVehiculo();
                vistaVehiculo.consultarVehiculo();
            }
        }
        
        if(e.getSource() == vistaVehiculo.btnActualizarVehiculo){
            vehiculoM.setMarca(vistaVehiculo.txtMarcaVehiculo.getText());
            vehiculoM.setModelo(vistaVehiculo.txtModeloVehiculo.getText());
            vehiculoM.setColor(vistaVehiculo.txtColorVehiculo.getText());
            vehiculoM.setAnio(vistaVehiculo.txtAnioVehiculo.getText());
            vehiculoM.setPlaca(vistaVehiculo.txtPlacavehiculo.getText());
            vehiculoM.setTipo(vistaVehiculo.rscTipoVehiculo.getSelectedItem().toString());
            vehiculoM.setDepartamento(Integer.parseInt(vistaVehiculo.txtIdDeptoVehiculo.getText()));
            vehiculoM.setId_vehiculo(Integer.parseInt(vistaVehiculo.txtIdVehiculo.getText()));
        }
        
        if(e.getSource() == vistaVehiculo.btnLimpiarVehiculo){
            limpiarVehiculo();
        }
        
        if(e.getSource() == vistaVehiculo.rscDeptoVehiculo){
            vistaVehiculo.consultarIdDeptoVehiculo();
        }
        
    }
    
    public void limpiarVehiculo(){
        vistaVehiculo.txtMarcaVehiculo.setText("");
        vistaVehiculo.txtModeloVehiculo.setText("");
        vistaVehiculo.txtColorVehiculo.setText("");
        vistaVehiculo.txtAnioVehiculo.setText("");
        vistaVehiculo.txtPlacavehiculo.setText("");
        vistaVehiculo.rscTipoVehiculo.setSelectedIndex(0);
        vistaVehiculo.rscDeptoVehiculo.setSelectedIndex(0);
        vistaVehiculo.txtIdVehiculo.setText("");
        vistaVehiculo.txtIdDeptoVehiculo.setText("");
    }
}
