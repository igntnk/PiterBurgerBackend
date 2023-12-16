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
import lombok.AllArgsConstructor;
import lombok.Data;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class CustomerService {

    GroupRepository groupRepository;
    GroupListMapper groupListMapper;

    ProductRepository productRepository;
    ProductListMapper productListMapper;

    UserRepository userRepository;

    OrderRepository orderRepository;
    OrderMapper orderMapper;
    OrderListMapper orderListMapper;

    public List<GroupDTO> getAllGroups(){
        return groupListMapper.toDTOlist(groupRepository.findAll());
    }

    public List<ProductDTO> getProductsByGroups(Long id){
        return productListMapper.toDTOList(productRepository.getProductsByGroup(id));
    }

    public int getPrice(List<OrderItemDTO> items){
        return items.stream().mapToInt(item->item.getProduct().getPrice()*item.getCount()).sum();
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
