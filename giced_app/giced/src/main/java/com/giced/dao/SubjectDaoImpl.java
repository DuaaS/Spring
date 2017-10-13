package com.giced.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.giced.model.Subject;



@Repository
public class SubjectDaoImpl implements SubjectDao {

	private SessionFactory sessionFactory;
    private static final int limitResultsPerPage = 10;
    
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
    public void addSubject(Subject subject) {
    	Session session = sessionFactory.getCurrentSession();
		session.persist(subject);
    }

    @Override
    public void updateSubject(Subject subject) {
        Session session = sessionFactory.getCurrentSession();
        session.update(subject);
    }

    @Override
    public void removeSubject(String id) {
        Session session = sessionFactory.getCurrentSession();
        Subject subject = (Subject) session.get(Subject.class, id);
        if (subject != null)
            session.delete(subject);
    }

    @Override
    public Subject getSubject(String id) {
        Session session = sessionFactory.getCurrentSession();
        Subject subject = (Subject) session.get(Subject.class, id);
        return subject;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Subject> getSubjects(Integer page) {
    	Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Subject");
        query.setFirstResult((page - 1) * limitResultsPerPage);
        query.setMaxResults(limitResultsPerPage);
        List<Subject> subject = query.list();
        return subject;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Subject> getAllSubjects() {
    	Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Subject");
        List<Subject> subject = query.list();
        return subject;
    }

	


}
