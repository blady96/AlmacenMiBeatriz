package com.belili.test;

import com.belili.dao.AdministratorDAO;
import com.belili.dao.impl.AdministratorDAOImpl;
import com.belili.pojo.Administrator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AdministratorTest {
    
    Administrator administrator;
    
//    public AdministratorTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
    
//    @Test
//    public void testLogin() {
//
//        System.out.println("testLogin()");
//        String usernameTest = "admin";
//        String passwordTest = "admin";
//        Administrator administratorTest = new Administrator();
//        administratorTest.setUsernameAdministrator(usernameTest);
//        administratorTest.setPasswordAdministrator(passwordTest);
//        AdministratorDAO administratorDAO = new AdministratorDAOImpl();
//        if (administratorDAO.login(administratorTest)) {
//            System.out.println("LOGIN SUCCESSFULLY (USER)");
////            Assert.assertEquals("updated user", userTest.getFullnameUser());
////            Assert.assertEquals("test@junit.java", userTest.getCorreoUser());
////            Assert.assertEquals("987654321", userTest.getPhoneUser());
//        } else {
//            System.out.println("LOGIN INCORRECT (USER)");
//        }
//        System.out.println("LOGIN OF USER ==> " + administratorTest.toString());
//    }
    
//    @Test
//    public void testUpdate() {
//
//        System.out.println("testUpdate()");
//        int id = 1;
//        AdministratorDAO administratorDAO = new AdministratorDAOImpl();
//        administrator = administratorDAO.selectById(id);
//        String passwordTest = "admin";
//        administrator.setPasswordAdministrator(passwordTest);
//        administratorDAO.update(administrator);
//        System.out.println("UPDATED USER");
//    }
}
