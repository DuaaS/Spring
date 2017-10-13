package com.giced.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.giced.model.Title;



@Repository
public class TitleDaoImpl implements TitleDao {

	private SessionFactory sessionFactory;
    private static final int limitResultsPerPage = 10;
    
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
    public void addTitle(Title title) {
    	Session session = sessionFactory.getCurrentSession();
		session.persist(title);
    }

    @Override
    public void updateTitle(Title title) {
        Session session = sessionFactory.getCurrentSession();
        session.update(title);
    }

    @Override
    public void removeTitle(String id) {
        Session session = sessionFactory.getCurrentSession();
        Title title = (Title) session.get(Title.class, id);
        if (title != null)
            session.delete(title);
    }

    @Override
    public Title getTitle(String id){
        Session session = sessionFactory.getCurrentSession();
        Title title = (Title) session.get(Title.class, id);
        return title;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Title> getTitles(Integer page) {
    	Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Title");
        query.setFirstResult((page - 1) * limitResultsPerPage);
        query.setMaxResults(limitResultsPerPage);
        List<Title> title = query.list();
        return title;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Title> getAllTitles() {
    	Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Title");
        List<Title> title = query.list();
        return title;
    }

	


}
