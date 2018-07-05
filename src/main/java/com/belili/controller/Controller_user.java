package com.belili.controller;

import com.belili.model.Model_connect;
import com.belili.model.Model_login;
import com.belili.model.Model_user;
import com.belili.view.View_login;
import com.belili.view.View_main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Controller_user implements ActionListener {

    private Model_user model_user;
    private Model_login model_login;
    private View_login view_login;
    private View_main view_main;

    public Controller_user(Model_user model_user, Model_login model_login, View_login view_login, View_main view_main) {
        this.model_user = model_user;
        this.model_login = model_login;
        this.view_login = view_login;
        this.view_main = view_main;
        this.view_login.btn_connect.addActionListener(this);
    }

    public void iniciar() {

        view_login.setTitle("Almacen");
        view_login.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); 

        model_user.setUsername_user(view_login.txt_username.getText());
        model_user.setPassword_user(view_login.txt_password.getText());
        
        System.err.println("usuario = " + view_login.txt_username.getText());
        System.err.println("clave = " + view_login.txt_password.getText());
        
        if (model_login.search_user(model_user)) {
         
            JOptionPane.showMessageDialog(null, "Inicio sesion");
            view_login.setVisible(false);
            view_main.setVisible(true);
            view_main.setTitle("Pagina Principal");
            view_main.setLocationRelativeTo(null);
            
            
        }else {
            JOptionPane.showMessageDialog(null, "No inicio sesion");
            clean();
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
    
    public void clean(){
        
        view_login.txt_username.setText(null);
        view_login.txt_password.setText(null);
        
    }

}
