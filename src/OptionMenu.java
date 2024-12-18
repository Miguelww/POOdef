import sienens.ATM;

import javax.naming.CommunicationException;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;



public class OptionMenu extends AtmOperation{
    private List<TitledOperation> operationList;



    public OptionMenu(OperationContext operationContext) {
        super(operationContext);
        operationList = List.of(new WithdrawCash(operationContext), new AccountBalance(operationContext),
                new LastOperations(operationContext), new ChangePassword(operationContext));

    }

    @Override
    public boolean doOperation()  {
        for (int cont = 0; cont < 6; cont++)
            this.getOperationContext().getAtm().setOption(cont, null);
        
        this.getOperationContext().getAtm().setTitle("Seleccione la opción que desee");
        this.getOperationContext().getAtm().setOption(0, "Sacar dinero");
        this.getOperationContext().getAtm().setOption(1, "Consultar saldo");
        this.getOperationContext().getAtm().setOption(2, "Operaciones");
        this.getOperationContext().getAtm().setOption(3, "Cambiar contraseña");
        this.getOperationContext().getAtm().setOption(5, "Terminar");
        
        char event = this.getOperationContext().getAtm().waitEvent(30);

        if (event=='0'){
            this.getOperationContext().getAtm().expelCreditCard(0);
            for (int cont = 0; cont < 6; cont++)
                this.getOperationContext().getAtm().setOption(cont, null);
            this.getOperationContext().getAtm().setTitle("Hasta la proxima");




        } else {
            for (int cont = 0; cont < 6; cont++)
                this.getOperationContext().getAtm().setOption(cont, null);
            this.getOperationContext().getAtm().setTitle("Recoja la tarjeta o seleccione una opcion");

        }
        
        
        
        return false;
    }


}
