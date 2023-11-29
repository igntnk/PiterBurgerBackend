package Application.Services;

import Application.DataBase.Entities.Auth.Roles;
import Application.DataBase.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Application.DataBase.Entities.BaseStatus;

import java.util.stream.Stream;

@Service
public class WorkerService {
    @Autowired
    OrderRepository orderRepository;

    public void setStatusCooking(Long task_id){orderRepository.findById(task_id).ifPresent(task -> task.setStatus(BaseStatus.COOKING)); }

    public void setStatusCooked(Long task_id){orderRepository.findById(task_id).ifPresent(task -> task.setStatus(BaseStatus.COOKED));}

    public void setStatusServing(Long task_id){orderRepository.findById(task_id).ifPresent(task -> task.setStatus(BaseStatus.SERVING));}

    public void setStatusServed(Long task_id){orderRepository.findById(task_id).ifPresent(task -> task.setStatus(BaseStatus.SERVED));}
}
