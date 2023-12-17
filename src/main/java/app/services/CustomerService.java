package app.services;

import app.controllers.advice.Response;
import app.dto.GroupDTO;
import app.dto.OrderDTO;
import app.dto.OrderItemDTO;
import app.dto.ProductDTO;
import app.db.Entities.User;
import app.db.Repository.GroupRepository;
import app.db.Repository.OrderRepository;
import app.db.Repository.ProductRepository;
import app.db.Repository.UserRepository;
import app.mappers.GroupListMapper;
import app.mappers.OrderListMapper;
import app.mappers.OrderMapper;
import app.mappers.ProductListMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

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
