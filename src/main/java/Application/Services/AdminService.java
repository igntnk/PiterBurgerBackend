package Application.Services;

import Application.DTO.UserDTO;
import Application.DataBase.Entities.Auth.BaseRole;
import Application.DataBase.Entities.Auth.Credential;
import Application.DataBase.Entities.Auth.Roles;
import Application.DataBase.Entities.BaseStatus;
import Application.DataBase.Entities.User;
import Application.DataBase.Repository.CredentialRepository;
import Application.DataBase.Repository.OrderRepository;
import Application.DataBase.Repository.RolesRepository;
import Application.DataBase.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
public class AdminService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CredentialRepository credentialRepository;

    @Autowired
    RolesRepository rolesRepository;

    public void setStatus(Long task_id,String status){
        orderRepository.findById(task_id).ifPresent(task -> task.setStatus(BaseStatus.valueOf(status)));
    }

    public void removeOrder(Long task_id){
        orderRepository.deleteById(task_id);
    }

    public void createUser(UserDTO userRef, Roles role)
    {
        User newUser = new User(userRef.getFIO());
        Credential newUserCredential = new Credential(true,userRef.getEmail(),"12345",
                Stream.of(new Roles(BaseRole.CUSTOMER),role).collect(Collectors.toSet()));
        newUser.setCredential(newUserCredential);
        userRepository.save(newUser);
    }

    public void changeUserInfo(User user){
        userRepository.save(user);
    }

    public void changeUserRole(Long user_id, Roles role){
        User changeUser = userRepository.findById(user_id).orElse(null);
        assert changeUser != null;

        changeUser.getCredential().setRoles(Stream.of(new Roles(BaseRole.CUSTOMER), role).collect(Collectors.toSet()));
        userRepository.save(changeUser);
    }

    public void removeUser(Long user_id){
        userRepository.deleteById(user_id);
    }
}
