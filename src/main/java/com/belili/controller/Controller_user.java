package com.belili.controller;

import com.belili.model.Model_image;
import com.belili.model.Model_imageMySQL;
import com.belili.model.Model_queries;
import com.belili.model.Model_user;
import com.belili.view.View_createUser;
import com.belili.view.View_login;
import com.belili.view.View_main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Controller_user implements ActionListener {

    private Model_user model_user;
    private final Model_queries model_login;
    private final View_login view_login;
    private final View_main view_main;
    private final View_createUser view_createUser;
    public static File f;
    public static FileInputStream fileInputStream;

    public Controller_user(Model_user model_user, Model_queries model_login, View_login view_login,
            View_main view_main, View_createUser view_createUser) {
        this.model_user = model_user;
        this.model_login = model_login;
        this.view_login = view_login;
        this.view_main = view_main;
        this.view_createUser = view_createUser;
        this.view_login.btn_connect.addActionListener(this);
        this.view_main.btn_main_createUser.addActionListener(this);
        this.view_main.jmi_users.addActionListener(this);
        this.view_main.jmi_profile.addActionListener(this);
        this.view_main.jmi_logout.addActionListener(this);
        this.view_createUser.btn_upload_image.addActionListener(this);
        this.view_createUser.btn_recorder_register.addActionListener(this);
        this.view_createUser.btn_createUser_cancel.addActionListener(this);
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

                Model_imageMySQL model_image = new Model_imageMySQL(view_main.jp_profile_imgUser.getHeight(),
                        view_main.jp_profile_imgUser.getWidth(), model_user.getImg_user());
                view_main.jp_profile_imgUser.add(model_image);
                view_main.jp_profile_imgUser.repaint();

                view_main.txt_profile_fullnameUser.setText(model_user.getFullname_user());
                view_main.txt_profile_typeUser.setText(model_user.getType_user());
                view_main.txt_profile_correoUser.setText(model_user.getCorreo_user());
                view_main.txt_profile_phoneUser.setText(model_user.getPhone_user());
                view_main.txt_profile_codeUser.setText(model_user.getCode_user());

                view_login.setVisible(false);
                view_main.setVisible(true);
                view_main.jp_main_profile.setVisible(false);
                view_main.jp_main_registry.setVisible(true);
                view_main.setTitle("Pagina Principal");
                view_main.setLocationRelativeTo(null);

            } else if (model_login.search_user2(model_user)) {
                view_main.txt_profile_fullnameUser.setText(model_user.getFullname_user());
                view_main.txt_profile_typeUser.setText(model_user.getType_user());
                view_main.txt_profile_correoUser.setText(model_user.getCorreo_user());
                view_main.txt_profile_phoneUser.setText(model_user.getPhone_user());
                view_main.txt_profile_codeUser.setText(model_user.getCode_user());

                view_login.setVisible(false);
                view_main.setVisible(true);
                view_main.jp_main_profile.setVisible(false);
                view_main.jp_main_registry.setVisible(true);
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
            String txt_userPhone = view_createUser.txt_userPhone.getText();

            if (txt_userFullname.isEmpty() || txt_userCorreo.isEmpty()
                    || txt_userUsername.isEmpty() || txt_userPassword.isEmpty()
                    || txt_userRepassword.isEmpty() || txt_userPhone.isEmpty()) {

                JOptionPane.showMessageDialog(null, "Rellene los campos por favor..!");

            } else {

                if (txt_userPassword.equals(txt_userRepassword)) {

                    model_user.setType_user(cbx_userType);
                    model_user.setUsername_user(txt_userUsername);
                    model_user.setPassword_user(txt_userPassword);
                    model_user.setCorreo_user(txt_userCorreo);
                    model_user.setFullname_user(txt_userFullname);
                    model_user.setPhone_user(txt_userPhone);

                    try {
                        System.out.println("f = " +f);
                        fileInputStream = new FileInputStream(f);
                    } catch (FileNotFoundException ex) {
                        //Logger.getLogger(Controller_user.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("f = " +f);
                    }

                    if (model_login.create_user(model_user, fileInputStream, f)) {

                        JOptionPane.showMessageDialog(null, "Usuario Registrado");

                        view_login.setVisible(false);
                        view_createUser.setVisible(false);
                        cleanCreateUser();
                        view_main.setVisible(true);

                    } else {
                        JOptionPane.showMessageDialog(null, "No se ha registrado este usuario");
                        cleanCreateUser();
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Las claves no coinciden");
                }
            }
        } else if (e.getSource() == view_createUser.btn_createUser_cancel) {

            view_createUser.setVisible(false);
            view_main.setVisible(true);
            cleanCreateUser();

        } else if (e.getSource() == view_createUser.btn_upload_image) {

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("png/jpg/jpeg", "png", "jpg", "jpeg");
            fileChooser.setFileFilter(filter);

            int seleccion = fileChooser.showOpenDialog(view_createUser);

            if (seleccion == JFileChooser.APPROVE_OPTION) {

                f = fileChooser.getSelectedFile();
                String ruta = f.getAbsolutePath();
                int x = view_createUser.jp_image.getWidth();
                int y = view_createUser.jp_image.getHeight();

                Model_image img = new Model_image(x, y, ruta);
                view_createUser.jp_image.add(img);
                view_createUser.jp_image.repaint();
            }

        } else if (e.getSource() == view_main.jmi_users) {

            view_main.jp_main_profile.setVisible(false);
            view_main.jp_main_registry.setVisible(true);

        } else if (e.getSource() == view_main.jmi_profile) {

            view_main.jp_main_profile.setVisible(true);
            view_main.jp_main_registry.setVisible(false);
        } else if (e.getSource() == view_main.jmi_logout) {

            int decision = JOptionPane.showConfirmDialog(null, "Desea salir de sesion?", "Sistema", JOptionPane.OK_CANCEL_OPTION);

            if (decision == JOptionPane.OK_OPTION) {
                logout();
                cleanMain();
            }
        }
    }

    private void cleanMain() {

        view_login.txt_username.setText(null);
        view_login.txt_password.setText(null);
    }

    private void cleanCreateUser() {

        view_createUser.cbx_userType.setSelectedIndex(0);
        view_createUser.jp_image.removeAll();
        view_createUser.txt_userCorreo.setText(null);
        view_createUser.txt_userUsername.setText(null);
        view_createUser.txt_userPassword.setText(null);
        view_createUser.txt_userRepassword.setText(null);
        view_createUser.txt_userFullname.setText(null);
        view_createUser.txt_userPhone.setText(null);
    }

    private void cleanObject() {

        model_user.setId_user(null);
        model_user.setCode_user(null);
        model_user.setType_user(null);
        model_user.setImg_user(null);

        System.out.println(view_main.jp_profile_imgUser.getComponentCount());
        view_main.jp_profile_imgUser.removeAll();
        System.out.println(view_main.jp_profile_imgUser.getComponentCount());

        model_user.setUsername_user(null);
        model_user.setPassword_user(null);
        model_user.setFullname_user(null);
        model_user.setCorreo_user(null);
        model_user.setPhone_user(null);

    }

    private void logout() {

        view_main.setVisible(false);
        cleanObject();
        view_login.setVisible(true);

    }
}
