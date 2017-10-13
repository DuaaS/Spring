package com.giced.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.giced.model.Designation;

@Repository
public class DesignationDaoImpl implements DesignationDao {
	
	private SessionFactory sessionFactory;
	
	@Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private static final int limitResultsPerPage = 10;

	@Override
	public void addDesignation(Designation designation) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(designation);
	}

	@Override
	public void updateDesignation(Designation designation) {
		Session session = sessionFactory.getCurrentSession();
        session.update(designation);
	}

	@Override
	public void removeDesignation(String id) {
		Session session = sessionFactory.getCurrentSession();
        Designation designation = (Designation) session.get(Designation.class, id);
        if (designation != null)
            session.delete(designation);
	}

	@Override
	public Designation getDesignation(String id) {
		Session session = sessionFactory.getCurrentSession();
        Designation designation = (Designation) session.get(Designation.class, id);
        return designation;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Designation> getDesignations(Integer page) {
		Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Designation");
        query.setFirstResult((page - 1) * limitResultsPerPage);
        query.setMaxResults(limitResultsPerPage);
        List<Designation> designation = query.list();
        return designation;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Designation> getAllDesignations() {
		Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Designation");
        List<Designation> designation = query.list();
        return designation;
	}

}
