package com.giced.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.giced.model.Countries;



@Repository
public class CountriesDaoImpl implements CountriesDao {

	private SessionFactory sessionFactory;
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
    
    
    @Override
    @SuppressWarnings("unchecked")
    public List<Countries> getAllCountries(){
    	Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Countries");
        List<Countries> countries = query.list();
        return countries;
    }


	@Override
	public Countries getCountry(int id) {
		Session session = sessionFactory.getCurrentSession();
        Countries countries = (Countries) session.get(Countries.class, id);
        return countries;
	}

	


}
