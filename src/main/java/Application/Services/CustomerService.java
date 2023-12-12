package Application.Services;

import Application.DTO.GroupDTO;
import Application.DTO.OrderDTO;
import Application.DTO.OrderItemDTO;
import Application.DTO.ProductDTO;
import Application.DataBase.Entities.*;
import Application.DataBase.Entities.Auth.Credential;
import Application.DataBase.Repository.*;
import Application.Mappers.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CustomerService {

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    GroupListMapper groupListMapper;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductListMapper productListMapper;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderMapper orderMapper;

    public List<GroupDTO> getAllGroups(){
        return groupListMapper.toDTOlist(groupRepository.findAll());
    }

    public List<ProductDTO> getProductsByGroups(Long id){
        return productListMapper.toDTOList(productRepository.getProductsByGroup(id));
    }

    public int getPrice(List<OrderItemDTO> items){
        int resultPrice = 0;
        List<Product> products = productRepository.findAll();
        for(OrderItemDTO it:items){
            resultPrice += products.get(Math.toIntExact(it.getProductId())).
                    getPrice()*it.getCount();
        }
        return resultPrice;
    }

    public String getMyName(String email){
        return userRepository.getUserByEmail(email).getFIO();
    }



}
