package com.belili.controller;

import com.belili.dao.UserDAO;
import com.belili.dao.impl.UserDAOImpl;
import com.belili.pojo.User;
import com.belili.view.View_dialog_listUser;
import com.belili.view.View_login;
import com.belili.view.View_main;
import com.belili.view.View_modulo_mantenimiento;
import com.belili.view.View_modulo_mantenimiento_user;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Dimension;
import org.apache.commons.codec.digest.DigestUtils;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.ByteArrayOutputStream;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Controller_user implements ActionListener {

    //VIEWS
    private final View_login view_login;
    private final View_main view_main;
    private final View_modulo_mantenimiento view_modulo_mantenimiento;
    private final View_modulo_mantenimiento_user view_modulo_mantenimiento_usuario;
    private final View_dialog_listUser view_dialog_listUser;

    //IMAGE
    public File fileCreate;
    public File fileEdit;

    //OBJECT USER
    User user;
    User userCreate;
    User userReadAndEdit;

    //***CONSTRUCTOR***
    public Controller_user(View_login view_login,
            View_main view_main, View_modulo_mantenimiento view_modulo_mantenimiento, View_modulo_mantenimiento_user view_modulo_mantenimiento_usuario,
            View_dialog_listUser view_dialog_listUser) {
        //Views
        this.view_login = view_login;
        this.view_main = view_main;
        this.view_modulo_mantenimiento = view_modulo_mantenimiento;
        this.view_modulo_mantenimiento_usuario = view_modulo_mantenimiento_usuario;
        this.view_dialog_listUser = view_dialog_listUser;

        //Buttons
        this.view_modulo_mantenimiento_usuario.btn_moduloUser_createUser_return.addActionListener(this);
        this.view_modulo_mantenimiento_usuario.btn_moduloUser_createUser_upload.addActionListener(this);
        this.view_modulo_mantenimiento_usuario.btn_moduloUser_createUser_default.addActionListener(this);
        this.view_modulo_mantenimiento_usuario.btn_moduloUser_createUser_create.addActionListener(this);

        this.view_modulo_mantenimiento_usuario.btn_moduloUser_editUser_return.addActionListener(this);
        this.view_modulo_mantenimiento_usuario.btn_moduloUser_editUser_viewList.addActionListener(this);
        this.view_modulo_mantenimiento_usuario.btn_moduloUser_editUser_search.addActionListener(this);
        this.view_modulo_mantenimiento_usuario.btn_moduloUser_editUser_edit.addActionListener(this);
        this.view_modulo_mantenimiento_usuario.btn_moduloUser_editUser_changeImage.addActionListener(this);
        this.view_modulo_mantenimiento_usuario.btn_moduloUser_editUser_save.addActionListener(this);
        this.view_modulo_mantenimiento_usuario.btn_moduloUser_editUser_restore.addActionListener(this);

        this.view_modulo_mantenimiento_usuario.btn_moduloUser_lowerUser_return.addActionListener(this);

        this.view_login.btn_connect.addActionListener(this);

        //Menu Items
        this.view_main.menui_main_perfil.addActionListener(this);
        this.view_main.menui_main_salir.addActionListener(this);
        this.view_main.menui_main_configuracion.addActionListener(this);
        this.view_main.menui_main_mantenimiento.addActionListener(this);
        this.view_modulo_mantenimiento.menui_modulo_createUser.addActionListener(this);
        this.view_modulo_mantenimiento.menui_modulo_editUser.addActionListener(this);
        this.view_modulo_mantenimiento.menui_modulo_lowerUser.addActionListener(this);
        this.view_modulo_mantenimiento.menui_modulo_return.addActionListener(this);

    }

    public void iniciar() {
        view_login.setTitle("Almacen");
        view_login.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

//        //****************************** BUTTONS ******************************//
//        //Boton Login User
//        if (e.getSource() == view_login.btn_connect) {
//
//            UserDAO userDAO = new UserDAOImpl();
//            user = new User();
//            user.setUsernameUser(view_login.txt_username.getText());
//            user.setPasswordUser(view_login.txt_password.getText());
//
//            if (view_login.txt_username.getText().isEmpty() || view_login.txt_password.getText().isEmpty()) {
//                JOptionPane.showMessageDialog(view_login, "Por favor ingrese su cuenta", "MBR", JOptionPane.ERROR_MESSAGE);
//
//            } else if (userDAO.login(user)) {
//                byte[] data;
//                BufferedImage bufferedImage = null;
//                try {
//                    data = user.getImageUser().getBytes(1, (int) user.getImageUser().length());
//                    bufferedImage = ImageIO.read(new ByteArrayInputStream(data));
//                } catch (SQLException | IOException exception) {
//                    System.err.println(exception);
//                }
//
//                ImageClassSQL imageClassSQL = new ImageClassSQL(view_main.jp_profile_imgUser.getHeight(),
//                        view_main.jp_profile_imgUser.getWidth(), bufferedImage);
//                view_main.jp_profile_imgUser.add(imageClassSQL);
//                view_main.jp_profile_imgUser.repaint();
//
//                setObject(user);
//                setViewWindow(1);
//                setViewMain(1);
//
//            } else {
//                JOptionPane.showMessageDialog(view_login, "Esta cuenta no existe", "MBR", JOptionPane.ERROR_MESSAGE);
//                cleanLogin();
//            }
//            //Boton create User **CREATE USER**
//        } else if (e.getSource() == view_modulo_mantenimiento_usuario.btn_moduloUser_createUser_create) {
//
//            if (view_modulo_mantenimiento_usuario.txt_moduloUser_username.getText().isEmpty()
//                    || view_modulo_mantenimiento_usuario.txt_moduloUser_fullname.getText().isEmpty()
//                    || view_modulo_mantenimiento_usuario.txt_moduloUser_phone.getText().isEmpty()
//                    || view_modulo_mantenimiento_usuario.txt_moduloUser_correo.getText().isEmpty()
//                    || view_modulo_mantenimiento_usuario.txt_moduloUser_password.getText().isEmpty()
//                    || view_modulo_mantenimiento_usuario.txt_moduloUser_repassword.getText().isEmpty()
//                    || view_modulo_mantenimiento_usuario.panel_moduloUser_image.getComponentCount() == 0) {
//
//                JOptionPane.showMessageDialog(view_modulo_mantenimiento_usuario, "Datos Incompletos", "MBR", JOptionPane.ERROR_MESSAGE);
//
//            } else {
//
//                if ((view_modulo_mantenimiento_usuario.txt_moduloUser_fullname.getText().length() >= 10)
//                        && (view_modulo_mantenimiento_usuario.txt_moduloUser_phone.getText().length() >= 7)
//                        && (view_modulo_mantenimiento_usuario.txt_moduloUser_username.getText().length() >= 4)
//                        && (view_modulo_mantenimiento_usuario.txt_moduloUser_password.getText().length() >= 4)) {
//
//                    if (view_modulo_mantenimiento_usuario.txt_moduloUser_password.getText()
//                            .equals(view_modulo_mantenimiento_usuario.txt_moduloUser_repassword.getText())) {
//
//                        Pattern pattern = Pattern
//                                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
//                                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
//                        Matcher mather = pattern.matcher(view_modulo_mantenimiento_usuario.txt_moduloUser_correo.getText());
//
//                        if (mather.find() == true) {
//
//                            final String TYPE_USER = "Cliente";
//                            String passwordHash = DigestUtils.sha1Hex(view_modulo_mantenimiento_usuario.txt_moduloUser_password.getText());
//                            userCreate = null;
////                            try {
////                                userCreate = new User(TYPE_USER,
////                                        processImageCreateUser(fileCreate),
////                                        view_modulo_mantenimiento_usuario.txt_moduloUser_username.getText(),
////                                        passwordHash,
////                                        view_modulo_mantenimiento_usuario.txt_moduloUser_fullname.getText(),
////                                        view_modulo_mantenimiento_usuario.txt_moduloUser_correo.getText(),
////                                        view_modulo_mantenimiento_usuario.txt_moduloUser_phone.getText());
////                            } catch (IOException | SQLException | URISyntaxException ex) {
////                                Logger.getLogger(Controller_user.class.getName()).log(Level.SEVERE, null, ex);
////                            }
//
//                            if (actionCreateUser(userCreate)) {
//                                JOptionPane.showMessageDialog(view_modulo_mantenimiento_usuario, "Usuario Creado Correctamente", "MBR", JOptionPane.INFORMATION_MESSAGE);
//                                cleanViewCreateUser();
//                                setViewWindow(3);
//                                setViewModuloMantenimiento(1);
//                            } else {
//                                JOptionPane.showMessageDialog(view_modulo_mantenimiento_usuario, "Datos Incompletos o incorrectos", "MBR", JOptionPane.ERROR_MESSAGE);
//                            }
//                            userCreate = null;
//
//                        } else {
//                            JOptionPane.showMessageDialog(view_modulo_mantenimiento_usuario, "El correo es incorrecto", "MBR", JOptionPane.ERROR_MESSAGE);
//                        }
//
//                    } else {
//                        JOptionPane.showMessageDialog(view_modulo_mantenimiento_usuario, "Las claves no coinciden", "MBR", JOptionPane.ERROR_MESSAGE);
//                    }
//
//                } else {
//                    JOptionPane.showMessageDialog(view_modulo_mantenimiento_usuario, "Datos con pocos caracteres", "MBR", JOptionPane.ERROR_MESSAGE);
//                }
//            }
//
//            //Boton upload image **CREATE USER**
//        } else if (e.getSource() == view_modulo_mantenimiento_usuario.btn_moduloUser_createUser_upload) {
//
//            JFileChooser fileChooser = new JFileChooser();
//            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//            FileNameExtensionFilter filter = new FileNameExtensionFilter("png/jpg/jpeg", "png", "jpg", "jpeg");
//            fileChooser.setFileFilter(filter);
//
//            int seleccion = fileChooser.showOpenDialog(view_modulo_mantenimiento_usuario);
//
//            if (seleccion == JFileChooser.APPROVE_OPTION) {
//
//                /* remover imagen actual */
//                view_modulo_mantenimiento_usuario.panel_moduloUser_image.removeAll();
//                /*----------------------*/
//
//                fileCreate = fileChooser.getSelectedFile();
//                String ruta = fileCreate.getAbsolutePath();
//                int x = view_modulo_mantenimiento_usuario.panel_moduloUser_image.getWidth();
//                int y = view_modulo_mantenimiento_usuario.panel_moduloUser_image.getHeight();
//
//                ImageClass imageClass = new ImageClass(x, y, ruta);
//                view_modulo_mantenimiento_usuario.panel_moduloUser_image.add(imageClass);
//                view_modulo_mantenimiento_usuario.panel_moduloUser_image.repaint();
//            }
//
//            //Boton default image **CREATE USER**
//        } else if (e.getSource() == view_modulo_mantenimiento_usuario.btn_moduloUser_createUser_default) {
//
//            /* remover imagen actual */
//            view_modulo_mantenimiento_usuario.panel_moduloUser_image.removeAll();
//            /*----------------------*/
//
//            //Imagen Estandar
//            final String RUTA_IMAGEN_ESTANDAR = "/com/belili/images/perfil_vacio.png";
//            ImageClassEstandar m = new ImageClassEstandar(view_modulo_mantenimiento_usuario.panel_moduloUser_image, RUTA_IMAGEN_ESTANDAR);
//            view_modulo_mantenimiento_usuario.panel_moduloUser_image.add(m).repaint();
//            
//            fileCreate = null;
//
//            //Boton return **CREATE USER**
//        } else if (e.getSource() == view_modulo_mantenimiento_usuario.btn_moduloUser_createUser_return) {
//
//            setViewWindow(3);
//            setViewModuloMantenimiento(1);
//            cleanViewCreateUser();
//
//            //Boton dialog_listUser **EDIT USER**
//        } else if (e.getSource() == view_modulo_mantenimiento_usuario.btn_moduloUser_editUser_viewList) {
//
//            view_dialog_listUser.setVisible(true);
//
//            //Boton searchUser **EDIT USER**
//        } else if (e.getSource() == view_modulo_mantenimiento_usuario.btn_moduloUser_editUser_search) {
//
//            String code = view_modulo_mantenimiento_usuario.txt_moduloUser_editUser_codeUser.getText();
//            if (code.isEmpty()) {
//                JOptionPane.showMessageDialog(view_modulo_mantenimiento_usuario, "Por Favor, digite el codigo de usuario a buscar..", "MBR", JOptionPane.WARNING_MESSAGE);
//            } else {
//                userReadAndEdit = new User();
//                userReadAndEdit.setCodeUser("MBR" + code);
//                if (actionSearchUser(userReadAndEdit) != null) {
//                    view_modulo_mantenimiento_usuario.txt_moduloUser_editUser_fullname.setText(userReadAndEdit.getFullnameUser());
//                    view_modulo_mantenimiento_usuario.txt_moduloUser_editUser_correo.setText(userReadAndEdit.getCorreoUser());
//                    view_modulo_mantenimiento_usuario.txt_moduloUser_editUser_phone.setText(userReadAndEdit.getPhoneUser());
//                    view_modulo_mantenimiento_usuario.txt_moduloUser_editUser_username.setText(userReadAndEdit.getUsernameUser());
//
//                    byte[] data;
//                    BufferedImage bufferedImage = null;
//                    view_modulo_mantenimiento_usuario.panel_moduloUser_editUser_image.removeAll();
//                    try {
//                        data = userReadAndEdit.getImageUser().getBytes(1, (int) userReadAndEdit.getImageUser().length());
//                        bufferedImage = ImageIO.read(new ByteArrayInputStream(data));
//                    } catch (SQLException | IOException exception) {
//                        System.err.println(exception);
//                    }
//
//                    ImageClassSQL imageClassSQL = new ImageClassSQL(view_modulo_mantenimiento_usuario.panel_moduloUser_editUser_image.getHeight(),
//                            view_modulo_mantenimiento_usuario.panel_moduloUser_editUser_image.getWidth(), bufferedImage);
//                    view_modulo_mantenimiento_usuario.panel_moduloUser_editUser_image.add(imageClassSQL);
//                    view_modulo_mantenimiento_usuario.panel_moduloUser_editUser_image.repaint();
//
//                    disabledFieldsEditUser();
//
//                } else {
//                    JOptionPane.showMessageDialog(view_modulo_mantenimiento_usuario, "Este usuario no existe", "MBR", JOptionPane.ERROR_MESSAGE);
//                    view_modulo_mantenimiento_usuario.txt_moduloUser_editUser_codeUser.setText(null);
//                }
//            }
//
//            //Boton editUser **EDIT USER**
//        } else if (e.getSource() == view_modulo_mantenimiento_usuario.btn_moduloUser_editUser_edit) {
//
//            enabledFieldsEditUser();
//
//            //Boton changeImage **EDIT USER**
//        } else if (e.getSource() == view_modulo_mantenimiento_usuario.btn_moduloUser_editUser_changeImage) {
//
//            JFileChooser fileChooser = new JFileChooser();
//            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//            FileNameExtensionFilter filter = new FileNameExtensionFilter("png/jpg/jpeg", "png", "jpg", "jpeg");
//            fileChooser.setFileFilter(filter);
//
//            int seleccion = fileChooser.showOpenDialog(view_modulo_mantenimiento_usuario);
//
//            if (seleccion == JFileChooser.APPROVE_OPTION) {
//
//                /* remover imagen actual */
//                view_modulo_mantenimiento_usuario.panel_moduloUser_editUser_image.removeAll();
//                /*----------------------*/
//
//                fileEdit = fileChooser.getSelectedFile();
//                String ruta = fileEdit.getAbsolutePath();
//                int x = view_modulo_mantenimiento_usuario.panel_moduloUser_editUser_image.getWidth();
//                int y = view_modulo_mantenimiento_usuario.panel_moduloUser_editUser_image.getHeight();
//
//                ImageClass imageClass = new ImageClass(x, y, ruta);
//                view_modulo_mantenimiento_usuario.panel_moduloUser_editUser_image.add(imageClass);
//                view_modulo_mantenimiento_usuario.panel_moduloUser_editUser_image.repaint();
//            }
//
//            //Boton restore **EDIT USER**
//        } else if (e.getSource() == view_modulo_mantenimiento_usuario.btn_moduloUser_editUser_restore) {
//
//            view_modulo_mantenimiento_usuario.txt_moduloUser_editUser_fullname.setText(userReadAndEdit.getFullnameUser());
//            view_modulo_mantenimiento_usuario.txt_moduloUser_editUser_correo.setText(userReadAndEdit.getCorreoUser());
//            view_modulo_mantenimiento_usuario.txt_moduloUser_editUser_phone.setText(userReadAndEdit.getPhoneUser());
//            view_modulo_mantenimiento_usuario.txt_moduloUser_editUser_username.setText(userReadAndEdit.getUsernameUser());
//
//            byte[] data;
//            BufferedImage bufferedImage = null;
//            view_modulo_mantenimiento_usuario.panel_moduloUser_editUser_image.removeAll();
//            try {
//                data = userReadAndEdit.getImageUser().getBytes(1, (int) userReadAndEdit.getImageUser().length());
//                bufferedImage = ImageIO.read(new ByteArrayInputStream(data));
//            } catch (SQLException | IOException exception) {
//                System.err.println(exception);
//            }
//
//            ImageClassSQL imageClassSQL = new ImageClassSQL(view_modulo_mantenimiento_usuario.panel_moduloUser_editUser_image.getHeight(),
//                    view_modulo_mantenimiento_usuario.panel_moduloUser_editUser_image.getWidth(), bufferedImage);
//            view_modulo_mantenimiento_usuario.panel_moduloUser_editUser_image.add(imageClassSQL);
//            view_modulo_mantenimiento_usuario.panel_moduloUser_editUser_image.repaint();
//
//            fileEdit = null;
//            disabledFieldsEditUser();
//
//        } //Boton save **EDIT USER**
//        else if (e.getSource() == view_modulo_mantenimiento_usuario.btn_moduloUser_editUser_save) {
//
//            int decision = JOptionPane.showConfirmDialog(view_modulo_mantenimiento_usuario, "Desea guardar los cambios?", "MBR", JOptionPane.OK_CANCEL_OPTION);
//
//            if (decision == JOptionPane.OK_OPTION) {
//
//                Pattern pattern = Pattern
//                        .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
//                                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
//                Matcher mather = pattern.matcher(view_modulo_mantenimiento_usuario.txt_moduloUser_editUser_correo.getText());
//
//                if (mather.find() == true) {
//
//                    userReadAndEdit.setFullnameUser(view_modulo_mantenimiento_usuario.txt_moduloUser_editUser_fullname.getText());
//                    userReadAndEdit.setCorreoUser(view_modulo_mantenimiento_usuario.txt_moduloUser_editUser_correo.getText());
//                    userReadAndEdit.setPhoneUser(view_modulo_mantenimiento_usuario.txt_moduloUser_editUser_phone.getText());
//                    userReadAndEdit.setUsernameUser(view_modulo_mantenimiento_usuario.txt_moduloUser_editUser_username.getText());
//
//                    if (fileEdit != null) {
//                        userReadAndEdit.setImageUser(processImageEditUser(fileEdit));
//                    }
//
//                    if (actionEditUser(userReadAndEdit)) {
//                        JOptionPane.showMessageDialog(view_modulo_mantenimiento_usuario, "Cambios guardados..", "MBR", JOptionPane.INFORMATION_MESSAGE);
//                        disabledFieldsEditUser();
//                    } else {
//                        JOptionPane.showMessageDialog(view_modulo_mantenimiento_usuario, "Error al guardar..", "MBR", JOptionPane.ERROR_MESSAGE);
//                    }
//
//                } else {
//                    JOptionPane.showMessageDialog(view_modulo_mantenimiento_usuario, "El correo es incorrecto", "MBR", JOptionPane.ERROR_MESSAGE);
//                }
//
//            }
//
//            //Boton return **EDIT USER**
//        } else if (e.getSource() == view_modulo_mantenimiento_usuario.btn_moduloUser_editUser_return) {
//
//            setViewWindow(3);
//            setViewModuloMantenimiento(1);
//            cleanViewEditUser();
//
//            //Boton return **LOWER USER**
//        } else if (e.getSource() == view_modulo_mantenimiento_usuario.btn_moduloUser_lowerUser_return) {
//
//            setViewWindow(3);
//            setViewModuloMantenimiento(1);
//            //cleanViewCreateUser();
//
//            //****************************** MENU ITEMS ******************************//
//            //Menu Item Main Perfil
//        } else if (e.getSource() == view_main.menui_main_perfil) {
//
//            setViewMain(2);
//
//            //Menu Item Main Salir
//        } else if (e.getSource() == view_main.menui_main_salir) {
//
//            int decision = JOptionPane.showConfirmDialog(view_main, "Desea cerrar sesion?", "MBR", JOptionPane.OK_CANCEL_OPTION,
//                    JOptionPane.QUESTION_MESSAGE);
//
//            if (decision == JOptionPane.OK_OPTION) {
//                setViewWindow(2);
//                cleanObjectLogout();
//            }
//
//            //Menu Item Main Configuration Impresora
//        } else if (e.getSource() == view_main.menui_main_configuracion) {
//            /*
//                En Desarrollo...
//             */
//            //Menu Item Main Mantenimiento
//        } else if (e.getSource() == view_main.menui_main_mantenimiento) {
//
//            setViewWindow(3);
//            setViewModuloMantenimiento(1);
//
//            //Menu Item Modulo Create User
//        } else if (e.getSource() == view_modulo_mantenimiento.menui_modulo_createUser) {
//
//            setViewWindow(4);
//            setViewModuloMantenimientoUser(1);
//            validationUserCreate();
//
//            //Menu Item Modulo Edit User
//        } else if (e.getSource() == view_modulo_mantenimiento.menui_modulo_editUser) {
//
//            setViewWindow(4);
//            setViewModuloMantenimientoUser(2);
//            disabledFieldsEditUser();
//            validationUserEdit();
//
//            //Menu Item Modulo Lower User
//        } else if (e.getSource() == view_modulo_mantenimiento.menui_modulo_lowerUser) {
//
//            setViewWindow(4);
//            setViewModuloMantenimientoUser(3);
//            //validationUserCreate();
//
//        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    
//    /**
//     * * ---------- ALL VIEWS ---------- **
//     */
//    private void setViewWindow(int view) {
//
//        boolean main = false;
//        boolean login = false;
//        boolean moduloMantenimiento = false;
//        boolean moduloMantenimientoUser = false;
//        switch (view) {
//            case 1:
//                main = true;
//                break;
//            case 2:
//                login = true;
//                break;
//            case 3:
//                moduloMantenimiento = true;
//                break;
//            case 4:
//                moduloMantenimientoUser = true;
//                break;
//            default:
//                System.err.println(this.getClass() + " ==> parametro no registrado");
//                break;
//        }
//        view_login.setVisible(login);
//        view_main.setVisible(main);
//        view_modulo_mantenimiento.setVisible(moduloMantenimiento);
//        view_modulo_mantenimiento_usuario.setVisible(moduloMantenimientoUser);
//
//    }
//
//    private void setViewMain(int panel) {
//
//        boolean main = false;
//        boolean profile = false;
//
//        switch (panel) {
//            case 1:
//                main = true;
//                break;
//            case 2:
//                profile = true;
//                break;
//            case 3:
//                break;
//            default:
//                System.err.println(this.getClass() + " ==> parametro no registrado");
//                break;
//        }
//
//        //View
//        view_main.setTitle("Pagina Principal");
//        view_main.setExtendedState(MAXIMIZED_BOTH);
//
//        //Paneles
//        view_main.jp_main_main.setVisible(main);
//        view_main.jp_main_profile.setVisible(profile);
//    }
//
//    private void setViewModuloMantenimiento(int panel) {
//
//        boolean principal = false;
//
//        switch (panel) {
//            case 1:
//                principal = true;
//                break;
//            default:
//                System.err.println(this.getClass() + " ==> parametro no registrado");
//                break;
//        }
//
//        //View
//        view_modulo_mantenimiento.setTitle("Modulo Mantenimiento");
//        view_modulo_mantenimiento.setExtendedState(MAXIMIZED_BOTH);
//
//        //Paneles
//        view_modulo_mantenimiento.panelPrincipal.setVisible(principal);
//    }
//
//    private void setViewModuloMantenimientoUser(int panel) {
//
//        boolean createUser = false;
//        boolean editUser = false;
//        boolean lowerUser = false;
//
//        switch (panel) {
//            case 1:
//                createUser = true;
//                break;
//            case 2:
//                editUser = true;
//                break;
//            case 3:
//                lowerUser = true;
//                break;
//            default:
//                System.err.println(this.getClass() + " ==> parametro no registrado");
//                break;
//
//        }
//
//        //View
//        view_modulo_mantenimiento_usuario.setTitle("Usuario");
//        view_modulo_mantenimiento_usuario.setExtendedState(MAXIMIZED_BOTH);
//
//        //Paneles
//        view_modulo_mantenimiento_usuario.jp_modulo_createUser.setVisible(createUser);
//        view_modulo_mantenimiento_usuario.jp_modulo_editUser.setVisible(editUser);
//        view_modulo_mantenimiento_usuario.jp_modulo_lowerUser.setVisible(lowerUser);
//    }
//
//    /**
//     * * ---------- CRUD OF OBJECTS USER ---------- **
//     */
//    //CREATE
//    private boolean actionCreateUser(User userCreate) {
//
//        boolean action = false;
//        UserDAO userDAO = new UserDAOImpl();
//
//        if (userDAO.create(userCreate)) {
//            action = true;
//        }
//        return action;
//    }
//
//    //READ
//    private User actionSearchUser(User userRead) {
//
//        UserDAO daoSelected = new UserDAOImpl();
//        if (daoSelected.selectByCode(userRead)) {
//            user.toString();
//            return userRead;
//        } else {
//            System.err.println("ERROR AL BUSCAR");
//            return null;
//        }
//    }
//
//    //EDIT
//    private boolean actionEditUser(User userEdit) {
//
//        boolean action = true;
//        UserDAO daoUpdate = new UserDAOImpl();
//        //userEdit = daoUpdate.selectById(userEdit.getIdUser());
//        try {
//            daoUpdate.update(userEdit);
//        } catch (Exception e) {
//            action = false;
//        }
//        return action;
//    }
//
//    //LOWER
//    private boolean actionDeleteUser(User userDelete) {
//        return false;
//    }
//
//    //IMAGE PROCESS IN THE CREATION OF USERS
//    private Blob processImageCreateUser(File fileImage) throws IOException, SQLException, URISyntaxException {
//
//        FileInputStream fileInputStream;
//        Blob blob = null;
//
//        if (fileImage == null) {
//
//            File fnew = new File(getClass().getResource("/com/belili/images/perfil_vacio.png").toURI());
//
//            BufferedImage originalImage = ImageIO.read(fnew);
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            ImageIO.write(originalImage, "jpg", baos);
//            byte[] imageInByte = baos.toByteArray();
//            blob = new javax.sql.rowset.serial.SerialBlob(imageInByte);
//
//        } else {
//
//            byte[] dataImage = new byte[(int) fileImage.length()];
//
//            try {
//                fileInputStream = new FileInputStream(fileImage);
//                fileInputStream.read(dataImage);
//                blob = new javax.sql.rowset.serial.SerialBlob(dataImage);
//            } catch (IOException ioe) {
//                System.err.println(ioe);
//            } catch (SQLException sqle) {
//                System.err.println(sqle);
//            } catch (Exception ex) {
//                System.err.println(ex);
//            }
//        }
//
//        return blob;
//    }
//
//    //IMAGE PROCESS IN THE EDITION OF USERS
//    private Blob processImageEditUser(File fileImage) {
//
//        FileInputStream fileInputStream;
//        Blob blob = null;
//
//        if (fileImage != null) {
//
//            byte[] dataImage = new byte[(int) fileImage.length()];
//
//            try {
//                fileInputStream = new FileInputStream(fileImage);
//                fileInputStream.read(dataImage);
//                blob = new javax.sql.rowset.serial.SerialBlob(dataImage);
//            } catch (IOException ioe) {
//                System.err.println(ioe);
//            } catch (SQLException sqle) {
//                System.err.println(sqle);
//            } catch (Exception ex) {
//                System.err.println(ex);
//            }
//        }
//
//        return blob;
//    }
//
//    //DISABLED INPUTS EDIT USER
//    private void disabledFieldsEditUser() {
//        view_modulo_mantenimiento_usuario.btn_moduloUser_editUser_changeImage.setEnabled(false);
//        view_modulo_mantenimiento_usuario.txt_moduloUser_editUser_fullname.setEditable(false);
//        view_modulo_mantenimiento_usuario.txt_moduloUser_editUser_correo.setEditable(false);
//        view_modulo_mantenimiento_usuario.txt_moduloUser_editUser_phone.setEditable(false);
//        view_modulo_mantenimiento_usuario.txt_moduloUser_editUser_username.setEditable(false);
//    }
//
//    //ENABLED INPUTS EDIT USER
//    private void enabledFieldsEditUser() {
//        view_modulo_mantenimiento_usuario.btn_moduloUser_editUser_changeImage.setEnabled(true);
//        view_modulo_mantenimiento_usuario.txt_moduloUser_editUser_fullname.setEditable(true);
//        view_modulo_mantenimiento_usuario.txt_moduloUser_editUser_correo.setEditable(true);
//        view_modulo_mantenimiento_usuario.txt_moduloUser_editUser_phone.setEditable(true);
//        view_modulo_mantenimiento_usuario.txt_moduloUser_editUser_username.setEditable(true);
//    }
//
//    /**
//     * * ---------- VALIDATIONS OF INPUTS ---------- **
//     */
//    private void validationUserCreate() {
//
//        /* VALIDAR TXT PHONE */
//        view_modulo_mantenimiento_usuario.txt_moduloUser_phone.addKeyListener(
//                new KeyAdapter() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//                int limite = 15;
//                char caracter = e.getKeyChar();
//                if (((caracter < '0')
//                        || (caracter > '9'))
//                        && (caracter != '\b')) {
//                    e.consume();
//                } else if (view_modulo_mantenimiento_usuario.txt_moduloUser_phone.getText().length() == limite) {
//                    e.consume();
//                }
//            }
//        });
//
//        /* VALIDAR TXT FULLNAME */
//        view_modulo_mantenimiento_usuario.txt_moduloUser_fullname.addKeyListener(
//                new KeyAdapter() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//                int limite = 50;
//                char caracter = e.getKeyChar();
//                if (Character.isDigit(caracter)) {
//                    e.consume();
//                } else if (view_modulo_mantenimiento_usuario.txt_moduloUser_fullname.getText().length() == limite) {
//                    e.consume();
//                }
//            }
//        });
//
//        /* VALIDAR TXT USERNAME */
//        view_modulo_mantenimiento_usuario.txt_moduloUser_username.addKeyListener(
//                new KeyAdapter() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//                int limite = 20;
//                char caracter = e.getKeyChar();
//                if ((caracter == ' ')) {
//                    e.consume();
//                } else if (view_modulo_mantenimiento_usuario.txt_moduloUser_username.getText().length() == limite) {
//                    e.consume();
//                }
//            }
//        });
//
//        /* VALIDAR TXT PASSWORD */
//        view_modulo_mantenimiento_usuario.txt_moduloUser_password.addKeyListener(
//                new KeyAdapter() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//                int limite = 20;
//                char caracter = e.getKeyChar();
//                if (caracter == ' ') {
//                    e.consume();
//                } else if (view_modulo_mantenimiento_usuario.txt_moduloUser_password.getText().length() == limite) {
//                    e.consume();
//                }
//            }
//        });
//
//        /* VALIDAR TXT REPASSWORD */
//        view_modulo_mantenimiento_usuario.txt_moduloUser_repassword.addKeyListener(
//                new KeyAdapter() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//                int limite = 20;
//                char caracter = e.getKeyChar();
//                if (caracter == ' ') {
//                    e.consume();
//                } else if (view_modulo_mantenimiento_usuario.txt_moduloUser_repassword.getText().length() == limite) {
//                    e.consume();
//                }
//            }
//        });
//    }
//
//    private void validationUserEdit() {
//
//        /* VALIDAR TXT CODE */
//        view_modulo_mantenimiento_usuario.txt_moduloUser_editUser_codeUser.addKeyListener(
//                new KeyAdapter() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//                int limite = 15;
//                char caracter = e.getKeyChar();
//                if (((caracter < '0')
//                        || (caracter > '9'))
//                        && (caracter != '\b')) {
//                    e.consume();
//                } else if (view_modulo_mantenimiento_usuario.txt_moduloUser_editUser_codeUser.getText().length() == limite) {
//                    e.consume();
//                }
//            }
//        });
//
//        /* VALIDAR TXT PHONE */
//        view_modulo_mantenimiento_usuario.txt_moduloUser_editUser_phone.addKeyListener(
//                new KeyAdapter() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//                int limite = 15;
//                char caracter = e.getKeyChar();
//                if (((caracter < '0')
//                        || (caracter > '9'))
//                        && (caracter != '\b')) {
//                    e.consume();
//                } else if (view_modulo_mantenimiento_usuario.txt_moduloUser_editUser_phone.getText().length() == limite) {
//                    e.consume();
//                }
//            }
//        });
//
//        /* VALIDAR TXT FULLNAME */
//        view_modulo_mantenimiento_usuario.txt_moduloUser_editUser_fullname.addKeyListener(
//                new KeyAdapter() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//                int limite = 50;
//                char caracter = e.getKeyChar();
//                if (Character.isDigit(caracter)) {
//                    e.consume();
//                } else if (view_modulo_mantenimiento_usuario.txt_moduloUser_editUser_fullname.getText().length() == limite) {
//                    e.consume();
//                }
//            }
//        });
//
//        /* VALIDAR TXT USERNAME */
//        view_modulo_mantenimiento_usuario.txt_moduloUser_editUser_username.addKeyListener(
//                new KeyAdapter() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//                int limite = 20;
//                char caracter = e.getKeyChar();
//                if ((caracter == ' ')) {
//                    e.consume();
//                } else if (view_modulo_mantenimiento_usuario.txt_moduloUser_editUser_username.getText().length() == limite) {
//                    e.consume();
//                }
//            }
//        });
//
//    }
//
//    private void setObject(User user) {
//
//        view_main.txt_profile_fullnameUser.setText(user.getFullnameUser());
//        view_main.txt_profile_typeUser.setText(user.getTypeUser());
//        view_main.txt_profile_correoUser.setText(user.getCorreoUser());
//        view_main.txt_profile_phoneUser.setText(user.getPhoneUser());
//        view_main.txt_profile_codeUser.setText(user.getCodeUser());
//    }
//
//    /**
//     * * ---------- CLEAN OF OBJECTS AND VIEWS ---------- **
//     */
//    private void cleanLogin() {
//
//        view_login.txt_username.setText(null);
//        view_login.txt_password.setText(null);
//    }
//
//    private void cleanViewCreateUser() {
//
//        view_modulo_mantenimiento_usuario.panel_moduloUser_image.removeAll();
//        view_modulo_mantenimiento_usuario.txt_moduloUser_fullname.setText(null);
//        view_modulo_mantenimiento_usuario.txt_moduloUser_correo.setText(null);
//        view_modulo_mantenimiento_usuario.txt_moduloUser_phone.setText(null);
//        view_modulo_mantenimiento_usuario.txt_moduloUser_username.setText(null);
//        view_modulo_mantenimiento_usuario.txt_moduloUser_password.setText(null);
//        view_modulo_mantenimiento_usuario.txt_moduloUser_repassword.setText(null);
//    }
//
//    private void cleanViewEditUser() {
//
//        view_modulo_mantenimiento_usuario.txt_moduloUser_editUser_codeUser.setText(null);
//        view_modulo_mantenimiento_usuario.panel_moduloUser_editUser_image.removeAll();
//        view_modulo_mantenimiento_usuario.txt_moduloUser_editUser_fullname.setText(null);
//        view_modulo_mantenimiento_usuario.txt_moduloUser_editUser_correo.setText(null);
//        view_modulo_mantenimiento_usuario.txt_moduloUser_editUser_phone.setText(null);
//        view_modulo_mantenimiento_usuario.txt_moduloUser_editUser_username.setText(null);
//    }
//
//    private void cleanObjectLogout() {
//
//        user.setIdUser(null);
//        user.setCodeUser(null);
//        user.setTypeUser(null);
//        user.setImageUser(null);
//        //System.out.println(view_main.jp_profile_imgUser.getComponentCount());
//        view_main.jp_profile_imgUser.removeAll();
//        user.setUsernameUser(null);
//        user.setPasswordUser(null);
//        user.setFullnameUser(null);
//        user.setCorreoUser(null);
//        user.setPhoneUser(null);
//        cleanLogin();
//
//    }
//
//    public class ImageClass extends javax.swing.JPanel {
//
//        String ruta;
//
//        public ImageClass(int x, int y, String ruta) {
//
//            this.setSize(x, y);
//            this.ruta = ruta;
//        }
//
//        public void paint(Graphics g) {
//
//            Dimension height = getSize();
//            Image imgExt = new ImageIcon(ruta).getImage();
//            g.drawImage(imgExt, 0, 0, height.width, height.height, null);
//            setOpaque(false);
//            super.paintComponent(g);
//        }
//    }
//
//    public class ImageClassSQL extends javax.swing.JPanel {
//
//        BufferedImage ruta;
//
//        public ImageClassSQL(int x, int y, BufferedImage ruta) {
//
//            this.setSize(x, y);
//            this.ruta = ruta;
//        }
//
//        public void paint(Graphics g) {
//
//            Dimension height = getSize();
//            BufferedImage img = ruta;
//            g.drawImage(img, 0, 0, height.width, height.height, null);
//            setOpaque(false);
//            super.paintComponent(g);
//        }
//    }
//
//    public class ImageClassEstandar extends javax.swing.JPanel {
//
//        int x, y;
//        String ruta;
//
//        public ImageClassEstandar(JPanel jPanel1, String ruta) {
//            this.x = jPanel1.getWidth();
//            this.y = jPanel1.getHeight();
//            this.ruta = ruta;
//            this.setSize(x, y);
//        }
//
//        @Override
//        public void paint(Graphics g) {
//
//            Image mm = null;
//            ImageIcon Img = new ImageIcon(getClass().getResource(ruta));
//            g.drawImage(Img.getImage(), 0, 0, x, y, null);
//            setOpaque(false);
//            super.paintComponent(g);
//        }
//
//    }
}
