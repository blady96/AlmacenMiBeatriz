package com.belili.dao.impl;

import com.belili.dao.UserDAO;
import com.belili.pojo.User;
import com.belili.service.HibernateSession;
import com.belili.service.JDBCSession;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import org.apache.commons.codec.digest.DigestUtils;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserDAOImpl implements UserDAO{

    @Override
    public User selectById(Integer id) {

        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            User user = (User) session.get(User.class, id);
            return user;
        } catch (HibernateException eh) {
            System.err.print(eh);
            return null;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean selectByCode(User user) {

        boolean completed = false;
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            String hql = "FROM User WHERE code_user = '" + user.getCodeUser() + "'";
            List<User> users = session.createQuery(hql).list();

            for (User tempUser : users) {
                user.setIdUser(tempUser.getIdUser());
                user.setImageUser(tempUser.getImageUser());
                user.setCodeUser(tempUser.getCodeUser());
                user.setPasswordUser(tempUser.getPasswordUser());
                user.setFullnameUser(tempUser.getFullnameUser());
                user.setCorreoUser(tempUser.getCorreoUser());
                user.setPhone1User(tempUser.getPhone1User());
                user.setPhone2User(tempUser.getPhone2User());
                user.setDateUser(tempUser.getDateUser());
                user.setStateUser(tempUser.isStateUser());
                user.setPermissionMaintenanceUser(tempUser.isPermissionMaintenanceUser());
                user.setPermissionPurchaseUser(tempUser.isPermissionPurchaseUser());
                user.setPermissionSaleUser(tempUser.isPermissionSaleUser());
                user.setPermissionWarehouseUser(tempUser.isPermissionWarehouseUser());
                System.out.println(user.toString());
                completed = true;
                break;
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return completed;
    }

    @Override
    public List<User> selectAll() {

        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<User> users = null;
        try {
            users = session.createCriteria(User.class).list();
        } catch (HibernateException he) {
            System.err.println(he);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return users;
    }

    @Override
    public boolean login(User user) {

        boolean completed = false;
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            String hql = "FROM User WHERE code_user = '" + user.getCodeUser() + "'";
            List<User> users = session.createQuery(hql).list();

            for (User tempUser : users) {
                String hash = DigestUtils.sha1Hex(user.getPasswordUser());
                if (tempUser.getPasswordUser().equals(hash)) {

                    /*   GENERATING CURRENT DATE ~ JVM(JAVA VIRTUAL MACHINE)   */
//                    java.util.Date dateUtil = new Date();
//                    long dateLong = dateUtil.getTime();
//                    java.sql.Date dateSQL = new java.sql.Date(dateLong);
//                    System.out.println("DATE TODAY ==> " + dateSQL);
                    /* ------------------------------ */
                    
//                    if ((tempUser.isStateUser()) || (dateSQL.compareTo(tempUser.getDateUser()) < 0)) {
                    if ((tempUser.isStateUser())) {
                        user.setIdUser(tempUser.getIdUser());
                        user.setImageUser(tempUser.getImageUser());
                        user.setCodeUser(tempUser.getCodeUser());
                        user.setPasswordUser(tempUser.getPasswordUser());    
                        user.setFullnameUser(tempUser.getFullnameUser());
                        user.setCorreoUser(tempUser.getCorreoUser());
                        user.setPhone1User(tempUser.getPhone1User());
                        user.setPhone2User(tempUser.getPhone2User());
                        user.setDateUser(null);
                        user.setStateUser(true);
                        user.setPermissionMaintenanceUser(true);
                        user.setPermissionPurchaseUser(true);
                        user.setPermissionSaleUser(true);
                        user.setPermissionWarehouseUser(true);
                        
                        update(user);
                        System.out.println(user.toString());
                        completed = true;
                        break;
                    }
                }
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return completed;
    }

    @Override
    public boolean create(User user) {

        boolean completed = false;
        PreparedStatement ps = null;
        JDBCSession jdbcs = new JDBCSession();
        Connection c = (Connection) jdbcs.getConnection();
        String sql = "CALL Register_User (?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            ps = c.prepareStatement(sql);
            Blob blob = user.getImageUser();
            int blobLength = (int) blob.length();
            byte[] blobAsBytes = blob.getBytes(1, blobLength);
            ps.setBytes(1, blobAsBytes);
            String passwordHash = DigestUtils.sha1Hex(user.getPasswordUser());
            ps.setString(2, passwordHash);
            ps.setString(3, user.getFullnameUser());
            ps.setString(4, user.getCorreoUser());
            ps.setString(5, user.getPhone1User());
            ps.setString(6, user.getPhone2User());
            long date = user.getDateUser().getTime();
            ps.setDate(7, new java.sql.Date(date));
            ps.setBoolean(8, user.isStateUser());
            ps.setBoolean(9, user.isPermissionMaintenanceUser());
            ps.setBoolean(10, user.isPermissionPurchaseUser());
            ps.setBoolean(11, user.isPermissionSaleUser());
            ps.setBoolean(12, user.isPermissionWarehouseUser());
            ps.execute();
            completed = true;
            return completed;

        } catch (SQLException sqle) {
            System.err.println(sqle);
            return completed;

        } catch (Exception e) {
            System.err.println(e);
            return completed;
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
    }

    @Override
    public boolean createTest(User user) {

        boolean completed = false;
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            String passwordHash = DigestUtils.sha1Hex(user.getPasswordUser());
            user.setPasswordUser(passwordHash);
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return completed;
    }

    @Override
    public boolean update(User user) {

        boolean completed = false;
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.merge(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return completed;
    }

}
