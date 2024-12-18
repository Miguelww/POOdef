import javax.naming.CommunicationException;


public class ClientManagement extends AtmOperation {
    public ClientManagement(OperationContext opCont) {
        super(opCont);
    }
    

   
    @Override
    public boolean doOperation()  {
        boolean encendido = true;
        while(encendido==true){
            waitForClient();
            clientIdentification();
            
        }
        return false;
    }
    

    private void presentOptions(){
        OptionMenu opciones = new OptionMenu(this.getOperationContext());
        opciones.doOperation();
    }
    private void waitForClient(){
        
        this.getOperationContext().getAtm().setTitle("Introduzca la tarjeta");
        this.getOperationContext().getAtm().setInputAreaText(null);
        for (int cont = 0; cont < 6; cont++)
            this.getOperationContext().getAtm().setOption(cont, null);
        
        char event = this.getOperationContext().getAtm().waitEvent(30);
        
        while (event != 1){
            event = this.getOperationContext().getAtm().waitEvent(30);
        }
    }
    
    private void clientIdentification(){
        ClientIdentification c = new ClientIdentification(this.getOperationContext());
       boolean identificado = c.doOperation();
        if (identificado){
            presentOptions();
        }
        
    }

}
