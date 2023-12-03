package Application.Services;

import Application.DTO.*;
import Application.DataBase.Entities.*;
import Application.DataBase.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<Order> getTasks(Long id){
        return orderRepository.getOrdersByDays(id,7);
    }

    public Optional<User> getMe(Long id) {
        return userRepository.findById(id);
    }

    public Order getCurrentTask(Long id){
       Optional<Order> task= orderRepository.findById(id);
       BaseStatus  status = task.get().getStatus();
       if(status.equals(BaseStatus.ACTIVE) ||
               status.equals(BaseStatus.COOKING) ||
               status.equals(BaseStatus.COOKED) ||
               status.equals(BaseStatus.DONE) ||
               status.equals(BaseStatus.SERVED) ||
               status.equals(BaseStatus.SERVING)){
           return task.get();
       }
        return new Order();
    }

    public void createTask(Set<OrderItemDTO> productDTOSet, UserDTO userRef){
        Set<OrderItem> productSet = new HashSet<>();
        productDTOSet.stream().map(el -> productSet.add(new OrderItem(el.getCount(),productRepository.findById(el.getProductId()).orElse(null))));

        Order createdTask = new Order("",new Date(),BaseStatus.ACTIVE,productSet);
        Optional<User> userToAddTaskOpt = userRepository.findById(userRef.getId());
        if(userToAddTaskOpt.isEmpty()){
            throw new NoSuchElementException("User with " + userRef.getId() + " id not found");
        }
        User userToAddTask = userToAddTaskOpt.get();
        userToAddTask.addTask(createdTask);

        userRepository.save(userToAddTask);
    }


}
