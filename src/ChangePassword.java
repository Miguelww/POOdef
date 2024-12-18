import java.util.List;

public class ChangePassword extends TitledOperation{

    public ChangePassword(OperationContext operationContext) {
        super(operationContext);
    }
    @Override
    public boolean doOperation() {
        /*
        int nuevaContrasena=new ATMNumberCapturer(operationContext.getATM()).capturePassword();
        boolean aceptado= operationContext.getServidor().changePassword(nuevaContrasena, operationContext.getATM().getCardNumber());
        operationContext.getATM().print(List.of(aceptado ? "Contraseña cambiada" : "Cambio de contraseña fallido" ));
        System.out.println("Cambio de contrasseña" + (aceptado ? "Exitoso" : "!!"));
        return aceptado;
*/
        return false;
    }
    public String getTitle() {
        return "Change Password";
    }
}
