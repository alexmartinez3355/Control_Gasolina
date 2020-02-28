package Controlador;

import Vista.home;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author alexmartinez
 */
public class CtrlEstadisticas implements ActionListener {
    private home vistaEstadis;
    
    public CtrlEstadisticas(home vistaEstadisticas){
        this.vistaEstadis = vistaEstadisticas;
        this.vistaEstadis.btnEstadisticas.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        //-----------------------PASAR AL MODULO ESTADISTICAS------------------>
        if(e.getSource() == vistaEstadis.btnEstadisticas){
            vistaEstadis.jpnInicio.setVisible(false);
            vistaEstadis.jpnTicket.setVisible(false);
            vistaEstadis.jpnEstadisticas.setVisible(true);
            vistaEstadis.jpnCombustible.setVisible(false);
            vistaEstadis.jpnChofer.setVisible(false);
            vistaEstadis.jpnDepartamento.setVisible(false);
            vistaEstadis.jpnProveedor.setVisible(false);
            vistaEstadis.jpnVehiculo.setVisible(false);
            
            vistaEstadis.jpnTituloInicio.setVisible(false);
            vistaEstadis.jpnTituloTicket.setVisible(false);
            vistaEstadis.jpnTituloEstadisticas.setVisible(true);
            vistaEstadis.jpnTituloCombustible.setVisible(false);
            vistaEstadis.jpnTituloChofer.setVisible(false);
            vistaEstadis.jpnTituloDepto.setVisible(false);
            vistaEstadis.jpnTituloProveedor.setVisible(false);
            vistaEstadis.jpnTituloVehiculo.setVisible(false);
        }
    }
}
