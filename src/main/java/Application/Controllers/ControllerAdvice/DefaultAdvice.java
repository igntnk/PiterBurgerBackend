package Application.Controllers.ControllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@ControllerAdvice
public class DefaultAdvice {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Response> handleException(NoSuchElementException ex){
        Response response = new Response(String.format("%s %s", LocalDateTime.now(), ex.getMessage()));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
