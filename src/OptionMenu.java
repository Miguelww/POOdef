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
        return false;
    }


}
