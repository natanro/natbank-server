package natrodrigues.natbank.server.config.exception;

public class NatbankExceptionSchema {
    private String message;
    private String field;
    private String hint;
    
    public NatbankExceptionSchema() {
    }

    public NatbankExceptionSchema(String message, String field, String hint) {
        this.setMessage(message);
        this.setField(field);
        this.setHint(hint);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }


}