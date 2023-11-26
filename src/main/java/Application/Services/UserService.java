package Application.Services;

import Application.DataBase.Entities.BaseStatus;
import Application.DataBase.Entities.Task;
import Application.DataBase.Entities.User;
import Application.DataBase.Repository.AdressRepository;
import Application.DataBase.Repository.TaskItemRepository;
import Application.DataBase.Repository.TaskRepository;
import Application.DataBase.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Task> getTasks(Long id){
        return taskRepository.getOrdersByDays(id,7);
    }

    public Optional<User> getMe(Long id) {
        return userRepository.findById(id);
    }

    public Task getCurrentTask(Long id){
       Optional<Task> task= taskRepository.findById(id);
       BaseStatus  status = task.get().getStatus();
       if(status.equals(BaseStatus.ACTIVE) ||
               status.equals(BaseStatus.COOKING) ||
               status.equals(BaseStatus.COOKED) ||
               status.equals(BaseStatus.DONE) ||
               status.equals(BaseStatus.SERVED) ||
               status.equals(BaseStatus.SERVING)){
           return task.get();
       }
        return new Task();
    }
}
