package app.services;

import app.db.Entities.OrderItem;
import app.db.Repository.OrderItemRepository;
import app.db.Repository.OrderRepository;
import app.dto.*;
import app.dto.small.SmallOrderDTO;
import app.dto.small.SmallOrderItemDTO;
import app.dto.small.SmallProductDTO;
import app.exceptions.IllegalCnagingOrderStatusException;
import app.exceptions.NoSuchUserException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Tag("Integration")
@ActiveProfiles("test")
@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BurgerApplicationTest {

    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
            "postgres:15-alpine"
    );

    @Autowired
    AdminService adminService;

    @Autowired
    OrderService orderService;


    @DynamicPropertySource
    static void postgresProperties(DynamicPropertyRegistry registry){
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
        registry.add("spring.datasource.driver-class-name", postgres::getDriverClassName);
    }

    @BeforeAll
    static void beforeAll() {
        postgres.start();
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
    }


    @Test
    @Order(1)
    public void changeStatuses() throws IllegalCnagingOrderStatusException {
        assertDoesNotThrow(()->orderService.setNextStatus(1L));

        assertDoesNotThrow(()->orderService.setStatusActive(1L));

        assertDoesNotThrow(()->{
            List<OrderDTO> orders = orderService.getManagerOrders();
            orders.forEach(element-> orderService.setStatusFreeze(element.getId()));
        });


    }

    @Test
    @Order(2)
    public void getOrdersByDifferentRolesTest() throws IllegalCnagingOrderStatusException {

        assertNotNull(orderService.getManagerOrders());

        assertEquals(orderService.getWorkerOrders(),new ArrayList<>());

        assertDoesNotThrow(()->{
            List<OrderDTO> orders = orderService.getManagerOrders();
            orders.forEach(element-> orderService.setStatusActive(element.getId()));
        });
    }

    @Test
    @Order(3)
    public void createOrderTest() throws NoSuchUserException {

        OrderDTO order = orderService.createOrder(new SmallOrderDTO("Lucky",List.of(new SmallOrderItemDTO(2,new SmallProductDTO(2L)))),"ignatik@vk.com");
        assertEquals(
                order,orderService.getOrderByID(order.getId()));

    }
}
