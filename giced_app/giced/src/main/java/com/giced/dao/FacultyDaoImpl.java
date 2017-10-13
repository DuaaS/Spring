package com.giced.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.giced.model.Faculty;

@Repository
public class FacultyDaoImpl implements FacultyDao {
	
	private SessionFactory sessionFactory;
    private static final int limitResultsPerPage = 10;
    
    @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

    @Override
    public void addFaculty(Faculty faculty) {
    	Session session = sessionFactory.getCurrentSession();
		session.persist(faculty);
    }

    @Override
    public void updateFaculty(Faculty faculty) {
        Session session = sessionFactory.getCurrentSession();
        session.update(faculty);
    }

    @Override
    public void removeFaculty(String id) {
        Session session = sessionFactory.getCurrentSession();
        Faculty faculty = (Faculty) session.get(Faculty.class, id);
        if (faculty != null)
            session.delete(faculty);
    }

    @Override
    public Faculty getFaculty(String id) {
        Session session = sessionFactory.getCurrentSession();
        Faculty faculty = (Faculty) session.get(Faculty.class, id);
        return faculty;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Faculty> getFaculties(Integer page) {
    	Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Faculty");
        query.setFirstResult((page - 1) * limitResultsPerPage);
        query.setMaxResults(limitResultsPerPage);
        List<Faculty> faculty = query.list();
        return faculty;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Faculty> getFaculties(String name) {
    	Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Faculty WHERE faculty_name = :name");
        query.setParameter("name", name);
        List<Faculty> faculty = query.list();
        return faculty;
    }

	@Override
	@SuppressWarnings("unchecked")
	public List<Faculty> getAllFaculties() {
		Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Faculty");
        List<Faculty> faculty = query.list();
        return faculty;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Faculty getFacultybyUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Faculty WHERE user_name = :name");
        query.setParameter("name", username);
        List<Faculty> listFaculty = query.list();
        Faculty faculty =listFaculty.get(0);
        return faculty;
	}

    
}
