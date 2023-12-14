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


        Product p1 = new Product("Чизбургер","Классический гамбургер с добавлением сыра",69, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/953/xehowq236w4i413o6cevmxdnoi0uo5iv/large.png");
        Product p2 = new Product("Чикенбургер","Бургер с салатом мелкой нарезки, куриной котлетой и фирменным соусом",65, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/d28/860yi5qf8grpa2ion4eerl6nggtnj2wb/large.png");
        Product p3 = new Product("Гамбургер","Булка, мясо, лук, кетчуп, горчица",59, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/55a/o39ugkm9yke23wciwl4hsr6q2sypv11n/large.png");
        Product p4 = new Product("Гранд","Классический чизбургер, но котлета с четверть фута",169, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/75b/vj8e05unkti5o1tauu2l037nerf3ejos/large.png");
        Product p5 = new Product("Гранд де Люкс","Гранд с добавлением салата и помидора",199, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/d31/49shs9takk1enffx4acc6p1ss0qq2e96/large.png");
        Product p6 = new Product("Чикет Хит","Чикенбургер размером с Гранд",129, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/a6f/bi9mpc87q5c284z438prbz5clq9bs857/large.png");
        Product p7 = new Product("Чикен Премьер","Чикен Хит с добавлением кетчупа, помидора, бекона",189, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/399/rcrahic86gvdateldvpul16wwqid9sho/large.png");
        Product p8 = new Product("Биг Чикен Бургер","Самый большой куриный бургер",289, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/c87/aeg80u25c8fdbk3hyj1a8eobw5dzsfma/large.png");
        Product p9 = new Product("Биг Спешиал","Самый большой бургер с говядиной",329, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/84c/6jha37d0sgyqhbmgz2axuxac7y8e3ezj/large.png");
        Product p10 = new Product("Монблан","Альпийский сливочный вкус соуса и сырная котлета",269, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/6ef/owph2ziw7kn3jw6brmqrv4ko4ux8zb2r/large.png");

        Product p11 = new Product("Кола","Классическая сладкая кола",89, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/d40/o0qg5wo0ai7n6cx2y0fus07or1jtowi1/large.png");
        Product p12 = new Product("Фанта","Газированный напиток со вкусом апельсина",89, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/79e/clgxaopzdl6ojuphh464acp738vcug8l/large.png");
        Product p13 = new Product("Спрайт","Газированный напиток со вкусом лимона",89, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/340/ln6dovpxde1hj3k18e1055jt4nj9rvdz/large.png");
        Product p14 = new Product("Липтон лимонный","Холодный чай с лимоном",89, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/377/y9dgsrtjg61uvwewvfcvpqzwcg2lpb07/large.png");
        Product p15 = new Product("Липтон зеленый","Холодный зеленый чай",89, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/f02/5swmpjs0k8sd48yq8ai7jfpc37r3m2kg/large.png");
        Product p16 = new Product("Капучино","Классический капучино из кофейных зерен",99, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/d6e/a82t3i9u3fgal10hb5u0z19a3941fjp4/large.png");
        Product p17 = new Product("Латтэ","Классический латтэ из кофейных зерен",99, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/cf9/cdsvzj6wt6kt70lmwed7db0afsbhoutq/large.png");
        Product p18 = new Product("Американо","Классический американо из кофейных зерен",79, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/d45/vqalmu0p0door13o006wpy9hs942wifg/large.png");
        Product p19 = new Product("Апельсиновый сок","Восстановленный апельсиновый сок",99, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/7b7/fm6tv9x90n3e5axu8j1zxpdw01hbp38s/large.png");
        Product p20 = new Product("Яблочный сок","Восстановленый яблочный сок",99, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/7a8/1gr4wvj0igsrahsxy59gwbd0nsozo7yu/large.png");
        Product p21 = new Product("Апельсиновый пунш","Сезонный горячий напиток с апельсиново-ягодным вкусом",109, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/27b/egq2fpgu7fjgpi6q0yddtk3769f3uqjd/large.png");
        Product p22 = new Product("Молочный коктейль","Классический густой холодный молочный коктейль",119, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/e0d/wgn2ee9d3zoyidgj9iyih038i1qzraj1/large.png");

        Product p23 = new Product("Картошка фри","Порезанный палочками картофель с солью",99, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/1df/7zmn6glfu5ouie5w94biplrzx5xxzay7/large.png");
        Product p24 = new Product("Картошка по-деревенски","Порезанный дольками картофель с приправами",119, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/826/2iqxak3sju7ve831hkhx44q0tacod1ra/large.png");
        Product p25 = new Product("Наггетсы","Маленькие кусочки курицы в хрустящей панировке",89, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/349/cfb2pmyxh3kstydwrml4zdb5p10y3ikg/large.png");
        Product p26 = new Product("Стрипсы","Длинные кусочки курицы в панировке с травами",99, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/432/r79n1s0g9fnxe5s51p8gpzsi0cp3i2os/large.png");
        Product p27 = new Product("Куриные крылья","Острые куриные крылышки в панировке",109, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/64e/4e1y0dwd30604k5rt3f8hoxtq8gsn3ok/large.png");
        Product p28 = new Product("Сырные кольца","Сыр в форме колец в панировке",129, true, "https://vkusnoitochka.ru/resize/290x286/upload/iblock/56e/8j7mmkf5mlfihwbp36y0pd93h1ne3box/large.png");
        Product p29 = new Product("Креветки","Очищенные креветки в панировке",189, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/b16/v5h90xgk1rf4cabrmqbovd8nwcbvg13l/large.png");

        Product p30 = new Product("Пирожок вишневый","Хрустящий пирожок с вишневым джемом",119, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/4d4/62rtsp10w5qr10bt4zowilz7hhfjlfu5/large.png");
        Product p31 = new Product("Пирожок с ягодами","Хрустящий пирожок с ягодным джемом",89, true, "https://vkusnoitochka.ru/resize/290x286/upload/iblock/da4/iqsqpeylwm3dvdo3d9dp6ie9zeuhzblx/large.png");
        Product p32 = new Product("Мороженое","Сливочное мороженое",99, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/805/d4pm2ulyng47scuu48i1cioomz0a3y21/large.png");
        Product p33 = new Product("Флури","Больше сливочного мороженого с шоколадной крошкой",149, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/724/gnj4ypgwn5054io82exh21p5dofrdlh0/large.png");
        Product p34 = new Product("Шоколадный торт","Торт с шоколадным кремом",199, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/c22/fbp3xjrxu4obif6pfyn4deqlq060h3q3/large.png");
        Product p35 = new Product("Лимонный торт","Торт с лимонным кремом и апельсиновой цедрой",199, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/874/51fvf8bevt71988bndx9uuvlz4k9yo2j/large.png");
        Product p36 = new Product("Грушевый торт","Хрустящие коржи и крем с кусочками груши",199, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/372/afha340edot607ij1zmv3vmjtd61mnl3/large.png");
        Product p37 = new Product("Клубничный чизкейк","Классичиский чизкейк с добавлением клубники",185, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/399/4dd6rmfp143st3gkbfxhw3u7j2l2h46v/large.png");
        Product p38 = new Product("Классический чизкей","Хрустящая основка с сливочным сыром",185, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/6eb/1caxoti1wbhoius3a71ird8v9wxq16s4/large.png");
        Product p39 = new Product("Макаруны","Классические макаруны",109, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/e14/n0vkwkflhzuxs7le366zlmew3cawr5lc/large.png");
        Product p40 = new Product("Круасан","Свежеиспеченный круасан с вишневым джемом",129, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/b61/l5f5h5hbe8l8475tywnu78rpbjs4g7z4/large.png");

        Product p41 = new Product("Горячий шоколад","Какао со всбитыми сливками",139, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/aaa/ptkbfv1k3us8zvdqkptgkij107gp3f3c/large.png");
        Product p42 = new Product("Фраппе клубничный","Дробленный лед со сливками, молоком, и клубничным джемом",189, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/46c/n73670x80pt2474ph38k8n226q6yf6b8/large.png");
        Product p43 = new Product("Фраппе карамельный","Дробленный лед со сливками, молоком, и карамельном джемом",189, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/b7b/5objx34nufc5htf3is54enc4tg63srjv/large.png");
        Product p44 = new Product("Капучино на кокосовой основе","Классический капучино с кокосовым молоком",159, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/c4e/d2odzr52y2dmn7l0c7yhea2cb50c07cw/large.png");
        Product p45 = new Product("Латтэ на кокосовой основе","Классический латтэ с кокосовым молоком",159, true,"https://vkusnoitochka.ru/resize/163x156/upload/iblock/0e8/fkedzuqd6x45y6taal4aqimv0753ulji/large.png");

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

        user1.setOrders(Stream.of(t1,t2).collect(Collectors.toSet()));
        user2.setOrders(Stream.of(t3).collect(Collectors.toSet()));
        user3.setOrders(Stream.of(t4,t6).collect(Collectors.toSet()));
        user4.setOrders(Stream.of(t5).collect(Collectors.toSet()));

        userRepository.saveAll(Arrays.asList(user1,user2,user3,user4));
    }
}
