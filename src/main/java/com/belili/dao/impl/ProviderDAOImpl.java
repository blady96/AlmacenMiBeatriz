package com.belili.dao.impl;

import com.belili.dao.ProviderDAO;
import com.belili.pojo.Provider;
import com.belili.service.HibernateSession;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ProviderDAOImpl implements ProviderDAO{

    @Override
    public Provider selectById(Integer id) {
        
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Provider provider = (Provider) session.get(Provider.class, id);
            return provider;
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
    public boolean selectByCode(Provider provider) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Provider> selectAll() {

        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Provider> providers = null;
        try {
            providers = session.createCriteria(Provider.class).list();
        } catch (HibernateException he) {
            System.err.println(he);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return providers;
        
    }

    @Override
    public boolean create(Provider provider) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Provider provider) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
