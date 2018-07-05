/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belili.controller;

import com.belili.model.Model_login;
import com.belili.model.Model_user;
import com.belili.view.View_login;
import com.belili.view.View_main;
import com.sun.org.apache.xpath.internal.operations.Mod;

/**
 *
 * @author belili
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Model_user model_user = new Model_user();
        Model_login model_login = new Model_login();
        View_login view_login = new View_login();
        View_main view_main = new View_main();
        Controller_user controller_user = new Controller_user(model_user, model_login, view_login, view_main);
        controller_user.iniciar();
        view_login.setVisible(true);
        
    }
    
}
