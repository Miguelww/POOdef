import sienens.ATM;

public class ATMNumberCapturer {
    private ATM atm;

    public ATMNumberCapturer(ATM atm) {
        this.atm=atm;
    }

    public int captureAmount(){
      String cantidad = "";
        boolean acabado = false;
        while (acabado == false){
            
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
            this.getAtm().setInputAreaText(cantidad);
            
        }else if (event == '-'){
            cantidad = cantidad.substring(0,cantidad.length()-1);
            this.getAtm().setInputAreaText(cantidad);
            
            
        }
        }
        return 0;

    }
    
    
    public int capturePassword(){
        String password = "";
        boolean acabado = false;
        while (acabado == false){
            
        char event = this.getAtm().waitEvent(30);
        
        while (event >= '0' && event <= '9') {
            password += event;
            this.getAtm().setInputAreaText(password);
            event = this.getAtm().waitEvent(30);
        }
        if(event =='Y'){
        this.getAtm().setInputAreaText("");
        return Integer.parseInt(password);
        }else if(event == 'N'){
            password = "";
            this.getAtm().setInputAreaText(password);
            
        }else if (event == '-'){
            password = password.substring(0,password.length()-1);
            this.getAtm().setInputAreaText(password);
            
            
        }
        }
        return 0;
    }

    public ATM getAtm() {
        return atm;
    }

}
