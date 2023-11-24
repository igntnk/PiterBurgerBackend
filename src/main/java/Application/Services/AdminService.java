package Application.Services;

import Application.DataBase.Entities.Auth.Credential;
import Application.DataBase.Entities.Auth.Roles;
import Application.DataBase.Entities.BaseStatus;
import Application.DataBase.Entities.User;
import Application.DataBase.Repository.CredentialRepository;
import Application.DataBase.Repository.TaskRepository;
import Application.DataBase.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CredentialRepository credentialRepository;

    public void setStatus(Long task_id,String status){
        taskRepository.findById(task_id).ifPresent(task -> task.setStatus(BaseStatus.valueOf(status)));
    }

    public void removeOrder(Long task_id){
        taskRepository.deleteById(task_id);
    }

    public void createUser(User user, Credential credential, Roles roles)
    {
        userRepository.save(user);
        credentialRepository.save(credential);
    }
}
