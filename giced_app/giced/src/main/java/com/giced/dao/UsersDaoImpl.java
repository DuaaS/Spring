package com.giced.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.giced.model.Users;



@Repository
public class UsersDaoImpl implements UsersDao {

	private SessionFactory sessionFactory;
    private static final int limitResultsPerPage = 10;
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
    
    @Override
    public void addUser(Users users){
    	Session session = sessionFactory.getCurrentSession();
		session.persist(users);
    }

   	@Override
    public void updateUser(Users users) {
        Session session = sessionFactory.getCurrentSession();
        session.update(users);
    }

    @Override
    public void removeUser(String id) {
        Session session = sessionFactory.getCurrentSession();
        Users users = (Users) session.get(Users.class, id);
        if (users != null)
            session.delete(users);
    }

    @Override
    public Users getUser(String id) {
        Session session = sessionFactory.getCurrentSession();
        Users users = (Users) session.get(Users.class, id);
        return users;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Users> getUsers(Integer page) {
    	Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Users");
        query.setFirstResult((page - 1) * limitResultsPerPage);
        query.setMaxResults(limitResultsPerPage);
        List<Users> users = query.list();
        return users;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Users> getUsers(String name) {
    	Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Users WHERE user_name = :name");
        query.setParameter("name", name);
        List<Users> users = query.list();
        return users;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public List<Users> validateUser(String name, String pass) {
    	Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Users WHERE user_name = :name AND user_password = :pass ");
        query.setParameter("name", name);
        query.setParameter("pass", pass);
        List<Users> user = query.list();
       return user;
    }

	@Override
	@SuppressWarnings("unchecked")
	public List<Users> getAllUsers() {
		Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Users");
        List<Users> user = query.list();
        return user;
	}

	


}
