package com.giced.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.giced.model.Appointment_Type;



@Repository
public class AppointmentDaoImpl implements AppointmentDao {

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
    public void addAppointment(Appointment_Type appt) {
    	Session session = sessionFactory.getCurrentSession();
		session.persist(appt);
    }

    @Override
    public void updateAppointment(Appointment_Type appt) {
        Session session = sessionFactory.getCurrentSession();
        session.update(appt);
    }

    @Override
    public void removeAppointment(String id) {
        Session session = sessionFactory.getCurrentSession();
        Appointment_Type appt = (Appointment_Type) session.get(Appointment_Type.class, id);
        if (appt != null)
            session.delete(appt);
    }

    @Override
    public Appointment_Type getAppointment(String id) {
        Session session = sessionFactory.getCurrentSession();
        Appointment_Type appt = (Appointment_Type) session.get(Appointment_Type.class, id);
        return appt;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Appointment_Type> getAppointments(Integer page) {
    	Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Appointment_Type");
        query.setFirstResult((page - 1) * limitResultsPerPage);
        query.setMaxResults(limitResultsPerPage);
        List<Appointment_Type> appt = query.list();
        return appt;
    }

    @Override
	@SuppressWarnings("unchecked")
	public List<Appointment_Type> getAllAppointments() {
		Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Appointment_Type");
        List<Appointment_Type> appt = query.list();
        return appt;
	}

	


}
