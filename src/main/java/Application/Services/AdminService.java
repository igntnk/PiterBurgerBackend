package Application.Services;

import Application.DataBase.Entities.Auth.BaseRole;
import Application.DataBase.Entities.Auth.Credential;
import Application.DataBase.Entities.Auth.Roles;
import Application.DataBase.Entities.BaseStatus;
import Application.DataBase.Entities.User;
import Application.DataBase.Repository.CredentialRepository;
import Application.DataBase.Repository.RolesRepository;
import Application.DataBase.Repository.TaskRepository;
import Application.DataBase.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AdminService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CredentialRepository credentialRepository;

    @Autowired
    RolesRepository rolesRepository;

    public void setStatus(Long task_id,String status){
        taskRepository.findById(task_id).ifPresent(task -> task.setStatus(BaseStatus.valueOf(status)));
    }

    public void removeOrder(Long task_id){
        taskRepository.deleteById(task_id);
    }

    public void createUser(User user,Roles role)
    {
        userRepository.save(user);
        Credential newUserCredential = new Credential(true,"newUser","12345",user,
                Stream.of(new Roles(BaseRole.CUSTOMER)).collect(Collectors.toSet()));
    }

    public void changeUserInfo(User user){
        userRepository.save(user);
    }

    public void changeUserRole(Long user_id, Roles role){
        userRepository.findById(user_id).ifPresent(user -> user.getCredential().setRoles(
                Stream.of(new Roles(BaseRole.CUSTOMER),role).collect(Collectors.toSet())
        ));
    }

    public void removeUser(Long user_id){
        userRepository.deleteById(user_id);
    }
}
