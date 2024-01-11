package app.services;

import app.db.Entities.Product;
import app.db.Repository.CredentialRepository;
import app.db.Repository.OrderRepository;
import app.db.Repository.ProductRepository;
import app.dto.CreateUserDTO;
import app.dto.ProductDTO;
import app.dto.UserDTO;
import app.db.Entities.Auth.BaseRole;
import app.db.Entities.Auth.Credential;
import app.db.Entities.Auth.Roles;
import app.db.Entities.User;
import app.db.Repository.UserRepository;
import app.mappers.ProductMapper;
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

    CredentialRepository credentialRepository;

    OrderRepository orderRepository;

    ProductRepository productRepository;
    ProductMapper productMapper;

    public UserDTO createUser(CreateUserDTO dto){
        User user = new User(dto.getFio());
        Credential credential = new Credential(true,dto.getEmail(), dto.getPassword(),new Roles(BaseRole.valueOf(dto.getRole())));
        user.setCredential(credential);
        return userMapper.toDTO(userRepository.save(user));
    }

    public List<UserDTO> getAllWorkers(){
        return userListMapper.toDTOList(userRepository.getAllEnabledUsers());
    }

    public Long deleteWorker(Long id){
        credentialRepository.disableUserById(id);
        orderRepository.deleteUserOrders(id);
        return id;
    }
}
