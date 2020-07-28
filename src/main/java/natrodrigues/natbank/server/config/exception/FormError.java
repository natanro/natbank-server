package natrodrigues.natbank.server.config.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

public class FormError {
    private String error;
    private String field;

    public FormError() {
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public FormError(String error, String field) {
        this.setError(error);
        this.setField(field);
    }

	public static List<FormError> getErrorList(Errors errors) {
        List<FieldError> fieldErrors = errors.getFieldErrors();
        List<FormError> formErrors = new ArrayList<>();
        fieldErrors.forEach(e -> {
            formErrors.add(new FormError(e.getDefaultMessage(), e.getField()));
        });
        return formErrors;
	}
}