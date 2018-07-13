package com.belili.model;

import com.belili.view.View_createUser;
import com.belili.view.View_main;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;

public class Model_queries extends Model_connect {

    public static BufferedImage bufferedImage;

    public boolean create_user(Model_user user, FileInputStream fileInputStream, File fichero) {

        PreparedStatement ps = null;
        Connection c = (Connection) getConnection();

//        String sql = "INSERT INTO users (type_user,username_user,password_user,"
//                + "fullname_user,correo_user) VALUES (?,?,?,?,?)";
        String sql = "CALL REGISTRAR_USUARIO (?,?,?,?,?,?,?)";

        try {

            ps = c.prepareStatement(sql);
            ps.setString(1, user.getType_user());
            ps.setBinaryStream(2, fileInputStream, (int) fichero.length());
            ps.setString(3, user.getUsername_user());
            ps.setString(4, user.getPassword_user());
            ps.setString(5, user.getFullname_user());
            ps.setString(6, user.getCorreo_user());
            ps.setString(7, user.getPhone_user());
            ps.execute();
            return true;

        } catch (Exception e) {
            System.err.println("ERROR EN EL CATCH 1");
            return false;

        } finally {
            try {
                c.close();
            } catch (Exception e) {
                System.err.println("ERROR EN CATCH 2");
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

                user.setId_user(rs.getInt("id_user"));
                user.setCode_user(rs.getString("code_user"));
                user.setType_user(rs.getString("type_user"));
                Blob blob = rs.getBlob("img_user");
                user.setFullname_user(rs.getString("fullname_user"));
                user.setCorreo_user(rs.getString("correo_user"));
                user.setPhone_user(rs.getString("phone_user"));

                byte[] data = blob.getBytes(1, (int) blob.length());
                bufferedImage = null;

                try {
                    bufferedImage = ImageIO.read(new ByteArrayInputStream(data));
                } catch (IOException ex) {
                    //Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
                user.setImg_user(bufferedImage);
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
    
    public boolean search_user2(Model_user user) {

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

                user.setId_user(rs.getInt("id_user"));
                user.setCode_user(rs.getString("code_user"));
                user.setType_user(rs.getString("type_user"));
                //Blob blob = rs.getBlob("img_user");
                user.setFullname_user(rs.getString("fullname_user"));
                user.setCorreo_user(rs.getString("correo_user"));
                user.setPhone_user(rs.getString("phone_user"));

//                byte[] data = blob.getBytes(1, (int) blob.length());
//                bufferedImage = null;
//
//                try {
//                    bufferedImage = ImageIO.read(new ByteArrayInputStream(data));
//                } catch (IOException ex) {
//                    //Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
//                }
                //user.setImg_user(bufferedImage);
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
