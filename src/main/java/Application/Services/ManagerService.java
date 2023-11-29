package Application.Services;

import Application.DataBase.Entities.BaseStatus;
import Application.DataBase.Repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {

    OrderRepository orderRepository;

    public void setStatus(Long task_id,String status){
        orderRepository.findById(task_id).ifPresent(task -> task.setStatus(BaseStatus.valueOf(status)));
    }

    public void removeOrder(Long task_id){
        orderRepository.deleteById(task_id);
    }
}
