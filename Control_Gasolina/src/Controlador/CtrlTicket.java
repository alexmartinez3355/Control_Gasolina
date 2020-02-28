package Controlador;

import Vista.home;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author alexmartinez
 */
public class CtrlTicket implements ActionListener {

    private home vistaTicket;

    public CtrlTicket(home vista) {
        this.vistaTicket = vista;
        this.vistaTicket.btnTicket.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaTicket.btnTicket) {
            vistaTicket.jpnInicio.setVisible(false);
            vistaTicket.jpnTicket.setVisible(true);
            vistaTicket.jpnEstadisticas.setVisible(false);
            vistaTicket.jpnCombustible.setVisible(false);
            vistaTicket.jpnChofer.setVisible(false);
            vistaTicket.jpnDepartamento.setVisible(false);
            vistaTicket.jpnProveedor.setVisible(false);
            vistaTicket.jpnVehiculo.setVisible(false);

            vistaTicket.jpnTituloInicio.setVisible(false);
            vistaTicket.jpnTituloTicket.setVisible(true);
            vistaTicket.jpnTituloEstadisticas.setVisible(false);
            vistaTicket.jpnTituloCombustible.setVisible(false);
            vistaTicket.jpnTituloChofer.setVisible(false);
            vistaTicket.jpnTituloDepto.setVisible(false);
            vistaTicket.jpnTituloProveedor.setVisible(false);
            vistaTicket.jpnTituloVehiculo.setVisible(false);
        }
    }
}
