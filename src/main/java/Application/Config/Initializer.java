package Application.Config;

import Application.DataBase.Entities.*;
import Application.DataBase.Entities.Auth.BaseRole;
import Application.DataBase.Entities.Auth.Credential;
import Application.DataBase.Entities.Auth.Roles;
import Application.DataBase.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Initializer implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AdressRepository adressRepository;
    @Autowired
    BandRepository bandRepository;
    @Autowired
    CredentialRepository credentialRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    RolesRepository rolesRepository;
    @Autowired
    TaskItemRepository taskItemRepository;
    @Autowired
    TaskRepository taskRepository;
    @Override
    public void run(String... args) throws Exception {
        User user1 = new User("Ignatenko Ilya Dmitrievich");
        User user2 = new User("Pushkin Alexandr Sergeevich");
        User user3 = new User("Tolstoy Lev Nikolaevich");
        User user4 = new User("Shakespeare William");

        user1.setCredential(new Credential(true,"ignatik@vk.com","12345", Stream.of(
                new Roles(BaseRole.SUPER_USER),new Roles(BaseRole.CUSTOMER)).collect(Collectors.toSet())));
        user2.setCredential(new Credential(true,"pushok@vk.com","12345",Stream.of(
                new Roles(BaseRole.MANAGER),new Roles(BaseRole.CUSTOMER)).collect(Collectors.toSet())));
        user3.setCredential(new Credential(true,"tolstik@vk.com","12345",Stream.of(
                new Roles(BaseRole.WORKER),new Roles(BaseRole.CUSTOMER)).collect(Collectors.toSet())));
        user4.setCredential(new Credential(true,"shaker@vk.com","12345",Stream.of(
                new Roles(BaseRole.CUSTOMER),new Roles(BaseRole.CUSTOMER)).collect(Collectors.toSet())));

        user1.setAdress(Stream.of(new Adress(true,"Lizukova 47"),
                new Adress(false,"Krestianina 6a")).
                collect(Collectors.toSet()));
        user2.setAdress(Stream.of(new Adress(true,"Koltsovskaya 3")).
                collect(Collectors.toSet()));
        user3.setAdress(Stream.of(new Adress(true,"Kutsugina 44"),
                new Adress(false,"Kirova 129")).
                collect(Collectors.toSet()));
        user4.setAdress(Stream.of(new Adress(true,"Lizukova 46")).
                collect(Collectors.toSet()));


        Product p1 = new Product("Чизбургер","Классический гамбургер с добавлением сыра",69, true);
        Product p2 = new Product("Гамбургер","Булка, мясо, лук, кетчуп, горчица",59, true);
        Product p3 = new Product("Гранд","Классический чизбургер, но котлета с четверть фута",169, true);

        Product p4 = new Product("Кола","Классическая сладкая кола",89, true);
        Product p5 = new Product("Фанта","Газированный напиток со вкусом апельсина",89, true);

        Product p6 = new Product("Картошка фри","Порезанный палочками картофель с солью",99, true);
        Product p7 = new Product("Картошка по-деревенски","Порезанный дольками картофель с приправами",119, true);
        Product p8 = new Product("Наггетсы","Маленькие кусочки курицы в хрустящей панировке",89, true);
        Product p9 = new Product("Стрипсы","Длинные кусочки курицы в панировке с травами",99, true);

        Product p10 = new Product("Пирожок вишневый","Хрустящий пирожок с вишневым джемом",119, true);
        Product p11 = new Product("Пирожок абрикосовый","Хрустящий пирожок с абрикосовым джемом",89, true);
        Product p12 = new Product("Шоколадный торт","Длинные кусочки курицы в панировке с травами",99, true);

        Product p13 = new Product("Горячий шоколад","Хрустящий пирожок с вишневым джемом",119, true);

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13));

        Band b1 = new Band("Бургеры");
        b1.setProducts(Stream.of(p1,p2,p3).collect(Collectors.toSet()));
        Band b2 = new Band("Напитки");
        b2.setProducts(Stream.of(p4,p5,p13).collect(Collectors.toSet()));
        Band b3 = new Band("Десерты");
        b3.setProducts(Stream.of(p10,p11,p12).collect(Collectors.toSet()));
        Band b4 = new Band("Кафе");
        b4.setProducts(Stream.of(p13,p12).collect(Collectors.toSet()));
        Band b5 = new Band("Снэки");
        b5.setProducts(Stream.of(p6,p7,p8,p9).collect(Collectors.toSet()));

        bandRepository.saveAll(Arrays.asList(b1,b2,b3,b4,b5));

        Task t1 = new Task("Удачи", new Date(),BaseStatus.ACTIVE,
                Stream.of(new TaskItem(2,p1),new TaskItem(1,p3),new TaskItem(2,p2)).collect(Collectors.toSet()));
        Task t2 = new Task("Удачи", new Date(),BaseStatus.ACTIVE,
                Stream.of(new TaskItem(1,p13),new TaskItem(1,p2)).collect(Collectors.toSet()));
        Task t3 = new Task("Удачи", new Date(),BaseStatus.ACTIVE,
                Stream.of(new TaskItem(28,p2)).collect(Collectors.toSet()));
        Task t4 = new Task("Удачи", new Date(),BaseStatus.ACTIVE,
                Stream.of(new TaskItem(144,p1),new TaskItem(1,p5)).collect(Collectors.toSet()));
        Task t5 = new Task("Удачи", new Date(),BaseStatus.ACTIVE,
                Stream.of(new TaskItem(22,p3),new TaskItem(12,p1)).collect(Collectors.toSet()));

        user1.setTasks(Stream.of(t1,t2).collect(Collectors.toSet()));
        user2.setTasks(Stream.of(t3).collect(Collectors.toSet()));
        user3.setTasks(Stream.of(t4).collect(Collectors.toSet()));
        user4.setTasks(Stream.of(t5).collect(Collectors.toSet()));

        userRepository.saveAll(Arrays.asList(user1,user2,user3,user4));
    }
}
