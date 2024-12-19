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
        boolean salir=false;

        while (salir==false){
            if (getOperationContext().getServer().comunicationAvaiable()){
                for (int cont = 0; cont < 6; cont++)
                    this.getOperationContext().getAtm().setOption(cont, null);

                this.getOperationContext().getAtm().setTitle("Seleccione la opción que desee");
                this.getOperationContext().getAtm().setOption(0, "Sacar dinero");
                this.getOperationContext().getAtm().setOption(1, "Consultar saldo");
                this.getOperationContext().getAtm().setOption(2, "Operaciones");
                this.getOperationContext().getAtm().setOption(3, "Cambiar contraseña");
                this.getOperationContext().getAtm().setOption(4, "Idioma");
                this.getOperationContext().getAtm().setOption(5, "Terminar");

                char event = this.getOperationContext().getAtm().waitEvent(30);

                if (event == 'A'){
                    WithdrawCash sacar = new WithdrawCash(this.getOperationContext());
                    sacar.doOperation();

                }else if(event == 'F'){
                    ClientGoodbye cb = new ClientGoodbye(this.getOperationContext());
                    cb.doOperation();
                    salir = true;

                }else if (event == 'B'){
                    AccountBalance saldo = new AccountBalance(this.getOperationContext());
                    saldo.doOperation();



                } else if (event == 'C'){
                    LastOperations operaciones = new LastOperations(this.getOperationContext());
                    operaciones.doOperation();
                } else if (event == 'E'){
                    IdiomSelection idioma = new IdiomSelection(this.getOperationContext());
                    idioma.doOperation();

                }


            } else {
                ErrorExit error = new ErrorExit(this.getOperationContext());
                error.doOperation();
            }
        }

        return false;
    }


}
