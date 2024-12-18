
import sienens.ATM;
import urjc.UrjcBankServer;

public class UrjcAtm {
    public static void main(String[] args) {
        ATM atm = new ATM();
        UrjcBankServer server = new UrjcBankServer();
        OperationContext c = new OperationContext(atm,server,"");
        ClientManagement management = new ClientManagement(c);
        management.doOperation();
    }
}
