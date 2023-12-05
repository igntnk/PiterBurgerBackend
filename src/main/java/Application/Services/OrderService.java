package Application.Services;

import Application.DTO.OrderDTO;
import Application.DataBase.Entities.Auth.Roles;
import Application.DataBase.Entities.Order;
import Application.DataBase.Repository.OrderRepository;
import Application.Mappers.OrderListMapper;
import Application.Mappers.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Application.DataBase.Entities.BaseStatus;

import java.util.List;
import java.util.stream.Stream;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderMapper orderMapper;

    public OrderDTO setStatusCooking(Long order_id){
        Order order = orderRepository.findById(order_id).orElseThrow();
        order.setStatus(BaseStatus.COOKING);
        return orderMapper.toDTO(orderRepository.save(order));
    }

    public OrderDTO setStatusCooked(Long order_id){
        Order order = orderRepository.findById(order_id).orElseThrow();
        order.setStatus(BaseStatus.COOKED);
        return orderMapper.toDTO(orderRepository.save(order));
    }

    public OrderDTO setStatusServing(Long order_id){
        Order order = orderRepository.findById(order_id).orElseThrow();
        order.setStatus(BaseStatus.SERVING);
        return orderMapper.toDTO(orderRepository.save(order));
    }

    public OrderDTO setStatusServed(Long order_id){
        Order order = orderRepository.findById(order_id).orElseThrow();
        order.setStatus(BaseStatus.SERVED);
        return orderMapper.toDTO(orderRepository.save(order));
    }

    public OrderDTO setStatusFreeze(Long order_id){
        Order order = orderRepository.findById(order_id).orElseThrow();
        order.setStatus(BaseStatus.FREEZE);
        return orderMapper.toDTO(orderRepository.save(order));
    }

    public OrderDTO setStatusActive(Long order_id){
        Order order = orderRepository.findById(order_id).orElseThrow();
        order.setStatus(BaseStatus.ACTIVE);
        return orderMapper.toDTO(orderRepository.save(order));
    }

    public void deleteOrder(Long id){
        orderRepository.deleteById(id);
    }

}
