package Application.Services;

import Application.DTO.OrderDTO;
import Application.DTO.SmallDTOs.SmallOrderDTO;
import Application.DataBase.Entities.Auth.Roles;
import Application.DataBase.Entities.Order;
import Application.DataBase.Entities.OrderItem;
import Application.DataBase.Entities.Product;
import Application.DataBase.Repository.OrderRepository;
import Application.DataBase.Repository.ProductRepository;
import Application.DataBase.Repository.UserRepository;
import Application.Mappers.OrderListMapper;
import Application.Mappers.OrderMapper;
import Application.Mappers.SmallOrderMapper;
import lombok.AllArgsConstructor;
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
