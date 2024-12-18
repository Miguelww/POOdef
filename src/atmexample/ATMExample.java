/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atmexample;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.CommunicationException;
import sienens.ATM;
import urjc.UrjcBankServer;

/**
 *
 * @author angel.sanchez
 */
public class ATMExample {

    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {
        ATM simulator = new ATM();
        UrjcBankServer bankServer = new UrjcBankServer();
                
        pantallaDeInicio(simulator);

        simulator.retainCreditCard(false);
        
        simulator.setTitle("Selecciones la opción que desee");
        simulator.setOption(0, "Sacar dinero");
        simulator.setOption(1, "Consultar saldo");
        simulator.setOption(5, "Terminar");
        
        char event = simulator.waitEvent(30);
        
        if (event == 'F') {
            simulator.expelCreditCard(30);
            pantallaDeInicio(simulator);        
        }
                
        else if (event == 'A') {
            pantallaPreguntarCantidad(simulator);
            long creditCardNumber = simulator.getCardNumber();
            try {
                int disponible = bankServer.avaiable(creditCardNumber);
                if (disponible >= 20)
                    simulator.expelAmount(20, 30);
            } catch (CommunicationException ex) {
                Logger.getLogger(ATMExample.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private static void pantallaPreguntarCantidad(ATM simulator) {
        simulator.setTitle("Teclee la cantidad que desea");
        char event = simulator.waitEvent(30);
        String cadena = "";
        while (event >= '0' && event <= '9') {
            cadena += event;
            simulator.setInputAreaText(cadena + " €");
            event = simulator.waitEvent(30);
        }
    }

    private static void pantallaDeInicio(ATM simulator) {
        simulator.setTitle("Introduzca la tarjeta");
        simulator.setInputAreaText("");
        for (int cont = 0; cont < 6; cont++)
            simulator.setOption(cont, null);
        
        char event = simulator.waitEvent(30);
        
        while (event != 1){
            event = simulator.waitEvent(30);
        }
    }
    */
}
