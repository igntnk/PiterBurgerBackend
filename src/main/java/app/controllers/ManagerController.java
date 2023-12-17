package app.controllers;

import app.dto.OrderDTO;
import app.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/manager")
public class ManagerController {
    @Autowired
    ManagerService managerService;

    @GetMapping(path = "orders", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDTO> getCounterOrders(){
        return managerService.getManagerOrders();
    }

    @GetMapping(path = "undone", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDTO> getUndoneOrders(){
        return managerService.getUndoneOrders();
    }
}
