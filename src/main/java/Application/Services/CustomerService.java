package Application.Services;

import Application.DTO.OrderDTO;
import Application.DTO.OrderItemDTO;
import Application.DTO.ProductDTO;
import Application.DataBase.Entities.*;
import Application.DataBase.Entities.Auth.Credential;
import Application.DataBase.Repository.*;
import Application.Mappers.OrderMapper;
import Application.Mappers.ProductListMapper;
import Application.Mappers.ProductMapper;
import lombok.Data;
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
    ProductRepository productRepository;

    @Autowired
    ProductListMapper productListMapper;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderMapper orderMapper;

    public List<String> getAllGroups(){
        return groupRepository.findAll().stream().map(Group::getName).collect(Collectors.toList());
    }

    public List<ProductDTO> getProductsByGroups(Long id){
        return productListMapper.toDTOList(productRepository.getProductsByGroup(id));
    }

    public int getPrice(List<OrderItemDTO> items){
        int resultPrice = 0;
        List<Product> products = productRepository.findAll();
        for(OrderItemDTO it:items){
            resultPrice += products.get(Math.toIntExact(it.getProductId())).
                    getPrice()*it.getCount();
        }
        return resultPrice;
    }

    public String getMyName(String email){
        return userRepository.getUserByEmail(email).getFIO();
    }

    public OrderDTO createOrder(OrderDTO orderRef, String email){
        List<Product> allProducts = productRepository.findAll();
        Order order = new Order(
                orderRef.getComment(),
                new Date(),
                BaseStatus.ACTIVE,
                orderRef.getItems().stream().map(el->
                        new OrderItem(
                                el.getCount()
                                ,allProducts.get(Math.toIntExact(el.getProductId()))
                        ))
                        .collect(Collectors.toSet())
                );
        order.setUser(userRepository.getUserByEmail(email));
        return orderMapper.toDTO(orderRepository.save(order));
    }

}
