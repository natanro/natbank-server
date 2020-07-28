package natrodrigues.natbank.server.config.exception;

public class TransactionException extends NatbankException {

    private static final long serialVersionUID = 1L;

    public TransactionException() {
        super();
    }

    public TransactionException(String field, String hint) {
        super("Transaction exception", field, hint);
    }
    
}