//package org.lab1.context;
//
//import org.lab1.data.entity.*;
//
//import org.lab1.data.CRUD;
//import org.lab1.web.bean.auth.UserBean;
//import org.lab1.web.bean.data.CoordinateBean;
//
//import jakarta.servlet.ServletContextEvent;
//import jakarta.servlet.ServletContextListener;
//import jakarta.servlet.annotation.WebListener;
//import java.io.IOException;
//import java.nio.charset.Charset;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.time.LocalDateTime;
//import java.util.List;
//
//@WebListener
//public class AppContextInitializer implements ServletContextListener {
//
//    private void print_db() {
//        List<BookCreature> list = CRUD.findAll(BookCreature.class);
//        System.out.println("=======");
//        for (BookCreature c : list) {
//            System.out.println(c);
//        }
//        System.out.println("=======");
//    }
//
//    static String readFile(String path, Charset encoding)
//            throws IOException
//    {
//        byte[] encoded = Files.readAllBytes(Paths.get(path));
//        return new String(encoded, encoding);
//    }
//
//    @Override
//    public void contextInitialized(ServletContextEvent sce) {
//
////        String content;
////        try {
////            content = readFile("C:\\Users\\zam12\\OneDrive\\Документы\\university\\course3\\IS\\lab1EE\\data\\sql_function.txt", StandardCharsets.UTF_8);
////            CRUD.executeScript(content);
////        } catch (IOException e) {
////            throw new RuntimeException(e);
////        }
//        if (false) {
//
//            System.out.println(new BookCreatureBean().getFieldNames());
//            System.out.println(new CoordinateBean().getFieldNames());
//            System.out.println(new MagicCityBean().getFieldNames());
//            System.out.println(new RingBean().getFieldNames());
//            Coordinates c = new Coordinates();
//
//            User admin = new User();
//            admin.setLogin("nentu");
//            admin.setPassword("nentu");
//            admin.setNick("nentu");
//            admin.setAdmin(true);
//            admin.setRequest(false);
//
//            CRUD.add(admin);
//
//            User user = new User();
//            user.setLogin("user");
//            user.setPassword("user");
//            user.setNick("user");
//            user.setRequest(false);
//            CRUD.add(user);
//
//            User userTest1 = new User();
//            userTest1.setLogin("user1");
//            userTest1.setPassword("user1");
//            userTest1.setNick("user1");
//            CRUD.add(userTest1);
//            User userTest2 = new User();
//            userTest2.setLogin("user2");
//            userTest2.setPassword("user2");
//            userTest2.setNick("user2");
//            CRUD.add(userTest2);
//
//
//            for (long x = 0; x < 4; x++) {
//                for (int y = 0; y < 3; y++) {
//                    c = new Coordinates();
//                    c.setX(x);
//                    c.setY(y);
//                    if (x % 2 == 0)
//                        c.setOwner(admin);
//                    else
//                        c.setOwner(user);
//                    CRUD.add(c);
//                }
//            }
//
//            Ring ring = new Ring();
//            for (long w = 1; w < 3; w++) {
//                ring = new Ring();
//                ring.setName("ring" + w);
//                ring.setWeight(w);
//                if (w % 2 == 1)
//                    ring.setOwner(admin);
//                else
//                    ring.setOwner(user);
//
//                CRUD.add(ring);
//                System.out.println("ring" + ring);
//            }
//
//
//            MagicCity mc = new MagicCity();
//            mc.setName("Mordor");
//            mc.setArea(12);
//            mc.setGovernor(BookCreatureType.ELF);
//            mc.setEstablishmentDate(LocalDateTime.now());
//            mc.setPopulation(4);
//            mc.setPopulationDensity(1.3f);
//            mc.setCapital(true);
//            mc.setOwner(admin);
//
//            CRUD.add(mc);
//
//            mc.setName("No Mordor");
//            mc.setArea(122);
//            mc.setGovernor(BookCreatureType.HOBBIT);
//            mc.setEstablishmentDate(LocalDateTime.now());
//            mc.setPopulation(3);
//            mc.setPopulationDensity(2.3f);
//            mc.setCapital(false);
//            mc.setOwner(user);
//
//
//            CRUD.add(mc);
//
//            BookCreature bc = new BookCreature();
//            bc.setName("bc");
//            bc.setCoordinates(c);
//            bc.setCreationDate(LocalDateTime.now());
//            bc.setAge(20);
//            bc.setCreatureType(BookCreatureType.ELF);
//            bc.setCreatureLocation(mc);
//            bc.setAttackLevel(1.34);
//            bc.setRing(ring);
//
//            bc.setOwner(admin);
//            CRUD.add(bc);
//
//
//            CRUD.findAll(BookCreature.class);
//
//            System.out.println(bc);
//
//
//            bc.setCreationDate(LocalDateTime.now());
//            bc.setAge(200);
//            bc.setCreatureType(BookCreatureType.HOBBIT);
//            CRUD.add(bc);
//            CRUD.add(bc);
//
//            System.out.println(CRUD.findBookCreatureByClassId(Ring.class, ring.getId()));
//
//
//            print_db();
//
//
//            System.out.println(CRUD.getUserByLogin("ada"));
//            System.out.println(CRUD.getUserByLogin("nentu"));
//
//            UserBean checkUser = new UserBean();
//            checkUser.setLogin("nentu");
//            checkUser.setPassword("nentu");
////            checkUser.setRequest(false);
//            System.out.println(checkUser.validateUser());
//        }
//
//
//        ServletContextListener.super.contextInitialized(sce);
//
//    }
//
//}