package Application.Services;

import Application.DataBase.Entities.BaseStatus;
import Application.DataBase.Repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {

    TaskRepository taskRepository;

    public void setStatus(Long task_id,String status){
        taskRepository.findById(task_id).ifPresent(task -> task.setStatus(BaseStatus.valueOf(status)));
    }

    public void removeOrder(Long task_id){
        taskRepository.deleteById(task_id);
    }
}
