public class ErrorExit extends AtmOperation{
    public ErrorExit(OperationContext operationContext) {
        super(operationContext);
    }

    @Override
    public boolean doOperation() {
        if(!getOperationContext().getServer().comunicationAvaiable()){
            this.getOperationContext().getAtm().expelCreditCard(0);
            for (int cont = 0; cont < 6; cont++)
                this.getOperationContext().getAtm().setOption(cont, null);
            this.getOperationContext().getAtm().setTitle("Error");
            ClientManagement management=new ClientManagement(getOperationContext());
            management.doOperation();


        }


        return true;
    }
}
