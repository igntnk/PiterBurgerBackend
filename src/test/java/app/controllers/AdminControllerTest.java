package app.controllers;

import app.db.Entities.User;
import app.dto.CreateUserDTO;
import app.dto.GroupDTO;
import app.dto.UserDTO;
import app.messages.Response;
import app.services.AdminService;
import app.services.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes ={AdminController.class})
@WebMvcTest(AdminController.class)
@AutoConfigureMockMvc(addFilters = false)
@Tag("Unit")
class AdminControllerTest {
    @MockBean
    private AdminService adminService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getMyName() throws Exception{
        List<UserDTO> users = Stream.of(new UserDTO(2L,"Ignat","SUPER_USER",null)).toList();
        when(adminService.getAllWorkers()).thenReturn(users);
        mockMvc.perform(get("/api/admin/workers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(2))
                .andExpect(jsonPath("$[0].status").value("SUPER_USER"))
                .andExpect(jsonPath("$[0].fio").value("Ignat"));
    }

    @Test
    void createUser() throws Exception{
        CreateUserDTO user = new CreateUserDTO("Ignat","ignatik@vk.com","12345","SUPER_USER");
        String userJson = objectMapper.writeValueAsString(user);
        mockMvc.perform(post("/api/admin/create")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(userJson))
                .andExpect(status().isOk());
        verify(adminService, times(1)).createUser(user);
    }

}
