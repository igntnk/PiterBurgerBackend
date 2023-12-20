package app.config;

import app.db.Entities.*;
import app.db.Entities.Auth.BaseRole;
import app.db.Entities.Auth.Credential;
import app.db.Entities.Auth.Roles;
import app.db.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.Arrays;
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
        User user1 = new User("Илья");
        User user2 = new User("Саша");
        User user3 = new User("Лева");
        User user4 = new User("Витек");

        user1.setCredential(new Credential(true,"ignatik@vk.com","12345", Stream.of(
                new Roles(BaseRole.SUPER_USER)).collect(Collectors.toSet())));
        user2.setCredential(new Credential(true,"pushok@vk.com","12345",Stream.of(
                new Roles(BaseRole.MANAGER)).collect(Collectors.toSet())));
        user3.setCredential(new Credential(true,"tolstik@vk.com","12345",Stream.of(
                new Roles(BaseRole.WORKER)).collect(Collectors.toSet())));
        user4.setCredential(new Credential(true,"shaker@vk.com","12345",Stream.of(
                new Roles(BaseRole.CUSTOMER)).collect(Collectors.toSet())));

        user1.setAdress(Stream.of(new Address(true,"Lizukova 47"),
                new Address(false,"Krestianina 6a")).
                collect(Collectors.toSet()));
        user2.setAdress(Stream.of(new Address(true,"Koltsovskaya 3")).
                collect(Collectors.toSet()));
        user3.setAdress(Stream.of(new Address(true,"Kutsugina 44"),
                new Address(false,"Kirova 129")).
                collect(Collectors.toSet()));
        user4.setAdress(Stream.of(new Address(true,"Lizukova 46")).
                collect(Collectors.toSet()));


        Product p1 = new Product("Чизбургер","Классический гамбургер с добавлением сыра",69, true,
                "http://25.1.95.26:8080/api/file/src/cheez.png");
        Product p2 = new Product("Чикенбургер","Бургер с салатом мелкой нарезки, куриной котлетой и фирменным соусом",65, true,
                "http://25.1.95.26:8080/api/file/src/burger.png");
        Product p3 = new Product("Гамбургер","Булка, мясо, лук, кетчуп, горчица",59, true,
                "http://25.1.95.26:8080/api/file/src/gam.png");
        Product p4 = new Product("Гранд","Классический чизбургер, но котлета с четверть фута",169, true,
                "http://25.1.95.26:8080/api/file/src/grand.png");
        Product p5 = new Product("Гранд де Люкс","Гранд с добавлением салата и помидора",199, true,
                "http://25.1.95.26:8080/api/file/src/lux.png");
        Product p6 = new Product("Чикет Хит","Чикенбургер размером с Гранд",129, true,
                "http://25.1.95.26:8080/api/file/src/chikenhit.png");
        Product p7 = new Product("Чикен Премьер","Чикен Хит с добавлением кетчупа, помидора, бекона",189, true,
                "http://25.1.95.26:8080/api/file/src/premier.png");
        Product p8 = new Product("Биг Чикен Бургер","Самый большой куриный бургер",289, true,
                "http://25.1.95.26:8080/api/file/src/bigburger.png");
        Product p9 = new Product("Биг Спешиал","Самый большой бургер с говядиной",329, true,
                "http://25.1.95.26:8080/api/file/src/speshial.png");
        Product p10 = new Product("Монблан","Альпийский сливочный вкус соуса и сырная котлета",269, true,
                "http://25.1.95.26:8080/api/file/src/monblan.png");

        Product p11 = new Product("Кола","Классическая сладкая кола",89, true,
                "http://25.1.95.26:8080/api/file/src/cola.png");
        Product p12 = new Product("Фанта","Газированный напиток со вкусом апельсина",89, true,
                "http://25.1.95.26:8080/api/file/src/fanta.png");
        Product p13 = new Product("Спрайт","Газированный напиток со вкусом лимона",89, true,
                "http://25.1.95.26:8080/api/file/src/sprite.png");
        Product p14 = new Product("Липтон лимонный","Холодный чай с лимоном",89, true,
                "http://25.1.95.26:8080/api/file/src/liptonlim.png");
        Product p15 = new Product("Липтон зеленый","Холодный зеленый чай",89, true,
                "http://25.1.95.26:8080/api/file/src/liptonzel.png");
        Product p16 = new Product("Капучино","Классический капучино из кофейных зерен",99, true,
                "http://25.1.95.26:8080/api/file/src/capuch.png");
        Product p17 = new Product("Латтэ","Классический латтэ из кофейных зерен",99, true,
                "http://25.1.95.26:8080/api/file/src/late.png");
        Product p18 = new Product("Американо","Классический американо из кофейных зерен",79, true,
                "http://25.1.95.26:8080/api/file/src/americano.png");
        Product p19 = new Product("Апельсиновый сок","Восстановленный апельсиновый сок",99, true,
                "http://25.1.95.26:8080/api/file/src/orange.png");
        Product p20 = new Product("Яблочный сок","Восстановленый яблочный сок",99, true,
                "http://25.1.95.26:8080/api/file/src/apple.png");
        Product p21 = new Product("Апельсиновый пунш","Сезонный горячий напиток с апельсиново-ягодным вкусом",109, true,
                "http://25.1.95.26:8080/api/file/src/punsh.png");
        Product p22 = new Product("Молочный коктейль","Классический густой холодный молочный коктейль",119, true,
                "http://25.1.95.26:8080/api/file/src/coocktail.png");

        Product p23 = new Product("Картошка фри","Порезанный палочками картофель с солью",99, true,
                "http://25.1.95.26:8080/api/file/src/fri.png");
        Product p24 = new Product("Картошка по-деревенски","Порезанный дольками картофель с приправами",119, true,
                "http://25.1.95.26:8080/api/file/src/derevnya.png");
        Product p25 = new Product("Наггетсы","Маленькие кусочки курицы в хрустящей панировке",89, true,
                "http://25.1.95.26:8080/api/file/src/nuggets.png");
        Product p26 = new Product("Стрипсы","Длинные кусочки курицы в панировке с травами",99, true,
                "http://25.1.95.26:8080/api/file/src/strips.png");
        Product p27 = new Product("Куриные крылья","Острые куриные крылышки в панировке",109, true,
                "http://25.1.95.26:8080/api/file/src/wings.png");
        Product p28 = new Product("Сырные кольца","Сыр в форме колец в панировке",129, true,
                "http://25.1.95.26:8080/api/file/src/rings.png");
        Product p29 = new Product("Креветки","Очищенные креветки в панировке",189, true,
                "http://25.1.95.26:8080/api/file/src/krevetki.png");

        Product p30 = new Product("Пирожок вишневый","Хрустящий пирожок с вишневым джемом",119, true,
                "http://25.1.95.26:8080/api/file/src/cherry.png");
        Product p31 = new Product("Пирожок с ягодами","Хрустящий пирожок с ягодным джемом",89, true,
                "http://25.1.95.26:8080/api/file/src/berry.png");
        Product p32 = new Product("Мороженое","Сливочное мороженое",99, true,
                "http://25.1.95.26:8080/api/file/src/icecream.png");
        Product p33 = new Product("Флури","Больше сливочного мороженого с шоколадной крошкой",149, true,
                "http://25.1.95.26:8080/api/file/src/flurry.png");
        Product p34 = new Product("Шоколадный торт","Торт с шоколадным кремом",199, true,
                "http://25.1.95.26:8080/api/file/src/chokocake.png");
        Product p35 = new Product("Лимонный торт","Торт с лимонным кремом и апельсиновой цедрой",199, true,
                "http://25.1.95.26:8080/api/file/src/limon.png");
        Product p36 = new Product("Грушевый торт","Хрустящие коржи и крем с кусочками груши",199, true,
                "http://25.1.95.26:8080/api/file/src/pear.png");
        Product p37 = new Product("Клубничный чизкейк","Классичиский чизкейк с добавлением клубники",185, true,
                "http://25.1.95.26:8080/api/file/src/cheezecakeklub.png");
        Product p38 = new Product("Классический чизкей","Хрустящая основка с сливочным сыром",185, true,
                "http://25.1.95.26:8080/api/file/src/cheezecakeclass.png");
        Product p39 = new Product("Макаруны","Классические макаруны",109, true,
                "http://25.1.95.26:8080/api/file/src/makaruni.png");
        Product p40 = new Product("Круасан","Свежеиспеченный круасан с вишневым джемом",129, true,
                "http://25.1.95.26:8080/api/file/src/crossaint.png");

        Product p41 = new Product("Горячий шоколад","Какао со всбитыми сливками",139, true,
                "http://25.1.95.26:8080/api/file/src/hotchocolate.png");
        Product p42 = new Product("Фраппе клубничный","Дробленный лед со сливками, молоком, и клубничным джемом",189, true,
                "http://25.1.95.26:8080/api/file/src/frappeklub.png");
        Product p43 = new Product("Фраппе карамельный","Дробленный лед со сливками, молоком, и карамельном джемом",189, true,
                "http://25.1.95.26:8080/api/file/src/frappekar.png");
        Product p44 = new Product("Капучино - кокос","Классический капучино с кокосовым молоком",159, true,
                "http://25.1.95.26:8080/api/file/src/cococapuch.png");
        Product p45 = new Product("Латтэ - кокос","Классический латтэ с кокосовым молоком",159, true,
                "http://25.1.95.26:8080/api/file/src/cocolatte.png");

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
        g6.setProducts(Stream.of(p2,p6,p7,p8).collect(Collectors.toSet()));
        Group g7 = new Group("Говядина");
        g7.setProducts(Stream.of(p1,p3,p4,p5,p9,p10).collect(Collectors.toSet()));
        Group g8 = new Group("Новинки");
        g8.setProducts(Stream.of(p10,p28,p31,p21).collect(Collectors.toSet()));
        Group g9 = new Group("Все продукты");
        g9.setProducts(Stream.of(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,
                p14,p15,p16,p17,p18,p19,p20,p21,p22,p23,p24,p25,p26,
                p27,p28,p29,p30,p31,p32,p33,p34,p35,p36,p37,p38,p39,
                p40,p41,p42,p43,p44,p45).collect(Collectors.toSet()));

        groupRepository.saveAll(Arrays.asList(g1,g2,g3,g4,g5,g6,g7,g8,g9));

        Order t1 = new Order("Горячее и холодное раздельно", OffsetDateTime.now(), BaseStatus.ACTIVE,
                Stream.of(new OrderItem(4,p1),new OrderItem(2,p42),new OrderItem(2,p2)).collect(Collectors.toSet()));
        Order t2 = new Order("Удачи", OffsetDateTime.now(),BaseStatus.ACTIVE,
                Stream.of(new OrderItem(1,p13),new OrderItem(1,p2)).collect(Collectors.toSet()));
        Order t3 = new Order("Аккуратно упакуйте", OffsetDateTime.now(),BaseStatus.ACTIVE,
                Stream.of(new OrderItem(28,p2)).collect(Collectors.toSet()));
        Order t4 = new Order("Кто ты такой", OffsetDateTime.now(),BaseStatus.ACTIVE,
                Stream.of(new OrderItem(144,p1),new OrderItem(1,p5)).collect(Collectors.toSet()));
        Order t5 = new Order("А вы знали что если у вас сопли...", OffsetDateTime.now(),BaseStatus.ACTIVE,
                Stream.of(new OrderItem(22,p3),new OrderItem(12,p1)).collect(Collectors.toSet()));
        Order t6 = new Order("Это значит, что домовой", OffsetDateTime.now(),BaseStatus.ACTIVE,
                Stream.of(new OrderItem(22,p3),new OrderItem(12,p1),
                        new OrderItem(3,p11),new OrderItem(4,p32)).collect(Collectors.toSet()));

        user1.setOrders(Stream.of(t1,t2).collect(Collectors.toSet()));
        user2.setOrders(Stream.of(t3).collect(Collectors.toSet()));
        user3.setOrders(Stream.of(t4,t6).collect(Collectors.toSet()));
        user4.setOrders(Stream.of(t5).collect(Collectors.toSet()));

        userRepository.saveAll(Arrays.asList(user1,user2,user3,user4));
    }
}
