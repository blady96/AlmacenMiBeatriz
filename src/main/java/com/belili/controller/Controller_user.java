package com.belili.controller;

import com.belili.model.Model_queries;
import com.belili.model.Model_user;
import com.belili.view.View_createUser;
import com.belili.view.View_login;
import com.belili.view.View_main;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Controller_user implements ActionListener {

    private Model_user model_user;
    private Model_queries model_login;
    private View_login view_login;
    private View_main view_main;
    private View_createUser view_createUser;

    public Controller_user(Model_user model_user, Model_queries model_login, View_login view_login,
            View_main view_main, View_createUser view_createUser) {
        this.model_user = model_user;
        this.model_login = model_login;
        this.view_login = view_login;
        this.view_main = view_main;
        this.view_createUser = view_createUser;
        this.view_login.btn_connect.addActionListener(this);
        this.view_main.btn_main_recorder_create.addActionListener(this);
        this.view_createUser.btn_recorder_register.addActionListener(this);
        this.view_main.btn_actualizar.addActionListener(this);
    }

    public void iniciar() {

        view_login.setTitle("Almacen");
        view_login.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); 

        if (e.getSource() == view_login.btn_connect) {

            model_user.setUsername_user(view_login.txt_username.getText());
            model_user.setPassword_user(view_login.txt_password.getText());

            System.err.println("usuario = " + view_login.txt_username.getText());
            System.err.println("clave = " + view_login.txt_password.getText());

            if (model_login.search_user(model_user)) {

//                JOptionPane.showMessageDialog(null, "Inicio sesion");
                view_login.setVisible(false);
                view_main.setVisible(true);
                view_main.setTitle("Pagina Principal");
                view_main.setLocationRelativeTo(null);

            } else {
                JOptionPane.showMessageDialog(null, "No inicio sesion");
                clean();
            }

        } else if (e.getSource() == view_main.btn_main_recorder_create) {

            view_login.setVisible(false);
            view_main.setVisible(false);
            view_createUser.setVisible(true);
            //view_createUser.setExtendedState(MAXIMIZED_BOTH);
            view_createUser.setTitle("Creando Registrador");
            view_createUser.setLocationRelativeTo(null);

        } else if (e.getSource() == view_createUser.btn_recorder_register) {

            String cbx_userType = (String) view_createUser.cbx_userType.getSelectedItem();
            String txt_recorder_fullname = view_createUser.txt_recorder_fullname.getText();
            String txt_recorder_correo = view_createUser.txt_recorder_correo.getText();
            String txt_recorder_username = view_createUser.txt_recorder_username.getText();
            String txt_recorder_password = view_createUser.txt_recorder_password.getText();
            String txt_recorder_repassword = view_createUser.txt_recorder_repassword.getText();

            if (txt_recorder_fullname.isEmpty() || txt_recorder_correo.isEmpty()
                    || txt_recorder_username.isEmpty() || txt_recorder_password.isEmpty()
                    || txt_recorder_repassword.isEmpty()) {

                JOptionPane.showMessageDialog(null, "Rellene los campos por favor..!");

            } else {

                if (txt_recorder_password.equals(txt_recorder_repassword)) {

                    //String txt_recorder_type_user = "Registrador";
                    model_user.setType_user(cbx_userType);
                    model_user.setUsername_user(txt_recorder_username);
                    model_user.setPassword_user(txt_recorder_password);
                    model_user.setCorreo_user(txt_recorder_correo);
                    //model_user.setType_user(txt_recorder_type_user);
                    model_user.setFullname_user(txt_recorder_fullname);

                    if (model_login.create_user(model_user)) {

                        JOptionPane.showMessageDialog(null, "Usuario Registrado");

                        view_login.setVisible(false);
                        view_createUser.setVisible(false);
                        view_createUser.cbx_userType.setSelectedIndex(0);
                        view_createUser.txt_recorder_correo.setText(null);
                        view_createUser.txt_recorder_username.setText(null);
                        view_createUser.txt_recorder_password.setText(null);
                        view_createUser.txt_recorder_repassword.setText(null);
                        view_createUser.txt_recorder_fullname.setText(null);
                        view_main.setVisible(true);
                        

                    } else {
                        JOptionPane.showMessageDialog(null, "No se ha registrador este usuario");
                    }

                } else {

                    JOptionPane.showMessageDialog(null, "Las claves no coinciden");
                }

            }

        }

//        if (e.getSource() == view_login.btn_connect) {
//
//            //model_user.setType_user(view_login.txt_typeUser.getText());
//            model_user.setUsername_user(view_login.txt_username.getText());
//            model_user.setPassword_user(view_login.txt_password.getText());
//            //model_user.setFullname_user(view_login.txt_fullname.getText());
//            //model_user.setCorreo_user(view_login.txt_correo.getText());
//            
//            if (model_login.create_user(model_user)) {
//                JOptionPane.showMessageDialog(null, "Guardado");
//                clean();
//            }else{
//                JOptionPane.showMessageDialog(null, "No guardado");
//                clean();
//            }
//
//        }
    }

    public void clean() {

        view_login.txt_username.setText(null);
        view_login.txt_password.setText(null);

    }

}
