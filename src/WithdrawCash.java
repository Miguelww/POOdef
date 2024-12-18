import sienens.ATM;
import urjc.UrjcBankServer;

import java.io.BufferedReader;
import java.util.List;
import java.util.Scanner;


public class WithdrawCash extends TitledOperation{

    public WithdrawCash(OperationContext operationContext) {
        super(operationContext);
    }
    @Override
    public String getTitle() {
        return "Withdraw Cash";
    }

    @Override
    public boolean doOperation() {
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
