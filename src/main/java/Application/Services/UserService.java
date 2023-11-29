package Application.Services;

import Application.DTO.*;
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
    private TaskItemRepository taskItemRepository;

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

    public void createTask(Set<TaskItemDTO> productDTOSet, UserDTO userRef){
        Set<TaskItem> productSet = new HashSet<>();
        productDTOSet.stream().map(el -> productSet.add(new TaskItem(el.getCount(),productRepository.findById(el.getProductId()).orElse(null))));

        Task createdTask = new Task("",new Date(),BaseStatus.ACTIVE,productSet);
        Optional<User> userToAddTaskOpt = userRepository.findById(userRef.getId());
        if(userToAddTaskOpt.isEmpty()){
            throw new NoSuchElementException("User with " + userRef.getId() + " id not found");
        }
        User userToAddTask = userToAddTaskOpt.get();
        userToAddTask.addTask(createdTask);

        userRepository.save(userToAddTask);
    }

    public Task cancelTask(TaskDTO referTask){
        Optional<Task> taskToChangeOpt = taskRepository.findById(referTask.getId());
        if(taskToChangeOpt.isEmpty()){
            throw new NoSuchElementException("Task with " + referTask.getId() + " id not found");
        }
        Task taskToChange = taskToChangeOpt.get();
        taskToChange.setStatus(BaseStatus.CANCELED);

        return taskRepository.save(taskToChange);
    }

    public List<Product> getProductsByGroup(BandDTO referBand){

        return productRepository.getProductsByGroup(referBand.getId());
    }

    public int getBucketPrice(Set<TaskItemDTO> items){
        int resultPrice = 0;
        List<Product> productList = productRepository.findAll();

        for(TaskItemDTO it:items){
            Product localProduct = productList.stream().filter(el->el.getId().equals(it.getProductId()))
                    .findFirst().orElse(null);
            if(localProduct != null)
                resultPrice += localProduct.getPrice() * it.getCount();
        }

        return resultPrice;
    }
}
