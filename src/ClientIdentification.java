
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
        char ev = this.getOperationContext().getAtm().waitEvent(30);
        
        int intentos = 0;
        while(intentos<3){
        String password = "";
        while (ev>='0'&& ev<='9' && password.length()<4){
            password +=ev;
            this.getOperationContext().getAtm().setInputAreaText(password);
            ev = this.getOperationContext().getAtm().waitEvent(30);
        }
        }
         
        try {
            this.getOperationContext().getServer().testPassword(ev,this.getOperationContext().getAtm().getCardNumber() );
        } catch (CommunicationException ex) {
            Logger.getLogger(ClientIdentification.class.getName()).log(Level.SEVERE, null, ex);
        }
         char event = this.getOperationContext().getAtm().waitEvent(30);
        
        if (event == 'F') {
            return true;     
        }else{
            return false;
        }

        
       
    }
    
    
}
