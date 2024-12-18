
public abstract class AtmOperation {
    
    private OperationContext operationContext;

    public AtmOperation(OperationContext operationContext) {
        this.operationContext = operationContext;
    }
    public abstract boolean doOperation();

    public OperationContext getOperationContext() {
        return operationContext;
    }

    
    
}
