package natrodrigues.natbank.server.config.interceptor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import natrodrigues.natbank.server.config.exception.NatbankException;
import natrodrigues.natbank.server.config.exception.NatbankExceptionSchema;

@RestControllerAdvice
public class ExceptionInterceptor extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(NatbankException.class)
    public ResponseEntity<?> handleNatbankExceptions(NatbankException ex) {
        NatbankExceptionSchema exceptionResponse =
            new NatbankExceptionSchema(ex.getMessage(), ex.getField(), ex.getHint());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionResponse);
    }
}