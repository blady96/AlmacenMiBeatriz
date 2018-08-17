package com.belili.controller;

import com.belili.view.View_dialog_listUser;
import com.belili.view.View_login;
import com.belili.view.View_main;
import com.belili.view.View_modulo_mantenimiento;
import com.belili.view.View_modulo_mantenimiento_cliente;
import com.belili.view.View_modulo_mantenimiento_proveedor;
import com.belili.view.View_modulo_mantenimiento_user;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaintenanceController implements ActionListener {

    private final View_login view_login;
    private final View_main view_main;
    private final View_modulo_mantenimiento view_modulo_mantenimiento;
    private final View_modulo_mantenimiento_user view_modulo_mantenimiento_usuario;
    private final View_dialog_listUser view_dialog_listUser;
    //private final View_modulo_mantenimiento_cliente view_modulo_mantenimiento_cliente;
    //private final View_modulo_mantenimiento_proveedor view_modulo_mantenimiento_proveedor;

    public MaintenanceController(View_login view_login, View_main view_main, View_modulo_mantenimiento view_modulo_mantenimiento,
            View_modulo_mantenimiento_user view_modulo_mantenimiento_usuario, View_dialog_listUser view_dialog_listUser) {

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

        //Menu Items
        this.view_modulo_mantenimiento.menui_modulo_createUser.addActionListener(this);
        this.view_modulo_mantenimiento.menui_modulo_editUser.addActionListener(this);
        this.view_modulo_mantenimiento.menui_modulo_lowerUser.addActionListener(this);
        this.view_modulo_mantenimiento.menui_modulo_return.addActionListener(this);
    }

    public void iniciar() {
        view_modulo_mantenimiento.setTitle("Mantenimiento");
        view_modulo_mantenimiento.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        //****************************** MENU ITEMS ******************************//
        //Menu Item Modulo Create User
        if (e.getSource() == view_modulo_mantenimiento.menui_modulo_createUser) {

            setViewWindow(2);
            setViewModuloMantenimientoUser(1);
            //validationUserCreate();

            //Menu Item Modulo Edit User
        } else if (e.getSource() == view_modulo_mantenimiento.menui_modulo_editUser) {

            setViewWindow(2);
            setViewModuloMantenimientoUser(2);
            //disabledFieldsEditUser();
            //validationUserEdit();

            //Menu Item Modulo Lower User
        } else if (e.getSource() == view_modulo_mantenimiento.menui_modulo_lowerUser) {

            setViewWindow(2);
            setViewModuloMantenimientoUser(3);
            //validationUserCreate();

        }

    }
    
    /**
//     * * ---------- ALL VIEWS ---------- **
//     */
    private void setViewWindow(int view) {

        boolean moduloMantenimiento = false;
        boolean moduloMantenimientoUser = false;
        switch (view) {
            case 1:
                moduloMantenimiento = true;
                break;
            case 2:
                moduloMantenimientoUser = true;
                break;
            default:
                System.err.println(this.getClass() + " ==> parametro no registrado");
                break;
        }
        view_modulo_mantenimiento.setVisible(moduloMantenimiento);
        view_modulo_mantenimiento_usuario.setVisible(moduloMantenimientoUser);

    }
    
    private void setViewModuloMantenimientoUser(int panel) {

        boolean createUser = false;
        boolean editUser = false;
        boolean lowerUser = false;

        switch (panel) {
            case 1:
                createUser = true;
                break;
            case 2:
                editUser = true;
                break;
            case 3:
                lowerUser = true;
                break;
            default:
                System.err.println(this.getClass() + " ==> parametro no registrado");
                break;

        }

        //View
        view_modulo_mantenimiento_usuario.setTitle("Usuario");
        view_modulo_mantenimiento_usuario.setExtendedState(MAXIMIZED_BOTH);

        //Paneles
        view_modulo_mantenimiento_usuario.jp_modulo_createUser.setVisible(createUser);
        view_modulo_mantenimiento_usuario.jp_modulo_editUser.setVisible(editUser);
        view_modulo_mantenimiento_usuario.jp_modulo_lowerUser.setVisible(lowerUser);
    }
}
