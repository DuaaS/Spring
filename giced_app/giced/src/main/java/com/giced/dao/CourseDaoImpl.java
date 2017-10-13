package com.giced.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.giced.model.Course;



@Repository
public class CourseDaoImpl implements CourseDao {

	private SessionFactory sessionFactory;
    private static final int limitResultsPerPage = 10;
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
    
    @Override
    public void addCourse(Course course){
    	Session session = sessionFactory.getCurrentSession();
		session.persist(course);
    }

   	@Override
    public void updateCourse(Course course){
        Session session = sessionFactory.getCurrentSession();
        session.update(course);
    }

    @Override
    public void removeCourse(String id) {
        Session session = sessionFactory.getCurrentSession();
        Course course = (Course) session.get(Course.class, id);
        if (course != null)
            session.delete(course);
    }

    @Override
    public Course getCourse(String id) {
        Session session = sessionFactory.getCurrentSession();
        Course course = (Course) session.get(Course.class, id);
        return course;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Course> getCourses(Integer page) {
    	Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Course");
        query.setFirstResult((page - 1) * limitResultsPerPage);
        query.setMaxResults(limitResultsPerPage);
        List<Course> course = query.list();
        return course;
    }

	@Override
	@SuppressWarnings("unchecked")
	public List<Course> getAllCourses() {
		Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Course");
        List<Course> course = query.list();
        return course;
	}


}
