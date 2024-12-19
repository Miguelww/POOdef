import sienens.ATM;
import urjc.UrjcBankServer;

import javax.naming.CommunicationException;
import java.io.BufferedReader;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


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
                try {
                    int disponible = getOperationContext().getServer().avaiable(getOperationContext().getAtm().getCardNumber());
                    if (disponible >= Integer.parseInt(cadena)) {
                        this.getOperationContext().getAtm().setTitle("Cantidad:");
                        this.getOperationContext().getAtm().setInputAreaText(cadena);
                        this.getOperationContext().getAtm().print(List.of(cadena + "€"));
                        this.getOperationContext().getAtm().expelAmount(Integer.parseInt(cadena), 30);
                        this.getOperationContext().getAtm().setInputAreaText(null);
                        this.getOperationContext().getAtm().expelCreditCard(30);
                    } else {
                        this.getOperationContext().getAtm().setTitle("Saldo insuficiente");
                        getOperationContext().getAtm().setOption(4,"Terminar");
                        event = this.getOperationContext().getAtm().waitEvent(30);
                        if (event == 'E'){
                            ClientGoodbye salida = new ClientGoodbye(getOperationContext());
                            salida.doOperation();
                        }
                    }
                } catch (CommunicationException e) {
                    Logger.getLogger(WithdrawCash.class.getName()).log(Level.SEVERE, null, e);
                }

            }else if(event == 'N'){
                this.getOperationContext().getAtm().setTitle("Operacion cancelada");
                event = this.getOperationContext().getAtm().waitEvent(30);
                OptionMenu inicio = new OptionMenu(getOperationContext());
                inicio.doOperation();


            }else if(event == '-'){
            cadena = cadena.substring(cadena.length()-1);
            this.getOperationContext().getAtm().setInputAreaText(cadena + " €");

        }
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
