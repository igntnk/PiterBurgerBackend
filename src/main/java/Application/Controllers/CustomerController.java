package Application.Controllers;

import Application.DTO.*;
import Application.DataBase.Entities.Auth.Credential;
import Application.DataBase.Entities.OrderItem;
import Application.DataBase.Entities.Product;
import Application.DataBase.Entities.User;
import Application.DataBase.Repository.UserRepository;
import Application.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Objects;

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
    public String getName(Principal principal){
        return customerService.getMyName(principal.getName());
    }


}
