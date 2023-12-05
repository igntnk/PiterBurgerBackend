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
public class WorkerService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderListMapper orderListMapper;

    public List<OrderDTO> getKitchenOrders(){
        return orderListMapper.toDTOList(orderRepository.getKitchenOrders());
    }

    public List<OrderDTO> getCounterOrders(){
        return orderListMapper.toDTOList(orderRepository.getCounterOrders());
    }
}
