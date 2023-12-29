package app.controllers;

import app.messages.ExceptionResponse;
import app.dto.CreateUserDTO;
import app.dto.UserDTO;
import app.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping(path = "create",produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO createUser(@RequestBody CreateUserDTO dto){
        return adminService.createUser(dto);
    }

    @MessageMapping("/delete")
    @SendTo("/order/admin")
    public Long deleteWorker(@RequestParam Long id){
        return adminService.deleteWorker(id);
    }

    @GetMapping(path = "workers")
    public List<UserDTO> getAllWorkers(){
        return adminService.getAllWorkers();
    }

}
