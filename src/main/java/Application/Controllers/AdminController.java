package Application.Controllers;

import Application.Controllers.ControllerAdvice.ExceptionResponse;
import Application.DTO.CreateUserDTO;
import Application.DTO.UserDTO;
import Application.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping(path = "create")
    public UserDTO createUser(@RequestBody CreateUserDTO dto){
        return adminService.createUser(dto);
    }

    @DeleteMapping(path = "delete")
    public ResponseEntity<ExceptionResponse> deleteWorker(@RequestParam Long id){
        adminService.deleteWorker(id);
        ExceptionResponse response = new ExceptionResponse("User with id " + id + " deleted" , null, new Date());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "workers")
    public List<UserDTO> getAllWorkers(){
        return adminService.getAllWorkers();
    }

}
