package app.controllers;

import app.dto.OrderDTO;
import app.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/worker")
public class WorkerController {
    @Autowired
    WorkerService workerService;

    @GetMapping(path = "orders", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDTO> getKitchenOrders(){
        return workerService.getWorkerOrders();
    }


}
