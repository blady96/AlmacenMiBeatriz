package com.belili.dao;

import com.belili.model.Model_connect;
import java.util.ArrayList;
import com.belili.model.Model_user;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Dao_userList extends Model_connect {

    public ArrayList<Model_user> buscarUsuariosConMatriz() {

        //Conexion conex = new Conexion();
        Connection c = (Connection) getConnection();
        ArrayList<Model_user> miLista = new ArrayList<Model_user>();
        Model_user model_user;
        try {
            Statement estatuto = c.createStatement();
            ResultSet rs = estatuto.executeQuery("SELECT * FROM USERS ");

            while (rs.next()) {
                model_user = new Model_user();
                model_user.setId_user(Integer.parseInt(rs.getString("id_user")));
                model_user.setCode_user(rs.getString("code_user"));
                model_user.setType_user(rs.getString("type_user"));
                model_user.setUsername_user(rs.getString("username_user"));
                model_user.setPassword_user(rs.getString("password_user"));
                model_user.setFullname_user(rs.getString("fullname_user"));
                model_user.setCorreo_user(rs.getString("correo_user"));
                miLista.add(model_user);
            }
            rs.close();
            estatuto.close();
            c.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al consultar", "Error",
                    JOptionPane.ERROR_MESSAGE);

        }
        return miLista;
    }

}
