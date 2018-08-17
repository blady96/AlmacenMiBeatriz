package com.belili.test;

import com.belili.dao.UserDAO;
import com.belili.dao.impl.UserDAOImpl;
import com.belili.pojo.User;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserTest {

    User user;

    public UserTest() {
    }

//    @BeforeClass
//    public static void setUpClass() {
//
//        System.out.println("USER -- setUpClass()");
//    }
//
//    @Before
//    public void setUp() {
//
//        System.out.println("setUp()");
//    }
//
    @Test
    public void testList() {

        System.out.println("testList()");
        UserDAO userDAO = new UserDAOImpl();
        List<User> users = userDAO.selectAll();
        for (User user : users) {
            System.out.println("USER --> " + user.toString());
        }
        System.out.println("TOTAL OF USERS " + users.size());
    }

    @Test
    public void testSelectById() {

        System.out.println("testSelectById()");
        int id = 1;
        UserDAO daoSelected = new UserDAOImpl();
        user = daoSelected.selectById(id);
        System.out.println("USER WITH THE ID '" + id + "' --> " + user.toString());
    }
//    @Test
//    public void testSelectByCode() {
//
//        System.out.println("testSelectByCode()");
//        UserDAO daoSelected = new UserDAOImpl();
//        user = new User();
//        String code = "MBR0009";
//        user.setCodeUser(code);
//        if(daoSelected.selectByCode(user)){
//            user.toString();
//        }else{
//            System.err.println("ERROR AL BUSCAR");
//        }
//    }
//    @Test
//    public void testLogin() {
//
//        System.out.println("testLogin()");
//        String codeTest = "codeTest";
//        String passwordTest = "test";
//        User userTest = new User();
//        userTest.setCodeUser(codeTest);
//        userTest.setPasswordUser(passwordTest);
//        UserDAO userDAO = new UserDAOImpl();
//        if (userDAO.login(userTest)) {
//            System.out.println("LOGIN SUCCESSFULLY (USER)");
////            Assert.assertEquals("updated user", userTest.getFullnameUser());
////            Assert.assertEquals("test@junit.java", userTest.getCorreoUser());
////            Assert.assertEquals("987654321", userTest.getPhoneUser());
//        } else {
//            System.out.println("LOGIN INCORRECT (USER)");
//        }
//        System.out.println("LOGIN OF USER ==> " + userTest.toString());
//    }
//    @Test
//    public void testCreate() {
//
//        UserDAO userDAO = new UserDAOImpl();
//        user = new User("codeTest", "test", "Senor Test", "test@hotmail.com","987654321","987654321",null,true,true,true,true,true);
//        userDAO.createTest(user);
//        System.out.println("USER CREATE ==> " + user.toString());
//        testList();
//    }
//    @Test
//    public void testUpdate() {
//
//        System.out.println("testUpdate()");
//        int id = 6;
//        UserDAO userDAO = new UserDAOImpl();
//        user = userDAO.selectById(id);
//        String passwordTest = "test";
//        String passwordHashTest = DigestUtils.sha1Hex(passwordTest);
//        user.setPasswordUser(passwordHashTest);
//        userDAO.update(user);
//        //Assert.assertEquals(false, user.isStateUser());
//        System.out.println("UPDATED USER");
//        testList();
//    }
//    @Test
//    public void testDisable() {
//
//        System.out.println("testDisable()");
//        int id = 1;
//        UserDAO userDAO = new UserDAOImpl();
//        user = userDAO.selectById(id);
//        user.setStateUser(false);
//        //Generate Date
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//        /*   SET SUSPENSION DEADLINE   */
//        String d = "2018-08-08";
//        /* ------------------------------ */
//        
//        Date date = null;
//        try {
//            date = simpleDateFormat.parse(d);
//            long dateLong = date.getTime();
//            java.sql.Date dateSQL = new java.sql.Date(dateLong);
//        } catch (ParseException ex) {
//            Logger.getLogger(UserTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        user.setDateUser(date);
//        System.out.println("USER TO DISABLED --> " + user.toString());
//        userDAO.update(user);
//        System.out.println("USER DISABLED");
//        //testList();
//    }
//
//    @Test
//    public void testEnable() {
//
//        System.out.println("testDisable()");
//        int id = 2;
//        UserDAO userDAO = new UserDAOImpl();
//        user = userDAO.selectById(id);
//        user.setStateUser(true);
//        user.setDateUser(null);
//        System.out.println("USER TO ENABLED --> " + user.toString());
//        userDAO.update(user);
//        System.out.println("USER ENABLED");
//        testList();
//    }
//    @Test
//    public void testDate() {
//        
//        java.util.Date fecha = new Date();
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        System.out.println("Fecha1: "+dateFormat.format(fecha));
//        long dateLong = fecha.getTime();
//        java.sql.Date d = new java.sql.Date(dateLong);
//
//        
//        //SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
//        DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
//        java.util.Date fecha2 = null;
//        java.sql.Date d2 = null;
//        try {
//            fecha2 = dateFormat2.parse("2018-08-07");
//            System.out.println("Fecha2: "+dateFormat2.format(fecha2));
//            long dateLong2 = fecha2.getTime();
//            d2 = new java.sql.Date(dateLong2);
//        } catch (ParseException ex) {
//            Logger.getLogger(UserTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
////        java.util.Date date2 = null;
////        java.sql.Date d2 = null;
////        try {
////            date2 = simpledateFormat2.parse("2018-08-07");
////            long dateLong2 = date2.getTime();
////            d2 = new java.sql.Date(dateLong2);
////
////        } catch (ParseException ex) {
////            Logger.getLogger(UserTest.class.getName()).log(Level.SEVERE, null, ex);
////        }
////        System.out.println("COMPARISON ==> " + d.compareTo(date2));
////        System.out.println("DATE TODAY ==> " + d);
////        System.out.println("DATE OF OTHER DAY ==> " + d2);
//        System.out.println("Fecha1 SQL ==> " + d);
//        System.out.println("Fecha2 SQL ==> " + d2);
//        System.out.println("COMPARISON ==> " + dateFormat.format(fecha).compareTo(dateFormat2.format(fecha2)));
//        System.out.println("COMPARISON SQL ==> " + d.compareTo(d2));
//    }
//    @Test
//    public void generatePasswordTest() {
//
//        String[] symbols = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
//        int length = 10;
//        Random random = null;
//        try {
//            random = SecureRandom.getInstanceStrong(); // as of JDK 8, this should return the strongest algorithm available to the JVM
//        } catch (NoSuchAlgorithmException ex) {
//            Logger.getLogger(UserTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        StringBuilder sb = new StringBuilder(length);
//        for (int i = 0; i < length; i++) {
//            int indexRandom = random.nextInt(symbols.length);
//            sb.append(symbols[indexRandom]);
//        }
//        String password = sb.toString();
//        System.out.println("PASSWORD GENERATE --> " + password);
//    }
//
//    @After
//    public void tearDown() {
//
//        System.out.println("tearDown()");
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//
//        System.out.println("USER -- tearDownClass()");
//    }
}
