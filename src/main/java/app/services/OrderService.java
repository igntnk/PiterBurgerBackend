package app.services;

import app.dto.OrderDTO;
import app.dto.small.SmallOrderDTO;
import app.db.Entities.Order;
import app.db.Entities.Product;
import app.db.Repository.OrderRepository;
import app.db.Repository.ProductRepository;
import app.db.Repository.UserRepository;
import app.mappers.OrderListMapper;
import app.mappers.OrderMapper;
import app.mappers.SmallOrderMapper;
import app.db.Entities.BaseStatus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    OrderRepository orderRepository;
    OrderMapper orderMapper;
    OrderListMapper orderListMapper;
    SmallOrderMapper smallOrderMapper;

    UserRepository userRepository;

    ProductRepository productRepository;

    public OrderDTO setStatusCooking(Long id){
        Order order = orderRepository.findById(id).orElseThrow();
        order.setStatus(BaseStatus.COOKING);
        order.setOnCookingDate(OffsetDateTime.now());
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
        order.setOnServeDate(OffsetDateTime.now());
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
        order.setDoneDate(OffsetDateTime.now());
        return orderMapper.toDTO(orderRepository.save(order));
    }

    public void deleteOrder(Long id){
        orderRepository.deleteById(id);
    }

    public SmallOrderDTO createOrder(SmallOrderDTO orderRef, String email){
        List<Product> allProducts = productRepository.findAll();

        Order order = smallOrderMapper.toEntity(orderRef);

        order.setUser(userRepository.getUserByEmail(email));
        return smallOrderMapper.toDTO(orderRepository.save(order));
    }

    public List<OrderDTO> getActiveOrders(){
        return orderListMapper.toDTOList(orderRepository.getAllActiveOrder());
    }

}
