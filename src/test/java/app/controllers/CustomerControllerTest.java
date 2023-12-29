package app.controllers;

import app.dto.GroupDTO;
import app.dto.OrderDTO;
import app.dto.OrderItemDTO;
import app.dto.ProductDTO;
import app.messages.Response;
import app.services.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes ={CustomerController.class})
@WebMvcTest(CustomerController.class)
@WithMockUser(username = "ignatik@vk.com")
@Tag("Unit")
class CustomerControllerTest {
    @MockBean
    private CustomerService customerService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void allWorkers() throws Exception{
        GroupDTO group = new GroupDTO(2L,"Бургеры");
        mockMvc.perform(get("/api/customer/groups"))
                .andExpect(status().isOk());
        verify(customerService,times(1)).getAllGroups();
    }

    @Test
    void getMyName() throws Exception{
        Response myName = new Response("Игнат");
        when(customerService.getMyName("ignatik@vk.com")).thenReturn(myName);
        mockMvc.perform(get("/api/customer/name"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Игнат"));
    }

    @Test
    void getHistory() throws Exception{
        List<OrderDTO> orders = Stream.of(new OrderDTO("Lucky","ACTIVE",
                Stream.of(new OrderItemDTO(2,new ProductDTO(2L,"Бургер","Вкусный","/api/src",200,true)))
                        .collect(Collectors.toList()))).toList();
        when(customerService.getHistoryOrders("ignatik@vk.com")).thenReturn(orders);
        mockMvc.perform(get("/api/customer/history"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].comment").value("Lucky"))
                .andExpect(jsonPath("$[0].status").value("ACTIVE"))
                .andExpect(jsonPath("$[0].items[0].count").value(2))
                .andExpect(jsonPath("$[0].items[0].product.id").value(2))
                .andExpect(jsonPath("$[0].items[0].product.name").value("Бургер"))
                .andExpect(jsonPath("$[0].items[0].product.description").value("Вкусный"))
                .andExpect(jsonPath("$[0].items[0].product.photo").value("/api/src"))
                .andExpect(jsonPath("$[0].items[0].product.price").value(200))
                .andExpect(jsonPath("$[0].items[0].product.enabled").value(true));
    }
}
