package com.giced.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.giced.model.Category;



@Repository
public class CategoryDaoImpl implements CategoryDao {

	private SessionFactory sessionFactory;
    private static final int limitResultsPerPage = 10;
    
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
    public void addCategory(Category cat) {
    	Session session = sessionFactory.getCurrentSession();
		session.persist(cat);
    }

    @Override
    public void updateCategory(Category cat) {
        Session session = sessionFactory.getCurrentSession();
        session.update(cat);
    }

    @Override
    public void removeCategory(String id) {
        Session session = sessionFactory.getCurrentSession();
        Category cat = (Category) session.get(Category.class, id);
        if (cat != null)
            session.delete(cat);
    }

    @Override
    public Category getCategory(String id) {
        Session session = sessionFactory.getCurrentSession();
        Category cat = (Category) session.get(Category.class, id);
        return cat;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Category> getCategories(Integer page) {
    	Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Category");
        query.setFirstResult((page - 1) * limitResultsPerPage);
        query.setMaxResults(limitResultsPerPage);
        List<Category> cat = query.list();
        return cat;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Category> getAllCategories() {
    	Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Category");
        List<Category> cat = query.list();
        return cat;
    }

	


}
