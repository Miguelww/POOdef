import sienens.ATM;
import urjc.UrjcBankServer;

public class OperationContext {
    private ATM atm;
    private UrjcBankServer server;
    private String idiom;

    public OperationContext(ATM atm, UrjcBankServer server, String idiom) {
        this.atm = atm;
        this.server = server;
        this.idiom = idiom;

    }

    public UrjcBankServer getServer() {
        return this.server;
    }
    public ATM getAtm() {
        return this.atm;

    }
    public String getIdiom() {
        return this.idiom;

    }
    public void setIdiom(String idiom) {

    }
}
