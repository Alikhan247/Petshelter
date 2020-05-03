package kz.iitu.alikhan.petshelter.exception.handler;

import kz.iitu.alikhan.petshelter.exception.NoRoleException;
import kz.iitu.alikhan.petshelter.exception.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Component
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = NoRoleException.class)
    public ResponseEntity<ErrorResponse> handleNoRoleException(NoRoleException e) {
        log.error("Exception handled: " + e.getMessage(), e);
        ErrorResponse errorResponse = new ErrorResponse("No role exception", e.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<ErrorResponse> handleNullPointerException(NullPointerException e) {
        log.error("Exception handled: " + e.getMessage(), e);
        ErrorResponse errorResponse = new ErrorResponse("NullPointerException", e.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // all other exception
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> handleAnyException(Exception e) {
        log.error("Exception handled: " + e.getMessage(), e);
        ErrorResponse errorResponse = new ErrorResponse("INTERNAL_SERVER_ERROR",
                "Произошла системсная ошибка. Обратитесь к службе поддержки.");

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
