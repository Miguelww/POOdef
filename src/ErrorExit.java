public class ErrorExit extends AtmOperation{
    public ErrorExit(OperationContext operationContext) {
        super(operationContext);
    }

    @Override
    public boolean doOperation() {
        if(!getOperationContext().getServer().comunicationAvaiable()){
            this.getOperationContext().getAtm().expelCreditCard(0);
        }


        return true;
    }
}
