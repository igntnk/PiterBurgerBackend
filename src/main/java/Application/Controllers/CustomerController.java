package Application.Controllers;

import Application.DTO.*;
import Application.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping(path = "/groups",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<String> getGroupNames(){
        return customerService.getGroupNames();
    }

    @GetMapping(path = "/productByGroup", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDTO> getProductsByGroup(@RequestParam("id")Long id){
        return customerService.getProductsByGroup(id);
    }

    @PostMapping(path = "/create",produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderDTO createOrder(@RequestBody OrderDTO order, Long id){
        return customerService.createOrder(order,id);
    }
}
