package Application.Services;

import Application.Controllers.ControllerAdvice.Response;
import Application.DTO.GroupDTO;
import Application.DTO.OrderDTO;
import Application.DTO.OrderItemDTO;
import Application.DTO.ProductDTO;
import Application.DataBase.Entities.*;
import Application.DataBase.Entities.Auth.Credential;
import Application.DataBase.Repository.*;
import Application.Mappers.*;
import lombok.Data;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CustomerService {

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    GroupListMapper groupListMapper;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductListMapper productListMapper;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderListMapper orderListMapper;

    public List<GroupDTO> getAllGroups(){
        return groupListMapper.toDTOlist(groupRepository.findAll());
    }

    public List<ProductDTO> getProductsByGroups(Long id){
        return productListMapper.toDTOList(productRepository.getProductsByGroup(id));
    }

    public int getPrice(List<OrderItemDTO> items){
        int resultPrice = 0;
        List<Product> products = productRepository.findAll();
        for(OrderItemDTO it:items){
            resultPrice += products.get(Math.toIntExact(it.getProduct().getId())).
                    getPrice()*it.getCount();
        }
        return resultPrice;
    }

    public Response getMyName(String email){
        return new Response(userRepository.getUserByEmail(email).getFIO());
    }

    public Response setName(String email, String name){
        User refer = userRepository.getUserByEmail(email);
        refer.setFIO(name);
        userRepository.save(refer);
        return new Response(name);
    }

    public List<OrderDTO> getHistoryOrders(String email){
        return orderListMapper.toDTOList(orderRepository.getHistory(email));
    }

    public List<OrderDTO> getActiveOrders(String email){
        return orderListMapper.toDTOList(orderRepository.getActiveOrders(email));
    }

}
