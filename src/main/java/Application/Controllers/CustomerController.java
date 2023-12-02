package Application.Controllers;

import Application.DTO.CredentialDTO;
import Application.DTO.UserDTO;
import Application.DataBase.Entities.Auth.Credential;
import Application.DataBase.Entities.User;
import Application.DataBase.Repository.UserRepository;
import Application.Services.CustomerService;
import Application.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

}
