package natrodrigues.natbank.server.config.exception;

public class NatbankException extends Exception {

    private static final long serialVersionUID = 1L;
    protected String message;
    protected String field;
    protected String hint;

    public NatbankException() {
    }

    public NatbankException(String message, String field, String hint) {
        this.message = message;
        this.hint = hint;
        this.field = field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getHint() {
        return hint;
    }
}