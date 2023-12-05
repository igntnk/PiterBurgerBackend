package Application.Controllers.ControllerAdvice;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.NoSuchElementException;

@ControllerAdvice
public class DefaultAdvice {
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Response> handleException(NoSuchElementException ex){
        Response response = new Response(
                String.format(ex.getMessage()),
                "Change params' value",
                new Date());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Response> handleException(HttpRequestMethodNotSupportedException ex){
        Response response = new Response(
                String.format(ex.getMessage()),
                "Change HTTP method to correct",
                new Date());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<Response> handleException(EmptyResultDataAccessException ex){
        Response response = new Response(
                String.format(ex.getMessage()),
                "Change data info",
                new Date());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
