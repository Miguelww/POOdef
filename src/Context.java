import sienens.ATM;
import urjc.UrjcBankServer;

public class Context {
    private ATM atm;
    private UrjcBankServer servidor;
    private String idiom;

    public Context(ATM atm, UrjcBankServer servidor, String idiom) {
        this.atm = atm;
        this.servidor = servidor;
        this.idiom = idiom;

    }
    public ATM getATM() {
        return atm;
    }
    public UrjcBankServer getServidor() {
        return servidor;
    }
    public String getIdiom() {
        return idiom;
    }
    public void setIdiom(String idiom) {
        this.idiom = idiom;
    }


}
