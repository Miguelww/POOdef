import sienens.ATM;
import urjc.UrjcBankServer;

import java.io.BufferedReader;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.CommunicationException;


public class WithdrawCash extends TitledOperation{

    public WithdrawCash(OperationContext operationContext) {
        super(operationContext);
    }
    @Override
    public String getTitle() {
        return "Retirada en efectivo";
    }

    @Override
    public boolean doOperation() {
        
        for (int cont = 0; cont < 6; cont++)
            this.getOperationContext().getAtm().setOption(cont, null);
        
        this.getOperationContext().getAtm().setInputAreaText(null);
        this.getOperationContext().getAtm().setTitle("Teclee la cantidad que desea");
        ATMNumberCapturer a = new ATMNumberCapturer(this.getOperationContext().getAtm());
        int cant = a.captureAmount();
        try {
            if( this.getOperationContext().getServer().balance(this.getOperationContext().getAtm().getCardNumber()) >=cant){
                this.getOperationContext().getAtm().expelAmount(cant, 30);
                this.getOperationContext().getAtm().print(List.of(cant + "€"));
               this.getOperationContext().getServer().doOperation(this.getOperationContext().getAtm().getCardNumber(), cant);
            }
            /*
            char event = this.getOperationContext().getAtm().waitEvent(30);
            String cadena = "";
            boolean acabado = false;
            while(!acabado){
            while (event >= '0' && event <= '9') {
            cadena=cadena.concat(String.valueOf((event))); //Asi usamos la clase string para concatenar
            this.getOperationContext().getAtm().setInputAreaText(cadena + " €");
            event = this.getOperationContext().getAtm().waitEvent(30);
            acabado= true;
            }
            if (event == 'Y'){
            this.getOperationContext().getAtm().setTitle("Cantidad:");
            this.getOperationContext().getAtm().setInputAreaText(cadena);
            this.getOperationContext().getAtm().print(List.of(cadena + "€"));
            
            }else if(event == 'N'){
            this.getOperationContext().getAtm().setTitle("Operacion cancelada");
            

            }else if(event == '-'){
            cadena = cadena.substring(cadena.length()-1);
            this.getOperationContext().getAtm().setInputAreaText(cadena + " €");
            
            }
            }
            */
        } catch (CommunicationException ex) {
            Logger.getLogger(WithdrawCash.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      /*  ATM atm = operationContext.getATM();
        UrjcBankServer server = operationContext.getServidor();
        long cardNumber=atm.getCardNumber();
        Scanner texto = new Scanner(System.in);
        int cantidad=texto.nextInt();

        if(operationContext.getATM().hasAmount(cantidad)){
            operationContext.getATM().expelAmount(cantidad,1);
            operationContext.getATM().print(List.of("Cantidad retirada: " + cantidad));
            System.out.println("Operacion de retirada exitosa");
            return true;

        } else {
            operationContext.getATM().print(List.of("Cantidad insuficiente: "));
            System.out.println("Operacion de retirada fallida");

            return false;
        }
*/
        return false;

    }
}
