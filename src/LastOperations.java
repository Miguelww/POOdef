import javax.naming.CommunicationException;
import java.util.List;

public class LastOperations extends TitledOperation{
    public LastOperations(OperationContext operationContext) {
        super(operationContext);

    }

    @Override
    public boolean doOperation()  {
        /*
        List<String> operations = operationContext.getServidor().getLastOperations(operationContext.getATM().getCardNumber());
        operationContext.getATM().print(operations);
        */
        //this.getOperationContext().getAtm().print(List.of(this.getOperationContext().getServer().getLastOperations(this.getOperationContext().getAtm().getCardNumber())));
        return true;

    }
    public String getTitle() {
        return "Last Operations";
    }
}
