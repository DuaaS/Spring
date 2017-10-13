package com.giced.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.giced.model.Assignment;



@Repository
public class AssignmentDaoImpl implements AssignmentDao {

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
    
    @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
	public void addAssignment(Assignment assignment) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(assignment);
	}

	@Override
	public void updateAssignment(Assignment assignment) {
		Session session = sessionFactory.getCurrentSession();
        session.update(assignment);
	}

	@Override
	public void removeAssignment(String id) {
		 Session session = sessionFactory.getCurrentSession();
	     Assignment assignment = (Assignment) session.get(Assignment.class, id);
	     if (assignment != null)
	    	 session.delete(assignment);
	}

	@Override
	public Assignment getAssignment(String id) {
		Session session = sessionFactory.getCurrentSession();
		Assignment assignment = (Assignment) session.get(Assignment.class, id);
        return assignment;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Assignment> getAssignments(Integer page) {
		Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Assignment");
        query.setFirstResult((page - 1) * limitResultsPerPage);
        query.setMaxResults(limitResultsPerPage);
        List<Assignment> assignment = query.list();
        return assignment;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Assignment> getAssignmentforData(String course_id, String subject_id, String faculty_id) {
		Session session = sessionFactory.getCurrentSession();
		Query query=null;
		/*String myQuery="FROM Attendance att, Assignment ass WHERE att.assignment_id = ass.assignment_id ";
        if(course_id != "NONE") myQuery=myQuery+" AND course_id =  :course_id ";
        if(subject_id != "NONE") myQuery=myQuery+" AND subject_id = :subject_id ";
        if(faculty_id != "NONE") myQuery=myQuery+" AND faculty_id =  :faculty_id ";
     
        query=session.createQuery(myQuery);
        if(course_id != "NONE") query.setParameter("course_id",course_id);
        if(subject_id != "NONE") query.setParameter("subject_id",subject_id);
        if(faculty_id != "NONE") query.setParameter("faculty_id",faculty_id);*/
        
		if(course_id.equals("NONE") && subject_id.equals("NONE") && faculty_id.equals("NONE"))
		{
	        query = session.createQuery("FROM Assignment");
		}
		else if(!course_id.equals("NONE") && subject_id.equals("NONE") && faculty_id.equals("NONE"))
		{
			query = session.createQuery("FROM Assignment WHERE course_id = :course_id");
	        query.setParameter("course_id", course_id);
	        
		}
		else if(!course_id.equals("NONE") && !subject_id.equals("NONE") && faculty_id.equals("NONE"))
		{
			query = session.createQuery("FROM Assignment WHERE course_id = :course_id AND subject_id = :subject_id ");
	        query.setParameter("course_id", course_id);
	        query.setParameter("subject_id", subject_id);
		}
		else if(course_id.equals("NONE") && !subject_id.equals("NONE") && !faculty_id.equals("NONE")) {
			query = session.createQuery("FROM Assignment WHERE subject_id = :subject_id AND faculty_id = :faculty_id ");
	        query.setParameter("subject_id", subject_id);
	        query.setParameter("faculty_id", faculty_id);	
		}
		else if(!course_id.equals("NONE") && subject_id.equals("NONE") && !faculty_id.equals("NONE")) {
			query = session.createQuery("FROM Assignment WHERE course_id = :course_id AND faculty_id = :faculty_id ");
	        query.setParameter("course_id", course_id);
	        query.setParameter("faculty_id", faculty_id);
		}
		else if(course_id.equals("NONE") && !subject_id.equals("NONE") && faculty_id.equals("NONE")) {
			query = session.createQuery("FROM Assignment WHERE subject_id = :subject_id ");
	        query.setParameter("subject_id", subject_id);
		}
		else if(course_id.equals("NONE") && subject_id.equals("NONE") && !faculty_id.equals("NONE")) {
			query = session.createQuery("FROM Assignment WHERE faculty_id = :faculty_id ");
	        query.setParameter("faculty_id", faculty_id);
		}
		else if(course_id !=null && subject_id != null && faculty_id != null)
		{
			query = session.createQuery("FROM Assignment WHERE course_id = :course_id AND subject_id = :subject_id AND faculty_id = :faculty_id ");
	        query.setParameter("course_id", course_id);
	        query.setParameter("subject_id", subject_id);
	        query.setParameter("faculty_id", faculty_id);
		}
        List<Assignment> assignment = query.list();
        return assignment;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Assignment> getAssignmentforFaculty(String faculty_id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Assignment WHERE faculty_id = :faculty_id");
	    query.setParameter("faculty_id", faculty_id);
		List<Assignment> assignment = query.list();
        return assignment;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Assignment> getAllAssignments() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Assignment");
	    List<Assignment> assignment = query.list();
        return assignment;
	}

    

	


}
