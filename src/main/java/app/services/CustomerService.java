package app.services;

import app.db.Entities.Auth.BaseRole;
import app.db.Entities.Auth.Credential;
import app.db.Entities.Auth.Roles;
import app.db.Repository.*;
import app.dto.*;
import app.exceptions.EmailIsInUseExeption;
import app.messages.Response;
import app.db.Entities.User;
import app.mappers.*;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class CustomerService {

    GroupRepository groupRepository;
    GroupListMapper groupListMapper;

    ProductRepository productRepository;
    ProductMapper productMapper;
    ProductListMapper productListMapper;

    UserRepository userRepository;
    UserMapper userMapper;

    OrderRepository orderRepository;
    OrderMapper orderMapper;
    OrderListMapper orderListMapper;

    CredentialRepository credentialRepository;

    RolesRepository rolesRepository;

    public List<GroupDTO> getAllGroups(){
        return groupListMapper.toDTOlist(groupRepository.findAll());
    }

    public Page<ProductDTO> getProductsByGroups(Long id,int page,int size,String filter){
        return productRepository.getProductsByGroup(PageRequest.of(page,size),id,filter).map(el->productMapper.toDTO(el));
    }

    public int getPrice(List<OrderItemDTO> items){
        return items.stream().mapToInt(item->item.getProduct().getPrice()*item.getCount()).sum();
    }

    public Response getMyName(String email){
        return new Response(userRepository.getUserByEmail(email).getFIO());
    }

    public Response setName(String email, String name){
        User refer = userRepository.getUserByEmail(email);
        refer.setFIO(name);
        userRepository.save(refer);
        return new Response(name);
    }

    public List<OrderDTO> getHistoryOrders(String email){
        return orderListMapper.toDTOList(orderRepository.getHistory(email));
    }

    public List<OrderDTO> getActiveOrders(String email){
        return orderListMapper.toDTOList(orderRepository.getActiveOrders(email));
    }

    public UserDTO registrateUser(String email, String password){
        if(credentialRepository.getCredByEmail(email) != null){
            throw new EmailIsInUseExeption("Email " + email + " is already in use");
        }

        User user = new User("Без Имени");
        Credential cred = new Credential(true,email,password,rolesRepository.findById(4L).orElseThrow());
        user.setCredential(cred);
        return userMapper.toDTO(userRepository.save(user));
    }

}
