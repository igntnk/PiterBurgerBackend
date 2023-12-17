package app.services;

import app.dto.CreateUserDTO;
import app.dto.UserDTO;
import app.db.Entities.Auth.BaseRole;
import app.db.Entities.Auth.Credential;
import app.db.Entities.Auth.Roles;
import app.db.Entities.User;
import app.db.Repository.UserRepository;
import app.mappers.UserListMapper;
import app.mappers.UserMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
@AllArgsConstructor
public class AdminService {

    UserRepository userRepository;
    UserMapper userMapper;
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
