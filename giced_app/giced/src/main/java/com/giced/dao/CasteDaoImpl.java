package com.giced.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.giced.model.Caste;



@Repository
public class CasteDaoImpl implements CasteDao {

	private SessionFactory sessionFactory;
    private static final int limitResultsPerPage = 10;
    
    @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addCaste(Caste caste) {
    	Session session = sessionFactory.getCurrentSession();
		session.persist(caste);
    }

    @Override
    public void updateCaste(Caste caste) {
        Session session = sessionFactory.getCurrentSession();
        session.update(caste);
    }

    @Override
    public void removeCaste(String id) {
        Session session = sessionFactory.getCurrentSession();
        Caste caste = (Caste) session.get(Caste.class, id);
        if (caste != null)
            session.delete(caste);
    }

    @Override
    public Caste getCaste(String id) {
        Session session = sessionFactory.getCurrentSession();
        Caste caste = (Caste) session.get(Caste.class, id);
        return caste;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Caste> getCastes(Integer page) {
    	Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Caste");
        query.setFirstResult((page - 1) * limitResultsPerPage);
        query.setMaxResults(limitResultsPerPage);
        List<Caste> caste = query.list();
        return caste;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public List<Caste> getAllCastes() {
    	Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Caste");
        List<Caste> caste = query.list();
        return caste;
    }

    
}
