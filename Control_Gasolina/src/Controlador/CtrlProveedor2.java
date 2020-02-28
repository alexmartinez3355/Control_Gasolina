package Controlador;

import Modelo.consultasProveedor;
import Modelo.proveedor;
import Vista.home;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author alexmartinez
 */
public class CtrlProveedor2 implements KeyListener{
    private proveedor proveM;
    private consultasProveedor Cprove;
    private home vistaProve;
    
    public CtrlProveedor2(proveedor Mprove, consultasProveedor proveC, home vista){
        this.Cprove = proveC;
        this.proveM = Mprove;
        this.vistaProve = vista;
        this.vistaProve.txtNombreProveedor.addKeyListener(this);
        this.vistaProve.txtDireccionProveedor.addKeyListener(this);
        this.vistaProve.txtRFCProveedor.addKeyListener(this);
        this.vistaProve.txtTelefonoProveedor.addKeyListener(this);

        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getSource() == vistaProve.txtNombreProveedor){
            vistaProve.txtNombreProveedor.setText(vistaProve.txtNombreProveedor.getText().toUpperCase());
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
