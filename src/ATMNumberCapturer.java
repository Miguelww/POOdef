import sienens.ATM;

public class ATMNumberCapturer {
    private ATM atm;

    public ATMNumberCapturer(ATM atm) {
        this.atm=atm;
    }

    public int captureAmount(){
        /*
        String cantidad = "";
        char event = this.getAtm().waitEvent(30);
        while (event >= '0' && event <= '9') {
            cantidad += event;
            this.getAtm().setInputAreaText(cantidad+"€");
            event = this.getAtm().waitEvent(30);
        }
        if(event =='Y'){
        
        return Integer.parseInt(cantidad);
        }else if(event == 'N'){
            cantidad = "";
        }else if ('-'){
            cantidad = cantidad.substring(cantidad.length()-1);
            this.getOperationContext().getAtm().setInputAreaText(cantidad + " €");
            
            
        }
        return 0;
        */
        String cantidad = "";
        char event = this.getAtm().waitEvent(30);
        boolean acabado = false;
        while(!acabado){
        while (event >= '0' && event <= '9') {
            cantidad += event;
            this.getAtm().setInputAreaText(cantidad + " €");
            event = this.getAtm().waitEvent(30);
            acabado= true;
        }
        if (event == 'Y'){
            
        }else if(event == 'N'){
            
        }else if(event == '-'){
            cantidad = cantidad.substring(cantidad.length()-1);
            this.getAtm().setInputAreaText(cantidad + " €");
            
        }
        }
        
        return Integer.parseInt(cantidad);

    }
    
    
    public int capturePassword(){
        String password = "";
        char event = this.getAtm().waitEvent(30);
        while (event >= '0' && event <= '9') {
            password += event;
            this.getAtm().setInputAreaText(password);
            event = this.getAtm().waitEvent(30);
        }
        if(event =='Y'){
        
        return Integer.parseInt(password);
        }else if(event == 'N'){
            password = "";
        }else{
            
        }
        return 0;
    }

    public ATM getAtm() {
        return atm;
    }

}
