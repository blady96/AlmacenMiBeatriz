package com.belili.dao.impl;

import com.belili.dao.CustomerDAO;
import com.belili.pojo.Customer;
import com.belili.service.HibernateSession;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CustomerDAOImpl implements CustomerDAO{

    @Override
    public Customer selectById(Integer id) {

        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Customer customer = (Customer) session.get(Customer.class, id);
            return customer;
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
    public boolean selectByCode(Customer customer) {
        
        return false;
        
    }

    @Override
    public List<Customer> selectAll() {

        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Customer> customers = null;
        try {
            customers = session.createCriteria(Customer.class).list();
        } catch (HibernateException he) {
            System.err.println(he);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return customers;
    }

    @Override
    public boolean create(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
