package app.services;

import app.dto.OrderDTO;
import app.db.Repository.OrderRepository;
import app.mappers.OrderListMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WorkerService {

    OrderRepository orderRepository;
    OrderListMapper orderListMapper;

    public List<OrderDTO> getWorkerOrders(){
        return orderListMapper.toDTOList(orderRepository.getWorkerOrders());
    }

}
