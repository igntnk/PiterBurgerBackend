package Application.Services;

import Application.DTO.BandDTO;
import Application.DTO.TaskDTO;
import Application.DTO.TaskItemDTO;
import Application.DTO.UserDTO;
import Application.DataBase.Entities.*;
import Application.DataBase.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

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

    public Task createTask(Set<TaskItemDTO> productDTOSet, UserDTO userRef){
        Set<TaskItem> productSet = new HashSet<>();
        productDTOSet.stream().map(el -> productSet.add(new TaskItem(el.getCount(),productRepository.findById(el.getProduct()).get())));

        return new Task("",new Date(),BaseStatus.ACTIVE,userRepository.findById(userRef.getId()).get(),productSet);
    }

    public Task cancelTask(TaskDTO referTask){
        Task taskToChange = taskRepository.findById(referTask.getId()).get();
        taskToChange.setStatus(BaseStatus.CANCELED);

        return taskRepository.save(taskToChange);
    }

    public List<Product> getProductsByGroup(BandDTO referBand){

        return productRepository.getProductsByGroup(referBand.getId());
    }
}
