package Application.Services;

import Application.DTO.OrderDTO;
import Application.DataBase.Entities.BaseStatus;
import Application.DataBase.Repository.OrderRepository;
import Application.Mappers.OrderListMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ManagerService {

    OrderRepository orderRepository;
    OrderListMapper orderListMapper;

    public List<OrderDTO> getManagerOrders(){
        return orderListMapper.toDTOList(orderRepository.getManagerOrders());
    }

    public List<OrderDTO> getUndoneOrders(){
        return orderListMapper.toDTOList(orderRepository.getUndoneOrders());
    }
}
