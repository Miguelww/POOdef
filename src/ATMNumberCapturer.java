import sienens.ATM;

public class ATMNumberCapturer {
    private ATM atm;

    public ATMNumberCapturer(ATM atm) {
        this.atm = atm;
    }

    public int captureAmount(){
        return atm.waitEvent(0);

    }
    public int capturePassword(){
        return atm.waitEvent(0);

    }
}
