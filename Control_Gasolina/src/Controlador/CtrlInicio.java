package Controlador;

import Vista.home;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author alexmartinez
 */
public class CtrlInicio implements ActionListener{
    private home vistaInicio;
    
    public CtrlInicio(home Inicio){
        this.vistaInicio = Inicio;
        this.vistaInicio.btnInicio.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == vistaInicio.btnInicio){
            vistaInicio.jpnInicio.setVisible(true);
            vistaInicio.jpnTicket.setVisible(false);
            vistaInicio.jpnEstadisticas.setVisible(false);
            vistaInicio.jpnCombustible.setVisible(false);
            vistaInicio.jpnChofer.setVisible(false);
            vistaInicio.jpnDepartamento.setVisible(false);
            vistaInicio.jpnProveedor.setVisible(false);
            vistaInicio.jpnVehiculo.setVisible(false);
            
            vistaInicio.jpnTituloInicio.setVisible(true);
            vistaInicio.jpnTituloTicket.setVisible(false);
            vistaInicio.jpnTituloEstadisticas.setVisible(false);
            vistaInicio.jpnTituloCombustible.setVisible(false);
            vistaInicio.jpnTituloChofer.setVisible(false);
            vistaInicio.jpnTituloDepto.setVisible(false);
            vistaInicio.jpnTituloProveedor.setVisible(false);
            vistaInicio.jpnTituloVehiculo.setVisible(false);
        }
    }
}
