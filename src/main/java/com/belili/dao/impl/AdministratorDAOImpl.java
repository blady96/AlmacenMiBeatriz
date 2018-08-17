package com.belili.dao.impl;

import com.belili.dao.AdministratorDAO;
import com.belili.pojo.Administrator;
import com.belili.service.HibernateSession;
import java.util.List;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AdministratorDAOImpl implements AdministratorDAO{
    
    @Override
    public Administrator selectById(Integer id) {

        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Administrator administrator = (Administrator) session.get(Administrator.class, id);
            return administrator;
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
    public boolean login(Administrator administrator) {
        
        boolean completed = false;
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            String hql = "FROM Administrator WHERE username_administrator = '" + administrator.getUsernameAdministrator() + "'";
            List<Administrator> administrators = session.createQuery(hql).list();
            
            for (Administrator tempAdministrator : administrators) {
                String hash = DigestUtils.sha1Hex(administrator.getPasswordAdministrator());
                if (tempAdministrator.getPasswordAdministrator().equals(hash)) {
                    administrator.setIdAdministrator(tempAdministrator.getIdAdministrator());
                    administrator.setImageAdministrator(tempAdministrator.getImageAdministrator());
                    administrator.setUsernameAdministrator(tempAdministrator.getUsernameAdministrator());
                    administrator.setPasswordAdministrator(tempAdministrator.getPasswordAdministrator());
                    administrator.setFullnameAdministrator(tempAdministrator.getFullnameAdministrator());
                    administrator.setCorreoAdministrator(tempAdministrator.getCorreoAdministrator());
                    administrator.setPhoneAdministrator(tempAdministrator.getPhoneAdministrator());
                    System.out.println(administrator.toString());
                    completed = true;
                    break;
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
    public boolean update(Administrator administrator) {
        
        boolean completed = false;
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            String passwordHash = DigestUtils.sha1Hex(administrator.getPasswordAdministrator());
            administrator.setPasswordAdministrator(passwordHash);
            session.merge(administrator);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return completed;
    }
    
}
