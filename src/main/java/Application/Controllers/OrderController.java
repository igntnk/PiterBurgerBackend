package Application.Controllers;

import Application.Controllers.ControllerAdvice.ExceptionResponse;
import Application.DTO.OrderDTO;
import Application.DTO.SmallDTOs.SmallOrderDTO;
import Application.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
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
    public OrderDTO setCookingStatus(@RequestBody Long id){
        return orderService.setStatusCooking(id);
    }

    @PutMapping(path = "cooked")
    public OrderDTO setCookedStatus(@RequestBody Long id){
        return orderService.setStatusCooked(id);
    }

    @PutMapping(path = "serving")
    public OrderDTO setServingStatus(@RequestBody Long id){
        return orderService.setStatusServing(id);
    }

    @PutMapping(path = "served")
    public OrderDTO setServedStatus(@RequestBody Long id){
        return orderService.setStatusServed(id);
    }

    @PutMapping(path = "freeze")
    public OrderDTO setFreezeStatus(@RequestBody Long id){
        return orderService.setStatusFreeze(id);
    }

    @PutMapping(path = "active")
    public OrderDTO setActiveStatus(@RequestBody Long id){
        return orderService.setStatusActive(id);
    }

    @PutMapping(path = "done")
    public OrderDTO setDoneStatus(@RequestBody Long id){
        return orderService.setDoneStatus(id);
    }


    @DeleteMapping(path = "delete")
    public ResponseEntity<ExceptionResponse> deleteOrder(@RequestHeader Long id) {
        orderService.deleteOrder(id);
        ExceptionResponse response = new ExceptionResponse(
                "Order with id: " + id + " succesifully deleted",
                null,
                new Date());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "active" , produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDTO> getActiveOrders(){
        return orderService.getActiveOrders();
    }

    @PostMapping(path = "create", produces = MediaType.APPLICATION_JSON_VALUE)
    public SmallOrderDTO createOrder(@RequestBody SmallOrderDTO order, Principal principal){
        return orderService.createOrder(order,principal.getName());
    }

    @MessageMapping("/orders/{order_id}")
    @SendTo({"/orders/kitchen","/orders/counter", "orders/manager", "orders/{order_id}"})
    public OrderDTO action(){
        return new OrderDTO(null,null,null);
    }

}