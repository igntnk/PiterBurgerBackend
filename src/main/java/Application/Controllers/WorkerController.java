package Application.Controllers;

import Application.DTO.OrderDTO;
import Application.Services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("api/worker")
public class WorkerController {
    @Autowired
    WorkerService workerService;

    @GetMapping(path = "kitchen", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDTO> getKitchenOrders(){
        return workerService.getKitchenOrders();
    }

    @GetMapping(path = "counter", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDTO> getCounterOrders(){
        return workerService.getCounterOrders();
    }

}
