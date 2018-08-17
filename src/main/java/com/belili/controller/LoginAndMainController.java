package com.belili.controller;

import com.belili.dao.UserDAO;
import com.belili.dao.impl.UserDAOImpl;
import com.belili.pojo.User;
import com.belili.view.View_dialog_listUser;
import com.belili.view.View_login;
import com.belili.view.View_main;
import com.belili.view.View_modulo_mantenimiento;
import com.belili.view.View_modulo_mantenimiento_user;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class LoginAndMainController implements ActionListener {

    //VIEWS
    private final View_login view_login;
    private final View_main view_main;
    private final View_modulo_mantenimiento view_modulo_mantenimiento;
    private final View_modulo_mantenimiento_user view_modulo_mantenimiento_usuario;
    private final View_dialog_listUser view_dialog_listUser;

    //OBJECT USER
    User user;

    public LoginAndMainController(View_login view_login, View_main view_main, View_modulo_mantenimiento view_modulo_mantenimiento,
            View_modulo_mantenimiento_user view_modulo_mantenimiento_usuario, View_dialog_listUser view_dialog_listUser) {

        //Views
        this.view_login = view_login;
        this.view_main = view_main;
        this.view_modulo_mantenimiento = view_modulo_mantenimiento;
        this.view_modulo_mantenimiento_usuario = view_modulo_mantenimiento_usuario;
        this.view_dialog_listUser = view_dialog_listUser;

        //Buttons
        this.view_login.btn_connect.addActionListener(this);

        //Menu Items
        this.view_main.menui_main_main.addActionListener(this);
        this.view_main.menui_main_perfil.addActionListener(this);
        this.view_main.menui_main_salir.addActionListener(this);
        this.view_main.menui_main_configuracion.addActionListener(this);
        this.view_main.menui_main_mantenimiento.addActionListener(this);
    }

    public void iniciar() {
        view_login.setTitle("Almacen");
        view_login.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //****************************** BUTTONS ******************************//
        //Boton Login User
        if (e.getSource() == view_login.btn_connect) {

            UserDAO userDAO = new UserDAOImpl();
            user = new User();
            user.setCodeUser(view_login.txt_username.getText());
            user.setPasswordUser(view_login.txt_password.getText());
            if (view_login.txt_username.getText().isEmpty() || view_login.txt_password.getText().isEmpty()) {
                JOptionPane.showMessageDialog(view_login, "Por favor ingrese su cuenta", "MBR", JOptionPane.ERROR_MESSAGE);

            } else if (userDAO.login(user)) {
                byte[] data;
                BufferedImage bufferedImage = null;
                try {
                    data = user.getImageUser().getBytes(1, (int) user.getImageUser().length());
                    bufferedImage = ImageIO.read(new ByteArrayInputStream(data));
                } catch (SQLException | IOException exception) {
                    System.err.println(exception);
                }

                ImageClassSQL imageClassSQL = new ImageClassSQL(view_main.jp_profile_imgUser.getHeight(),
                        view_main.jp_profile_imgUser.getWidth(), bufferedImage);
                view_main.jp_profile_imgUser.add(imageClassSQL);
                view_main.jp_profile_imgUser.repaint();

                setObject(user);
                setViewWindow(1);
                setViewMain(1);

            } else {
                JOptionPane.showMessageDialog(view_login, "Esta cuenta no existe", "MBR", JOptionPane.ERROR_MESSAGE);
                cleanLogin();
            }
            //****************************** MENU ITEMS ******************************//
            //Menu Item Main Main
        } else if (e.getSource() == view_main.menui_main_main) {

            setViewMain(1);

            //Menu Item Main Perfil
        } else if (e.getSource() == view_main.menui_main_perfil) {

            setViewMain(2);

            //Menu Item Main Salir
        } else if (e.getSource() == view_main.menui_main_salir) {

            int decision = JOptionPane.showConfirmDialog(view_main, "Desea cerrar sesion?", "MBR", JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            if (decision == JOptionPane.OK_OPTION) {
                setViewWindow(2);
                cleanObjectLogout();
            }

            //Menu Item Main Configuration Impresora
        } else if (e.getSource() == view_main.menui_main_configuracion) {
            /*
                En Desarrollo...
             */
            //Menu Item Main Mantenimiento
        } else if (e.getSource() == view_main.menui_main_mantenimiento) {

            MaintenanceController maintenanceController = new MaintenanceController(view_login, view_main, view_modulo_mantenimiento,
                    view_modulo_mantenimiento_usuario, view_dialog_listUser);
            maintenanceController.iniciar();
            view_modulo_mantenimiento.setVisible(true);
            view_main.setVisible(false);
            //setViewWindow(3);
            //setViewModuloMantenimiento(1);

        }
    }

    /**
     * * ---------- ALL VIEWS ---------- **
     */
    private void setViewWindow(int view) {

        boolean main = false;
        boolean login = false;
        boolean moduloMantenimiento = false;

        switch (view) {
            case 1:
                main = true;
                break;
            case 2:
                login = true;
                break;
            case 3:
                moduloMantenimiento = true;
                break;
            default:
                System.err.println(this.getClass() + " ==> parametro no registrado");
                break;
        }
        view_login.setVisible(login);
        view_main.setVisible(main);
        view_modulo_mantenimiento.setVisible(moduloMantenimiento);
        view_modulo_mantenimiento.setExtendedState(MAXIMIZED_BOTH);

    }

    private void setViewMain(int panel) {

        boolean main = false;
        boolean profile = false;

        switch (panel) {
            case 1:
                main = true;
                break;
            case 2:
                profile = true;
                break;
            case 3:
                break;
            default:
                System.err.println(this.getClass() + " ==> parametro no registrado");
                break;
        }

        //View
        view_main.setTitle("Pagina Principal");
        view_main.setExtendedState(MAXIMIZED_BOTH);

        //Paneles
        view_main.jp_main_main.setVisible(main);
        view_main.jp_main_profile.setVisible(profile);
    }

    /**
     * * ---------- SET OBJECT OF SESSION ---------- **
     */
    private void setObject(User user) {

        view_main.txt_profile_codeUser.setText(user.getCodeUser());
        view_main.txt_profile_fullNameUser.setText(user.getFullnameUser());
        view_main.txt_profile_correoUser.setText(user.getCorreoUser());
        view_main.txt_profile_phone1User.setText(user.getPhone1User());
        view_main.txt_profile_phone2User.setText(user.getPhone1User());
        view_main.txt_profile_stateUser.setText(String.valueOf(user.isStateUser()));
        view_main.txt_profile_dateUser.setText(String.valueOf(user.getDateUser()));
        view_main.txt_profile_pm.setText(String.valueOf(user.isPermissionMaintenanceUser()));
        view_main.txt_profile_pp.setText(String.valueOf(user.isPermissionPurchaseUser()));
        view_main.txt_profile_ps.setText(String.valueOf(user.isPermissionSaleUser()));
        view_main.txt_profile_pw.setText(String.valueOf(user.isPermissionWarehouseUser()));

    }

    /**
     * * ---------- CLEAN OF OBJECTS AND VIEWS ---------- **
     */
    private void cleanLogin() {

        view_login.txt_username.setText(null);
        view_login.txt_password.setText(null);
    }

    private void cleanObjectLogout() {

        user.setIdUser(null);
        user.setCodeUser(null);
        user.setImageUser(null);
        //System.out.println(view_main.jp_profile_imgUser.getComponentCount());
        view_main.jp_profile_imgUser.removeAll();
        user.setPasswordUser(null);
        user.setFullnameUser(null);
        user.setCorreoUser(null);
        user.setPhone1User(null);
        cleanLogin();

    }

    public class ImageClassSQL extends javax.swing.JPanel {

        BufferedImage ruta;

        public ImageClassSQL(int x, int y, BufferedImage ruta) {

            this.setSize(x, y);
            this.ruta = ruta;
        }

        public void paint(Graphics g) {

            Dimension height = getSize();
            BufferedImage img = ruta;
            g.drawImage(img, 0, 0, height.width, height.height, null);
            setOpaque(false);
            super.paintComponent(g);
        }
    }
}
