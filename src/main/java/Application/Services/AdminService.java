package Application.Services;

import Application.DTO.CreateUserDTO;
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
import Application.Mappers.UserListMapper;
import Application.Mappers.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
public class AdminService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserListMapper userListMapper;

    public UserDTO createUser(CreateUserDTO dto){
        User user = new User(dto.getFIO());
        Credential credential = new Credential(true,dto.getEmail(), dto.getPassword(),
                Stream.of(new Roles(BaseRole.valueOf(dto.getRole()))).collect(Collectors.toSet()));
        user.setCredential(credential);
        return userMapper.toDTO(userRepository.save(user));
    }

    public List<UserDTO> getAllWorkers(){
        return userListMapper.toDTOList(userRepository.findAll());
    }

    public void deleteWorker(Long id){
        userRepository.deleteById(id);
    }
}
