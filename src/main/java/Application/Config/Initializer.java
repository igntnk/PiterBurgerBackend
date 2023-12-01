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
    GroupRepository groupRepository;
    @Autowired
    CredentialRepository credentialRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    RolesRepository rolesRepository;
    @Autowired
    OrderItemRepository orderItemRepository;
    @Autowired
    OrderRepository orderRepository;
    @Override
    public void run(String... args) throws Exception {
        User user1 = new User("Ignatenko Ilya Dmitrievich");
        User user2 = new User("Pushkin Alexandr Sergeevich");
        User user3 = new User("Tolstoy Lev Nikolaevich");
        User user4 = new User("Shakespeare William");

        user1.setCredential(new Credential(true,"ignatik@vk.com","12345", Stream.of(
                new Roles(BaseRole.SUPER_USER)).collect(Collectors.toSet())));
        user2.setCredential(new Credential(true,"pushok@vk.com","12345",Stream.of(
                new Roles(BaseRole.MANAGER)).collect(Collectors.toSet())));
        user3.setCredential(new Credential(true,"tolstik@vk.com","12345",Stream.of(
                new Roles(BaseRole.WORKER)).collect(Collectors.toSet())));
        user4.setCredential(new Credential(true,"shaker@vk.com","12345",Stream.of(
                new Roles(BaseRole.CUSTOMER)).collect(Collectors.toSet())));

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
        Product p2 = new Product("Чикенбургер","Бургер с салатом мелкой нарезке, куриной котлетой и фирменным соусом",65, true);
        Product p3 = new Product("Гамбургер","Булка, мясо, лук, кетчуп, горчица",59, true);
        Product p4 = new Product("Гранд","Классический чизбургер, но котлета с четверть фута",169, true);
        Product p5 = new Product("Гранд де Люкс","Гранд с добавлением салата и помидора",199, true);
        Product p6 = new Product("Чикет Хит","Чикенбургер размером с Гранд",129, true);
        Product p7 = new Product("Чикен Премьер","Чикен Хит с добавлением кетчупа, помидора, бекона",189, true);
        Product p8 = new Product("Биг Чикен Бургер","Самый большой куриный бургер",289, true);
        Product p9 = new Product("Биг Спешиал","Самый большой бургер с говядиной",329, true);
        Product p10 = new Product("Монблан","Альпийский сливочный вкус соуса и сырная котлета",269, true);

        Product p11 = new Product("Кола","Классическая сладкая кола",89, true);
        Product p12 = new Product("Фанта","Газированный напиток со вкусом апельсина",89, true);
        Product p13 = new Product("Спрайт","Газированный напиток со вкусом лимона",89, true);
        Product p14 = new Product("Липтон лимонный","Холодный чай с лимоном",89, true);
        Product p15 = new Product("Липтон зеленый","Холодный зеленый чай",89, true);
        Product p16 = new Product("Капучино","Классический капучино из кофейных зерен",99, true);
        Product p17 = new Product("Латтэ","Классический латтэ из кофейных зерен",99, true);
        Product p18 = new Product("Американо","Классический американо из кофейных зерен",79, true);
        Product p19 = new Product("Апельсиновый сок","Восстановленный апельсиновый сок",99, true);
        Product p20 = new Product("Яблочный сок","Восстановленый яблочный сок",99, true);
        Product p21 = new Product("Апельсиновый пунш","Сезонный горячий напиток с апельсиново-ягодным вкусом",109, true);
        Product p22 = new Product("Молочный коктейль","Классический густой холодный молочный коктейль",119, true);

        Product p23 = new Product("Картошка фри","Порезанный палочками картофель с солью",99, true);
        Product p24 = new Product("Картошка по-деревенски","Порезанный дольками картофель с приправами",119, true);
        Product p25 = new Product("Наггетсы","Маленькие кусочки курицы в хрустящей панировке",89, true);
        Product p26 = new Product("Стрипсы","Длинные кусочки курицы в панировке с травами",99, true);
        Product p27 = new Product("Куриные крылья","Острые куриные крылышки в панировке",109, true);
        Product p28 = new Product("Сырные кольца","Сыр в форме колец в панировке",129, true);
        Product p29 = new Product("Креветки","Очищенные креветки в панировке",189, true);

        Product p30 = new Product("Пирожок вишневый","Хрустящий пирожок с вишневым джемом",119, true);
        Product p31 = new Product("Пирожок абрикосовый","Хрустящий пирожок с абрикосовым джемом",89, true);
        Product p32 = new Product("Мороженое","Сливочное мороженое",99, true);
        Product p33 = new Product("Флури","Больше сливочного мороженого с шоколадной крошкой",149, true);
        Product p34 = new Product("Шоколадный торт","Торт с шоколадным кремом",199, true);
        Product p35 = new Product("Лимонный торт","Торт с лимонным кремом и апельсиновой цедрой",199, true);
        Product p36 = new Product("Грушевый торт","Хрустящие коржи и крем с кусочками груши",199, true);
        Product p37 = new Product("Клубничный чизкейк","Классичиский чизкейк с добавлением клубники",185, true);
        Product p38 = new Product("Классический чизкей","Хрустящая основка с сливочным сыром",185, true);
        Product p39 = new Product("Макаруны","Классические макаруны",109, true);
        Product p40 = new Product("Круасан","Свежеиспеченный круасан с вишневым джемом",129, true);

        Product p41 = new Product("Горячий шоколад","Какао со всбитыми сливками",139, true);
        Product p42 = new Product("Фраппе клубничный","Дробленный лед со сливками, молоком, и клубничным джемом",189, true);
        Product p43 = new Product("Фраппе карамельный","Дробленный лед со сливками, молоком, и карамельном джемом",189, true);
        Product p44 = new Product("Капучино на кокосовой основе","Классический капучино с кокосовым молоком",159, true);
        Product p45 = new Product("Латтэ на кокосовой основе","Классический латтэ с кокосовым молоком",159, true);

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,
                p14,p15,p16,p17,p18,p19,p20,p21,p22,p23,p24,p25,p26,
                p27,p28,p29,p30,p31,p32,p33,p34,p35,p36,p37,p38,p39,
                p40,p41,p42,p43,p44,p45));

        Group g1 = new Group("Бургеры");
        g1.setProducts(Stream.of(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10).collect(Collectors.toSet()));
        Group g2 = new Group("Напитки");
        g2.setProducts(Stream.of(p11,p12,p13,p14,p15,p16,p17,p18,p19,p20,p21,p22).collect(Collectors.toSet()));
        Group g3 = new Group("Десерты");
        g3.setProducts(Stream.of(p30,p31,p32,p33,p34,p35,p36,p37,p38,p39,p40).collect(Collectors.toSet()));
        Group g4 = new Group("Кафе");
        g4.setProducts(Stream.of(p34,p35,p36,p37,p38,p39,p40,p41,p42,p43,p44,p45).collect(Collectors.toSet()));
        Group g5 = new Group("Снэки");
        g5.setProducts(Stream.of(p23,p24,p25,p26,p27,p28,p29).collect(Collectors.toSet()));
        Group g6 = new Group("Курица");
        g6.setProducts(Stream.of(p2,p6,p7,p8,p9).collect(Collectors.toSet()));
        Group g7 = new Group("Курица");
        g7.setProducts(Stream.of(p1,p3,p4,p5).collect(Collectors.toSet()));
        Group g8 = new Group("Сезонные новинки");
        g8.setProducts(Stream.of(p10,p28,p31,p21).collect(Collectors.toSet()));
        Group g9 = new Group("Все продукты");
        g9.setProducts(Stream.of(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,
                p14,p15,p16,p17,p18,p19,p20,p21,p22,p23,p24,p25,p26,
                p27,p28,p29,p30,p31,p32,p33,p34,p35,p36,p37,p38,p39,
                p40,p41,p42,p43,p44,p45).collect(Collectors.toSet()));

        groupRepository.saveAll(Arrays.asList(g1,g2,g3,g4,g5,g6,g7,g8,g9));

        Order t1 = new Order("Горячее и холодное раздельно", new Date(),BaseStatus.ACTIVE,
                Stream.of(new OrderItem(4,p1),new OrderItem(2,p42),new OrderItem(2,p2)).collect(Collectors.toSet()));
        Order t2 = new Order("Удачи", new Date(),BaseStatus.ACTIVE,
                Stream.of(new OrderItem(1,p13),new OrderItem(1,p2)).collect(Collectors.toSet()));
        Order t3 = new Order("Аккуратно упакуйте", new Date(),BaseStatus.ACTIVE,
                Stream.of(new OrderItem(28,p2)).collect(Collectors.toSet()));
        Order t4 = new Order("Кто ты такой", new Date(),BaseStatus.ACTIVE,
                Stream.of(new OrderItem(144,p1),new OrderItem(1,p5)).collect(Collectors.toSet()));
        Order t5 = new Order("А вы знали что если у вас сопли...", new Date(),BaseStatus.ACTIVE,
                Stream.of(new OrderItem(22,p3),new OrderItem(12,p1)).collect(Collectors.toSet()));
        Order t6 = new Order("Это значит, что домовой", new Date(),BaseStatus.ACTIVE,
                Stream.of(new OrderItem(22,p3),new OrderItem(12,p1),
                        new OrderItem(3,p11),new OrderItem(4,p32)).collect(Collectors.toSet()));

        user1.setTasks(Stream.of(t1,t2).collect(Collectors.toSet()));
        user2.setTasks(Stream.of(t3).collect(Collectors.toSet()));
        user3.setTasks(Stream.of(t4,t6).collect(Collectors.toSet()));
        user4.setTasks(Stream.of(t5).collect(Collectors.toSet()));

        userRepository.saveAll(Arrays.asList(user1,user2,user3,user4));
    }
}
