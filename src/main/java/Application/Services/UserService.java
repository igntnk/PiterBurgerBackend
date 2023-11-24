package Application.Services;

import Application.DataBase.Entities.Task;
import Application.DataBase.Repository.AdressRepository;
import Application.DataBase.Repository.TaskItemRepository;
import Application.DataBase.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskItemRepository taskItemRepository;

    @Autowired
    private AdressRepository adressRepository;

    public List<Task> getTasks(Long id){
        return taskRepository.getOrdersByDays(id,7);
    }
}
