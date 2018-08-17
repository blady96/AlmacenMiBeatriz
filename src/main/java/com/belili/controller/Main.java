package com.belili.controller;

import com.belili.view.View_dialog_listUser;
import com.belili.view.View_login;
import com.belili.view.View_main;
import com.belili.view.View_modulo_mantenimiento;
import com.belili.view.View_modulo_mantenimiento_user;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        }

        View_login view_login = new View_login();
        View_main view_main = new View_main();
        View_modulo_mantenimiento view_modulo_mantenimiento = new View_modulo_mantenimiento();
        View_modulo_mantenimiento_user view_modulo_mantenimiento_usuario = new View_modulo_mantenimiento_user();
        View_dialog_listUser view_dialog_listUser = new View_dialog_listUser(view_modulo_mantenimiento_usuario, true);

//        Controller_user controller_user = new Controller_user(view_login, view_main, view_modulo_mantenimiento, view_modulo_mantenimiento_usuario, view_dialog_listUser);
//        controller_user.iniciar();
//        view_login.setVisible(true);
//        view_dialog_listUser.setLocationRelativeTo(null);
//        view_dialog_listUser.setTitle("Lista de Usuarios");
        //view_login.setExtendedState(MAXIMIZED_BOTH);
        
//        LoginAndMainController loginController = new LoginAndMainController(view_login, view_main,view_modulo_mantenimiento,
//                view_modulo_mantenimiento_usuario,view_dialog_listUser);
//        loginController.iniciar();
//        view_login.setVisible(true);
        
        view_modulo_mantenimiento_usuario.setVisible(true);
        view_modulo_mantenimiento_usuario.setTitle("Usuario");
        view_modulo_mantenimiento_usuario.jp_modulo_createUser.setVisible(false);
        view_modulo_mantenimiento_usuario.jp_modulo_editUser.setVisible(false);
        view_modulo_mantenimiento_usuario.jp_modulo_lowerUser.setVisible(true);
        
    }
}
