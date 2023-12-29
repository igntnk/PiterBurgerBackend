package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.context.annotation.FilterType.CUSTOM;


@SpringBootApplication
@EnableWebMvc
public class BurgerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BurgerApplication.class, args);
	}

}
