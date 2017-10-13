package com.giced.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.giced.model.Attendance;



@Repository
public class AttendanceDaoImpl implements AttendanceDao {

	/*Properties prop = new Properties();
	private void loadProps() {
	    InputStream input = null;
	    try{
	    	input = getClass().getClassLoader().getResourceAsStream("config.properties");
	    	 // load a properties file
	        prop.load(input);
	    } catch (IOException ex) {
		    ex.printStackTrace();
		} 
	}*/
   
	private SessionFactory sessionFactory;
	private static final int limitResultsPerPage = 10;
   
    
    /*NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}*/

   @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
	public void addAttendance(Attendance attendance) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(attendance);
	}

	@Override
	public Attendance getAttendance(String id) {
		Session session = sessionFactory.getCurrentSession();
		Attendance attendance = (Attendance) session.get(Attendance.class, id);
        return attendance;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Attendance> getAttendances(Integer page) {
		Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Attendance");
        query.setFirstResult((page - 1) * limitResultsPerPage);
        query.setMaxResults(limitResultsPerPage);
        List<Attendance> attendance = query.list();
        return attendance;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Attendance> getAttendanceforAssignment(String assignment_id) {
		Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Attendance where assignment_id = :assignment_id");
        query.setParameter("assignment_id", assignment_id);
        List<Attendance> attendance = query.list();
        return attendance;
	}

	@Override
	public void updateAttendance(Attendance attendance) {
		Session session = sessionFactory.getCurrentSession();
        session.update(attendance);
	}

	@Override
	public void removeAttendance(String id) {
		Session session = sessionFactory.getCurrentSession();
		Attendance attendance = (Attendance) session.get(Attendance.class, id);
	     if (attendance != null)
	    	 session.delete(attendance);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Attendance> getAllAttendance() {
		Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Attendance");
        List<Attendance> attendance = query.list();
        return attendance;
	}

	
	
	
}
