package app.services;

import app.db.Entities.*;
import app.db.Entities.Auth.Credential;
import app.db.Repository.*;
import app.dto.OrderDTO;
import app.dto.OrderItemDTO;
import app.dto.ProductDTO;
import app.dto.small.SmallOrderDTO;
import app.exceptions.IllegalCnagingOrderStatusException;
import app.exceptions.NoSuchOrderException;
import app.exceptions.NoSuchUserException;
import app.mappers.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.function.Supplier;

@Service
@AllArgsConstructor
public class OrderService {

    OrderRepository orderRepository;
    OrderMapper orderMapper;
    OrderListMapper orderListMapper;
    SmallOrderMapper smallOrderMapper;

    OrderItemRepository orderItemRepository;
    SmallOrderItemListMapper smallOrderItemListMapper;

    UserRepository userRepository;
    UserMapper userMapper;

    ProductRepository productRepository;

    CredentialRepository credentialRepository;


    public OrderDTO setNextStatus(Long id) throws IllegalCnagingOrderStatusException{
        Order order = orderRepository.findById(id).orElseThrow();
        switch (order.getStatus()){
            case ACTIVE -> order.setStatus(BaseStatus.COOKING);
            case COOKING -> order.setStatus(BaseStatus.COOKED);
            case COOKED -> order.setStatus(BaseStatus.SERVING);
            case SERVING -> order.setStatus(BaseStatus.SERVED);
            case SERVED -> order.setStatus(BaseStatus.DONE);
            case DONE -> throw new IllegalCnagingOrderStatusException("Done is the last status");
        }
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

    public void deleteOrder(Long id){
        orderRepository.deleteById(id);
    }

    @Transactional
    public OrderDTO createOrder(SmallOrderDTO orderRef, String email) {
        List<Product> allProducts = productRepository.findAll();

        Order order = smallOrderMapper.toEntity(orderRef);
        User user = userRepository.getUserByEmail(email);
        if(user == null){
            throw new NoSuchUserException("User with this email not found");
        }
        order.setUser(user);

        return orderMapper.toDTO(orderRepository.findById(orderRepository.save(order).getId()).orElseThrow());
    }

    public List<OrderDTO> getWorkerOrders(){
        return orderListMapper.toDTOList(orderRepository.getWorkerOrders());
    }

    public List<OrderDTO> getManagerOrders(){
        return orderListMapper.toDTOList(orderRepository.getManagerOrders());
    }

    public OrderDTO getOrderByID(Long id){
        return orderMapper.toDTO(orderRepository.findById(id).orElseThrow());
    }

}
