package Application.Controllers.ControllerAdvice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Response   {
    private String message;
    private String solution;
    private Date date;
}
