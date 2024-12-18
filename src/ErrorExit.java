public class ErrorExit extends AtmOperation{
    public ErrorExit(OperationContext operationContext) {
        super(operationContext);
    }

    @Override
    public boolean doOperation() {
        return false;
    }
}
