package Application.Controllers.ControllerAdvice;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import java.util.Date;
import java.util.NoSuchElementException;

@ControllerAdvice
public class DefaultAdvice {
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ExceptionResponse> handleException(NoSuchElementException ex){
        ExceptionResponse response = new ExceptionResponse(
                String.format(ex.getMessage()),
                "Change params' value",
                new Date());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ExceptionResponse> handleException(HttpRequestMethodNotSupportedException ex){
        ExceptionResponse response = new ExceptionResponse(
                String.format(ex.getMessage()),
                "Change HTTP method to correct",
                new Date());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<ExceptionResponse> handleException(EmptyResultDataAccessException ex){
        ExceptionResponse response = new ExceptionResponse(
                String.format(ex.getMessage()),
                "Change data info",
                new Date());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ExceptionResponse> handleException(MissingServletRequestParameterException ex){
        ExceptionResponse response = new ExceptionResponse(
                String.format(ex.getMessage()),
                "Change data info",
                new Date());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
