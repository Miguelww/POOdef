
public class ClientGoodbye extends AtmOperation{

    public ClientGoodbye(OperationContext  opcont) {
        super(opcont);
    }

    @Override
    public boolean doOperation(){
        this.getOperationContext().getAtm().expelCreditCard(30);
        this.getOperationContext().getAtm().setTitle("Hasta la proxima");

        return true;

    }


}
