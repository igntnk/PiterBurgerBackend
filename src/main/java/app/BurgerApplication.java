package app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
@Slf4j
public class BurgerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BurgerApplication.class, args);
	}

}
