package com.giced.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.giced.model.Duration;



@Repository
public class DurationDaoImpl implements DurationDao {

	private SessionFactory sessionFactory;
    private static final int limitResultsPerPage = 10;
    
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
    public void addDuration(Duration duration) {
    	Session session = sessionFactory.getCurrentSession();
		session.persist(duration);
    }

    @Override
    public void updateDuration(Duration duration) {
        Session session = sessionFactory.getCurrentSession();
        session.update(duration);
    }

    @Override
    public void removeDuration(String id) {
        Session session = sessionFactory.getCurrentSession();
        Duration duration = (Duration) session.get(Duration.class, id);
        if (duration != null)
            session.delete(duration);
    }

    @Override
    public Duration getDuration(String id) {
        Session session = sessionFactory.getCurrentSession();
        Duration duration = (Duration) session.get(Duration.class, id);
        return duration;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Duration> getDurations(Integer page) {
    	Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Duration");
        query.setFirstResult((page - 1) * limitResultsPerPage);
        query.setMaxResults(limitResultsPerPage);
        List<Duration> duration = query.list();
        return duration;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Duration> getAllDurations() {
    	Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Duration");
        List<Duration> duration = query.list();
        return duration;
    }

	


}
