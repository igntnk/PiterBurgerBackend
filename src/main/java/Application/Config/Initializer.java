package Application.Config;

import Application.DataBase.Entities.User;
import Application.DataBase.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Initializer implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("ApplicationRunnerImpl Called");
        userRepository.save(new User("ignat"));
        userRepository.save(new User("neignat"));
    }
}
