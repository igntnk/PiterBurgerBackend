package app.controllers.advice;

import app.exceptions.EmailIsInUseExeption;
import app.exceptions.IllegalCnagingOrderStatusException;
import app.exceptions.NoSuchUserException;
import app.messages.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class DefaultAdvice {
    @ExceptionHandler(IllegalCnagingOrderStatusException.class)
    public ResponseEntity<ExceptionResponse> handleException(IllegalCnagingOrderStatusException ex){
        ExceptionResponse response = new ExceptionResponse(
                String.format(ex.getMessage()),
                "Change order to set status",
                new Date());
        return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(NoSuchUserException.class)
    public ResponseEntity<ExceptionResponse> handleException(NoSuchUserException ex){
        ExceptionResponse response = new ExceptionResponse(
                String.format(ex.getMessage()),
                "Change user credential",
                new Date());
        return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionResponse> handleException(IllegalArgumentException ex){
        ExceptionResponse response = new ExceptionResponse(
                String.format(ex.getMessage()),
                "Change user id",
                new Date());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailIsInUseExeption.class)
    public ResponseEntity<ExceptionResponse> handleException(EmailIsInUseExeption ex){
        ExceptionResponse response = new ExceptionResponse(
                String.format(ex.getMessage()),
                "Change email to registrate",
                new Date());
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
}
