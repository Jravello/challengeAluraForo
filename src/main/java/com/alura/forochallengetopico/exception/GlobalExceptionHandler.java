package com.alura.forochallengetopico.exception;
import com.alura.forochallengetopico.model.ErrorComp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.Date;
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ErrorException.class)
    public ResponseEntity<ErrorComp> generateNotFoundException(ErrorException ex) {
        ErrorComp error = new ErrorComp();
        error.setMessage(ex.getMessage());
        error.setStatus(String.valueOf(ex.getStatus().value()));
        error.setTime(new Date().toString());

        return new ResponseEntity<ErrorComp>(error, ex.getStatus());
    }
}
