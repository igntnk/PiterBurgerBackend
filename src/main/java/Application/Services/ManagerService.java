package Application.Services;

import Application.DTO.OrderDTO;
import Application.DataBase.Entities.BaseStatus;
import Application.DataBase.Repository.OrderRepository;
import Application.Mappers.OrderListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderListMapper orderListMapper;

    public List<OrderDTO> getManagerOrders(){
        return orderListMapper.toDTOList(orderRepository.getManagerOrders());
    }

    public List<OrderDTO> getUndoneOrders(){
        return orderListMapper.toDTOList(orderRepository.getUndoneOrders());
    }
}
