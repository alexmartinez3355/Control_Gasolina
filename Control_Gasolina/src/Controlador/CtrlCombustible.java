package Controlador;

import Modelo.combustible;
import Modelo.consultasCombustible;
import Vista.home;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author alexmartinez
 */
public class CtrlCombustible implements ActionListener{
    private combustible combusM;
    private consultasCombustible combusC;
    private home vistaCombustible;
    
    public CtrlCombustible(combustible combus, consultasCombustible Ccombus, home combustible){
        this.combusM = combus;
        this.combusC = Ccombus;
        this.vistaCombustible = combustible;
        this.vistaCombustible.btnCombustible.addActionListener(this);
        this.vistaCombustible.btnGuardarCombustible.addActionListener(this);
        this.vistaCombustible.btnActualizarCombustible.addActionListener(this);
        this.vistaCombustible.btnLimpiarCombustible.addActionListener(this);
        this.vistaCombustible.rscProveedorCombustible.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        //------------------PASAR AL MODULO COMBUSTIBLE------------------------>
        if(e.getSource() == vistaCombustible.btnCombustible){
            vistaCombustible.jpnInicio.setVisible(false);
            vistaCombustible.jpnTicket.setVisible(false);
            vistaCombustible.jpnEstadisticas.setVisible(false);
            vistaCombustible.jpnCombustible.setVisible(true);
            vistaCombustible.jpnChofer.setVisible(false);
            vistaCombustible.jpnDepartamento.setVisible(false);
            vistaCombustible.jpnProveedor.setVisible(false);
            vistaCombustible.jpnVehiculo.setVisible(false);
            
            vistaCombustible.jpnTituloInicio.setVisible(false);
            vistaCombustible.jpnTituloTicket.setVisible(false);
            vistaCombustible.jpnTituloEstadisticas.setVisible(false);
            vistaCombustible.jpnTituloCombustible.setVisible(true);
            vistaCombustible.jpnTituloChofer.setVisible(false);
            vistaCombustible.jpnTituloDepto.setVisible(false);
            vistaCombustible.jpnTituloProveedor.setVisible(false);
            vistaCombustible.jpnTituloVehiculo.setVisible(false);
            
            vistaCombustible.llena_comboProveedorCombustible();
            vistaCombustible.consultarCombustible();
        }
        //---------------------GUARDAR----------------------------------------->
        if(e.getSource() == vistaCombustible.btnGuardarCombustible){
            combusM.setTipo(vistaCombustible.txtTipoCombustible.getText());
            combusM.setPrecio(Double.parseDouble(vistaCombustible.txtPrecioCombustible.getText()));
            combusM.setProveedor(Integer.parseInt(vistaCombustible.txtIdProveedorCombustible.getText()));
           
            if(combusC.guardar(combusM)){
                JOptionPane.showMessageDialog(null, "Datos guardados");
                limpiarCombustible();
                vistaCombustible.consultarCombustible();
            }else{
                JOptionPane.showMessageDialog(null, "Error al guardar");
                limpiarCombustible();
                vistaCombustible.consultarCombustible();
            }
        }
        if(e.getSource() == vistaCombustible.btnActualizarCombustible){
            combusM.setTipo(vistaCombustible.txtTipoCombustible.getText());
            combusM.setPrecio(Double.parseDouble(vistaCombustible.txtPrecioCombustible.getText()));
            combusM.setProveedor(Integer.parseInt(vistaCombustible.txtIdProveedorCombustible.getText()));
            combusM.setId_combustible(Integer.parseInt(vistaCombustible.txtIdCombustible.getText()));
            
            if(combusC.actualizar(combusM)){
                JOptionPane.showMessageDialog(null, "Datos actualizados");
                limpiarCombustible();
                vistaCombustible.consultarCombustible();
            }else{
                JOptionPane.showMessageDialog(null, "Error al actualizar");
                limpiarCombustible();
                vistaCombustible.consultarCombustible();
            }
        }
        //-------------CARGAR ID DEL PROVEEDOR DE COMBUSTIBLE------------------>
        if(e.getSource() == vistaCombustible.rscProveedorCombustible){
            vistaCombustible.consultarIdProveedorCombustible();
        }
        
        if(e.getSource() == vistaCombustible.btnLimpiarCombustible){
            limpiarCombustible();
        }
        
    }
    
    public void limpiarCombustible(){
        vistaCombustible.txtTipoCombustible.setText("");
        vistaCombustible.txtPrecioCombustible.setText("");
        vistaCombustible.rscProveedorCombustible.setSelectedIndex(0);
        vistaCombustible.txtIdProveedorCombustible.setText("");
        vistaCombustible.txtIdCombustible.setText("");
    }
}
