package app.controllers;

import app.messages.CreateOrderMessage;
import app.messages.ExceptionResponse;
import app.dto.OrderDTO;
import app.dto.small.SmallOrderDTO;
import app.exceptions.IllegalCnagingOrderStatusException;
import app.exceptions.NoSuchUserException;
import app.services.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/order")
@Slf4j
public class OrderController {
    @Autowired
    OrderService orderService;

    @PutMapping(path = "next")
    public OrderDTO setCookingStatus(@RequestParam Long id) throws IllegalCnagingOrderStatusException {
        return orderService.setNextStatus(id);
    }

    @DeleteMapping(path = "delete")
    public ResponseEntity<ExceptionResponse> deleteOrder(@RequestParam Long id) {
        orderService.deleteOrder(id);
        ExceptionResponse response = new ExceptionResponse(
                "Order with id: " + id + " succesifully deleted",
                null,
                new Date());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "worker" , produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDTO> getWorkerOrders(){
        return orderService.getWorkerOrders();
    }

    @GetMapping(path = "manager" , produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDTO> getManagerOrders(){
        return orderService.getManagerOrders();
    }

    @MessageMapping("/next")
    @SendTo({"/order/manager","/order/worker", "order/history"})
    public OrderDTO setNextStatusOrder(Long id) throws IllegalCnagingOrderStatusException {
        log.info("Recieved message in /next: " + id);
        return orderService.setNextStatus(id);
    }

    @MessageMapping("/freeze")
    @SendTo({"/order/manager","/order/worker","order/history"})
    public OrderDTO setFreezeStatus(Long id){
        log.info("Recieved message in /freeze: " + id);
        return orderService.setStatusFreeze(id);
    }

    @MessageMapping("/active")
    @SendTo({"/order/manager","/order/worker","order/history"})
    public OrderDTO setActiveStatus(Long id){
        log.info("Recieved message in /active: " + id);
        return orderService.setStatusActive(id);
    }

    @MessageMapping("/create")
    @SendTo({"/order/manager","/order/worker","order/customer","order/history"})
    public OrderDTO createOrder(CreateOrderMessage message) throws NoSuchUserException {
        log.info("Recieved message in /active: " + message.getOrder());
        return orderService.createOrder(message.getOrder(), message.getEmail());
    }

}