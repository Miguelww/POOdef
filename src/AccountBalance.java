import javax.naming.CommunicationException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountBalance extends TitledOperation{
    public AccountBalance(OperationContext operationContext) {
        super(operationContext);
    }

    @Override
    public String getTitle(){
        return "Account Balance";
    }
    @Override
    public boolean doOperation()  {
      /*  System.out.println("Operacion iniciada");
        int balance = operationContext.getServidor().avaiable(operationContext.getATM().getCardNumber());
        operationContext.getATM().print(List.of("Ingresos actuales:" + balance));
        return true;    */
      this.getOperationContext().getAtm().setTitle("Balance");
        try {
            this.getOperationContext().getAtm().setInputAreaText("Tu balanance es "
                    +(this.getOperationContext().getServer().balance(this.getOperationContext().getAtm().getCardNumber()))+"€");
        } catch (CommunicationException ex) {
            Logger.getLogger(AccountBalance.class.getName()).log(Level.SEVERE, null, ex);
        }
     this.getOperationContext().getAtm().setOption(5, "Volver");
     char event =this.getOperationContext().getAtm().waitEvent(30);
     if(event=='F'){
         return true;
     }else{
         return false;
     }
    }
}
