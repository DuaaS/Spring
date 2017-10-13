package com.giced.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.giced.model.SubCaste;



@Repository
public class SubCasteDaoImpl implements SubCasteDao {

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
    public void addSubCaste(SubCaste subcaste) {
    	Session session = sessionFactory.getCurrentSession();
		session.persist(subcaste);
    }

    @Override
    public void updateSubCaste(SubCaste subcaste) {
        Session session = sessionFactory.getCurrentSession();
        session.update(subcaste);
    }

    @Override
    public void removeSubCaste(String id) {
        Session session = sessionFactory.getCurrentSession();
        SubCaste subcaste = (SubCaste) session.get(SubCaste.class, id);
        if (subcaste != null)
            session.delete(subcaste);
    }

    @Override
    public SubCaste getSubCaste(String id) {
        Session session = sessionFactory.getCurrentSession();
        SubCaste subcaste = (SubCaste) session.get(SubCaste.class, id);
        return subcaste;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<SubCaste> getSubCastes(Integer page) {
    	Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM SubCaste");
        query.setFirstResult((page - 1) * limitResultsPerPage);
        query.setMaxResults(limitResultsPerPage);
        List<SubCaste> subcaste = query.list();
        return subcaste;
    }

    
    @Override
    @SuppressWarnings("unchecked")
    public List<SubCaste> getSubCasteforCaste(String caste_id) {
    	Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM SubCaste WHERE caste_id = :caste_id");
        query.setParameter("caste_id", caste_id);
        List<SubCaste> subcaste = query.list();
        return subcaste;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public List<SubCaste> getAllSubCastes(){
    	Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM SubCaste ");
        List<SubCaste> subcaste = query.list();
        return subcaste;
    }

	


}
