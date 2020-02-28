package control_gasolina;

import Controlador.CtrlChofer;
import Controlador.CtrlCombustible;
import Controlador.CtrlDepartamento;
import Controlador.CtrlEstadisticas;
import Controlador.CtrlInicio;
import Controlador.CtrlProveedor;
import Controlador.CtrlTicket;
import Controlador.CtrlVehiculo;
import Modelo.chofer;
import Modelo.combustible;
import Modelo.consultasChofer;
import Modelo.consultasDepto;
import Modelo.consultasProveedor;
import Modelo.consultasCombustible;
import Modelo.consultasVehiculo;
import Modelo.departamento;
import Modelo.proveedor;
import Modelo.vehiculo;
import Vista.home;

/**
 *
 * @author alexmartinez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        home vHome = new home();

        //Inicio
        CtrlInicio inicio = new CtrlInicio(vHome);
        
        //Ticket
        CtrlTicket ticket = new CtrlTicket(vHome);
        
        //Estadisticas
        CtrlEstadisticas estadis = new CtrlEstadisticas(vHome);
        
        //Combustible
        combustible combusMod = new combustible();
        consultasCombustible Ccombustible = new consultasCombustible();
        CtrlCombustible combustible = new CtrlCombustible(combusMod, Ccombustible, vHome);

        //Chofer
        chofer choferMod = new chofer();
        consultasChofer Cchofer = new consultasChofer();
        CtrlChofer Ctrlchofer = new CtrlChofer(choferMod, Cchofer, vHome);
        
        //Departamento
        departamento deptoMod = new departamento();
        consultasDepto Cdepto = new consultasDepto();
        CtrlDepartamento Ctrldepto = new CtrlDepartamento(deptoMod, Cdepto, vHome);
//        Ctrldepto.iniciar();

        //Proveedor
        proveedor proveMod = new proveedor();
        consultasProveedor Cprove = new consultasProveedor();
        CtrlProveedor Ctrlprove = new CtrlProveedor(proveMod, Cprove, vHome);
        
        //Vehiculo
        vehiculo cocheMod = new vehiculo();
        consultasVehiculo cocheC = new consultasVehiculo();
        CtrlVehiculo vehiculo = new CtrlVehiculo(cocheMod, cocheC, vHome);

        //Visualizar panel de inicio
        vHome.setLocationRelativeTo(null);
        vHome.setVisible(true);
        
        vHome.jpnInicio.setVisible(true);
        vHome.jpnTicket.setVisible(false);
        vHome.jpnEstadisticas.setVisible(false);
        vHome.jpnCombustible.setVisible(false);
        vHome.jpnChofer.setVisible(false);
        vHome.jpnDepartamento.setVisible(false);
        vHome.jpnProveedor.setVisible(false);
        vHome.jpnVehiculo.setVisible(false);

        vHome.jpnTituloInicio.setVisible(true);
        vHome.jpnTituloTicket.setVisible(false);
        vHome.jpnTituloEstadisticas.setVisible(false);
        vHome.jpnTituloCombustible.setVisible(false);
        vHome.jpnTituloChofer.setVisible(false);
        vHome.jpnTituloDepto.setVisible(false);
        vHome.jpnTituloProveedor.setVisible(false);
        vHome.jpnTituloVehiculo.setVisible(false);

    }

}
