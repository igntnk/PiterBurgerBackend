package app.controllers;

import app.controllers.advice.Response;
import app.services.CustomerService;
import app.dto.GroupDTO;
import app.dto.OrderDTO;
import app.dto.OrderItemDTO;
import app.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;


    @GetMapping(path= "groups",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GroupDTO> getAllGroups(){
        return customerService.getAllGroups();
    }

    @GetMapping(path = "grouprod",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDTO> getProdByGroup(@RequestParam("id") Long id){
        return customerService.getProductsByGroups(id);
    }

    @GetMapping(path = "price",produces = MediaType.APPLICATION_JSON_VALUE)
    public int getPrice(@RequestBody List<OrderItemDTO> items){
        return customerService.getPrice(items);
    }

    @GetMapping(path = "name", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response getName(Principal principal){
        return customerService.getMyName(principal.getName());
    }

    @PostMapping(path = "name" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Response setName(
            Principal principal,
            @RequestBody String name){
        return customerService.setName(principal.getName(), name);
    }

    @GetMapping(path = "history",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDTO> getHistory(Principal principal){
        return customerService.getHistoryOrders(principal.getName());
    }

    @GetMapping(path = "active", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDTO> getActive(Principal principal) {
        return customerService.getActiveOrders(principal.getName());
    }

}
