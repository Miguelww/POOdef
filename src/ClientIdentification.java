
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.CommunicationException;

public class ClientIdentification extends AtmOperation{
    public ClientIdentification(OperationContext cont){
        super(cont);
    }
    @Override
    public boolean doOperation() {
         for (int cont = 0; cont < 6; cont++){
           
            this.getOperationContext().getAtm().setOption(cont, null);
        
        }
         this.getOperationContext().getAtm().setTitle("Introduce la contraseña:");
        
        
        
        int intentos = 0;
        boolean pass = false;
        
        this.getOperationContext().getAtm().setOption(0, "Intentos:");
        this.getOperationContext().getAtm().setOption(3, Integer.toString(intentos));
        //char ev = this.getOperationContext().getAtm().waitEvent(30);
        //String password = "";
        
        
        while(intentos<3 && pass==false){
        
            ATMNumberCapturer a = new ATMNumberCapturer(this.getOperationContext().getAtm());
            int passw = a.capturePassword();
            
       
            

        try {
                    pass = this.getOperationContext().getServer().testPassword(passw,this.getOperationContext().getAtm().getCardNumber() );
                    
                } catch (CommunicationException ex) {
                    Logger.getLogger(ClientIdentification.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (pass == false){
                intentos++;
                this.getOperationContext().getAtm().setOption(3, Integer.toString(intentos));
                
                }
         
         
}
        if (pass==false){
             this.getOperationContext().getAtm().retainCreditCard(true);
             this.getOperationContext().getAtm().setTitle("Maximo de intentos superado");
              //ev = this.getOperationContext().getAtm().waitEvent(30);
             return false;
         }else if(pass == true){
             this.getOperationContext().getAtm().retainCreditCard(true);
             return pass;
         }
       return pass;
    }
}




