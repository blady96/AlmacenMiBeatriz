package com.belili.controller;

import com.belili.model.Model_queries;
import com.belili.model.Model_user;
import com.belili.view.View_createUser;
import com.belili.view.View_login;
import com.belili.view.View_main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Controller_user implements ActionListener {

    private final Model_user model_user;
    private final Model_queries model_login;
    private final View_login view_login;
    private final View_main view_main;
    private final View_createUser view_createUser;

    public Controller_user(Model_user model_user, Model_queries model_login, View_login view_login,
            View_main view_main, View_createUser view_createUser) {
        this.model_user = model_user;
        this.model_login = model_login;
        this.view_login = view_login;
        this.view_main = view_main;
        this.view_createUser = view_createUser;
        this.view_login.btn_connect.addActionListener(this);
        this.view_main.btn_main_createUser.addActionListener(this);
        this.view_createUser.btn_recorder_register.addActionListener(this);
        this.view_main.btn_main_update.addActionListener(this);
    }

    public void iniciar() {

        view_login.setTitle("Almacen");
        view_login.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == view_login.btn_connect) {

            model_user.setUsername_user(view_login.txt_username.getText());
            model_user.setPassword_user(view_login.txt_password.getText());

            System.err.println("usuario = " + view_login.txt_username.getText());
            System.err.println("clave = " + view_login.txt_password.getText());

            if (model_login.search_user(model_user)) {

                view_login.setVisible(false);
                view_main.setVisible(true);
                view_main.setTitle("Pagina Principal");
                view_main.setLocationRelativeTo(null);

            } else {
                JOptionPane.showMessageDialog(null, "No inicio sesion");
                cleanMain();
            }

        } else if (e.getSource() == view_main.btn_main_createUser) {

            view_login.setVisible(false);
            view_main.setVisible(false);
            view_createUser.setVisible(true);
            //view_createUser.setExtendedState(MAXIMIZED_BOTH);
            view_createUser.setTitle("Creando Registrador");
            view_createUser.setLocationRelativeTo(null);

        } else if (e.getSource() == view_createUser.btn_recorder_register) {

            String cbx_userType = (String) view_createUser.cbx_userType.getSelectedItem();
            String txt_userFullname = view_createUser.txt_userFullname.getText();
            String txt_userCorreo = view_createUser.txt_userCorreo.getText();
            String txt_userUsername = view_createUser.txt_userUsername.getText();
            String txt_userPassword = view_createUser.txt_userPassword.getText();
            String txt_userRepassword = view_createUser.txt_userRepassword.getText();

            if (txt_userFullname.isEmpty() || txt_userCorreo.isEmpty()
                    || txt_userUsername.isEmpty() || txt_userPassword.isEmpty()
                    || txt_userRepassword.isEmpty()) {

                JOptionPane.showMessageDialog(null, "Rellene los campos por favor..!");

            } else {

                if (txt_userPassword.equals(txt_userRepassword)) {

                    model_user.setType_user(cbx_userType);
                    model_user.setUsername_user(txt_userUsername);
                    model_user.setPassword_user(txt_userPassword);
                    model_user.setCorreo_user(txt_userCorreo);
                    model_user.setFullname_user(txt_userFullname);

                    if (model_login.create_user(model_user)) {

                        JOptionPane.showMessageDialog(null, "Usuario Registrado");

                        view_login.setVisible(false);
                        view_createUser.setVisible(false);
                        cleanCreateUser();
                        view_main.setVisible(true);

                    } else {
                        JOptionPane.showMessageDialog(null, "No se ha registrador este usuario");
                        cleanCreateUser();
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Las claves no coinciden");
                }
            }
        }
    }

    private void cleanMain() {

        view_login.txt_username.setText(null);
        view_login.txt_password.setText(null);
    }

    private void cleanCreateUser() {

        view_createUser.cbx_userType.setSelectedIndex(0);
        view_createUser.txt_userCorreo.setText(null);
        view_createUser.txt_userUsername.setText(null);
        view_createUser.txt_userPassword.setText(null);
        view_createUser.txt_userRepassword.setText(null);
        view_createUser.txt_userFullname.setText(null);
    }
}
