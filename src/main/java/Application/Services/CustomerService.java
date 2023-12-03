package Application.Services;

import Application.DTO.OrderDTO;
import Application.DTO.OrderItemDTO;
import Application.DTO.ProductDTO;
import Application.DataBase.Entities.*;
import Application.DataBase.Repository.GroupRepository;
import Application.DataBase.Repository.OrderRepository;
import Application.DataBase.Repository.ProductRepository;
import Application.DataBase.Repository.UserRepository;
import Application.Mappers.OrderMapper;
import Application.Mappers.ProductMapper;
import Application.Mappers.Resolver.ProductResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CustomerService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductResolver productResolver;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;


    public List<String> getGroupNames(){
        return groupRepository.findAll().stream().map(Group::getName).toList();
    }

    public List<ProductDTO> getProductsByGroup(Long id){
        return productRepository.getProductsByGroup(id).stream().map(product ->
                productMapper.toDTO(product)
        ).toList();
    }
    public OrderDTO createOrder(OrderDTO order, Long id){
        Order newOrder = new Order( order.getComment(), new Date(),BaseStatus.ACTIVE,
                order.getItems().stream().map(item ->
                        new OrderItem(item.getCount(),productResolver.resolve(item.getProductId(),Product.class))
                ).collect(Collectors.toSet()));

        User user = userRepository.findById(id).orElseThrow();
        user.addOrder(newOrder);
        userRepository.save(user);

        return orderMapper.toDTO(newOrder);
    }
}
