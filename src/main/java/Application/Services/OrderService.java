package Application.Services;

import Application.DTO.OrderDTO;
import Application.DataBase.Entities.Auth.Roles;
import Application.DataBase.Entities.Order;
import Application.DataBase.Entities.OrderItem;
import Application.DataBase.Entities.Product;
import Application.DataBase.Repository.OrderRepository;
import Application.DataBase.Repository.ProductRepository;
import Application.DataBase.Repository.UserRepository;
import Application.Mappers.OrderListMapper;
import Application.Mappers.OrderMapper;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Application.DataBase.Entities.BaseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderListMapper orderListMapper;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;



    public OrderDTO setStatusCooking(Long id){
        Order order = orderRepository.findById(id).orElseThrow();
        order.setStatus(BaseStatus.COOKING);
        order.setOnCookingDate(new Date());
        return orderMapper.toDTO(orderRepository.save(order));
    }

    public OrderDTO setStatusCooked(Long id){
        Order order = orderRepository.findById(id).orElseThrow();
        order.setStatus(BaseStatus.COOKED);
        return orderMapper.toDTO(orderRepository.save(order));
    }

    public OrderDTO setStatusServing(Long id){
        Order order = orderRepository.findById(id).orElseThrow();
        order.setStatus(BaseStatus.SERVING);
        order.setOnServeDate(new Date());
        return orderMapper.toDTO(orderRepository.save(order));
    }

    public OrderDTO setStatusServed(Long id){
        Order order = orderRepository.findById(id).orElseThrow();
        order.setStatus(BaseStatus.SERVED);
        return orderMapper.toDTO(orderRepository.save(order));
    }

    public OrderDTO setStatusFreeze(Long id){
        Order order = orderRepository.findById(id).orElseThrow();
        order.setStatus(BaseStatus.FREEZE);
        return orderMapper.toDTO(orderRepository.save(order));
    }

    public OrderDTO setStatusActive(Long id){
        Order order = orderRepository.findById(id).orElseThrow();
        order.setStatus(BaseStatus.ACTIVE);
        return orderMapper.toDTO(orderRepository.save(order));
    }

    public OrderDTO setDoneStatus(Long id){
        Order order = orderRepository.findById(id).orElseThrow();
        order.setStatus(BaseStatus.DONE);
        order.setDoneDate(new Date());
        return orderMapper.toDTO(orderRepository.save(order));
    }

    public void deleteOrder(Long id){
        orderRepository.deleteById(id);
    }

    public OrderDTO createOrder(OrderDTO orderRef, String email){
        List<Product> allProducts = productRepository.findAll();

        //todo try mapstruct
        Order order = orderMapper.toEntity(orderRef);

//        Order order = new Order(
//                orderRef.getComment(),
//                OffsetDateTime.now(),
//                BaseStatus.ACTIVE,
//                orderRef.getItems().stream().map(el->
//                                new OrderItem(
//                                        el.getCount()
//                                        ,
//                                        //todo !
//                                        allProducts.get(Math.toIntExact(el.getProduct().getId())-1)
//                                ))
//                        .collect(Collectors.toSet())
//        );
        order.setUser(userRepository.getUserByEmail(email));
        return orderMapper.toDTO(orderRepository.save(order));
    }

    public List<OrderDTO> getActiveOrders(){
        return orderListMapper.toDTOList(orderRepository.getAllActiveOrder());
    }

}
