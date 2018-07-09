package com.belili.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Model_queries extends Model_connect {

    public boolean create_user(Model_user user) {

        PreparedStatement ps = null;
        Connection c = (Connection) getConnection();

//        String sql = "INSERT INTO users (type_user,username_user,password_user,"
//                + "fullname_user,correo_user) VALUES (?,?,?,?,?)";
        String sql = "CALL REGISTRAR_USUARIO (?,?,?,?,?)";

        try {

            ps = c.prepareStatement(sql);
            ps.setString(1, user.getType_user());
            ps.setString(2, user.getUsername_user());
            ps.setString(3, user.getPassword_user());
            ps.setString(4, user.getFullname_user());
            ps.setString(5, user.getCorreo_user());
            ps.execute();
            return true;

        } catch (Exception e) {
            System.err.println(e);
            return false;

        } finally {
            try {
                c.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }

    }

    public boolean modify_user(Model_user user) {

        PreparedStatement ps = null;
        Connection c = (Connection) getConnection();

        String sql = "UPDATE users SET type_user=?, username_user=?, password_user=?, fullname_user=?, "
                + "correo_user=? WHERE id_user=?";

        try {

            ps = c.prepareStatement(sql);
            ps.setString(1, user.getType_user());
            ps.setString(2, user.getUsername_user());
            ps.setString(3, user.getPassword_user());
            ps.setString(4, user.getFullname_user());
            ps.setString(5, user.getCorreo_user());
            ps.setInt(6, user.getId_user());
            ps.execute();
            return true;

        } catch (Exception e) {
            System.err.println(e);
            return false;

        } finally {
            try {
                c.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }

    }

    public boolean delete_user(Model_user user) {

        PreparedStatement ps = null;
        Connection c = (Connection) getConnection();

        String sql = "DELETE FROM users WHERE id_user=?";

        try {

            ps = c.prepareStatement(sql);
            ps.setInt(1, user.getId_user());
            ps.execute();
            return true;

        } catch (Exception e) {
            System.err.println(e);
            return false;

        } finally {
            try {
                c.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }

    }

    public boolean search_user(Model_user user) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection c = (Connection) getConnection();

        String sql = "SELECT * FROM USERS WHERE username_user=? AND password_user=?";

        try {

            ps = c.prepareStatement(sql);
            ps.setString(1, user.getUsername_user());
            ps.setString(2, user.getPassword_user());
            rs = ps.executeQuery();

            if (rs.next()) {

//                user.setType_user(rs.getString("type_user"));
//                user.setUsername_user(rs.getString("username_user"));
//                user.setPassword_user(rs.getString("password_user"));
//                user.setFullname_user(rs.getString("fullname_user"));
//                user.setCorreo_user(rs.getString("correo_user"));
                return true;

            }
            return false;

        } catch (Exception e) {
            System.err.print("Error en la model login");
            System.err.println(e);
            return false;

        } finally {
            try {
                c.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }

    }

}
