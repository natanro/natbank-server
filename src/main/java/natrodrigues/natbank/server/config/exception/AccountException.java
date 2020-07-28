package natrodrigues.natbank.server.config.exception;

public class AccountException extends NatbankException {

    private static final long serialVersionUID = 1L;

    public AccountException() {
        super();
    }

    public AccountException(String field, String hint) {
        super("Account exception", field, hint);
    }
    
}