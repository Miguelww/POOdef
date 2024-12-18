
public class ClientGoodbye extends AtmOperation{

    public ClientGoodbye(OperationContext  opcont) {
        super(opcont);
    }

    @Override
    public boolean doOperation(){
        for (int cont = 0; cont < 6; cont++)
            this.getOperationContext().getAtm().setOption(cont, null);
        this.getOperationContext().getAtm().setInputAreaText(null);
        
        this.getOperationContext().getAtm().setTitle("Hasta la proxima");
        this.getOperationContext().getAtm().expelCreditCard(30);
        

        return true;

    }


}
