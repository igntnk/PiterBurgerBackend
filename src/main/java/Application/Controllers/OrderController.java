package Application.Controllers;

import Application.Controllers.ControllerAdvice.Response;
import Application.DTO.OrderDTO;
import Application.Services.OrderService;
import Application.Services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PutMapping(path = "cooking")
    public OrderDTO setCookingStatus(@RequestParam Long id){
        return orderService.setStatusCooking(id);
    }

    @PutMapping(path = "cooked")
    public OrderDTO setCookedStatus(@RequestParam Long id){
        return orderService.setStatusCooked(id);
    }

    @PutMapping(path = "serving")
    public OrderDTO setServingStatus(@RequestParam Long id){
        return orderService.setStatusServing(id);
    }

    @PutMapping(path = "served")
    public OrderDTO setServedStatus(@RequestParam Long id){
        return orderService.setStatusServed(id);
    }

    @PutMapping(path = "freeze")
    public OrderDTO setFreezeStatus(@RequestParam Long id){
        return orderService.setStatusFreeze(id);
    }

    @PutMapping(path = "active")
    public OrderDTO setActiveStatus(@RequestParam Long id){
        return orderService.setStatusActive(id);
    }

    @DeleteMapping(path = "delete")
    public ResponseEntity<Response> deleteOrder(Long id){
        orderService.deleteOrder(id);
        Response response = new Response(
                "Order with id: " + id + " succesifully deleted",
                null,
                new Date());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}