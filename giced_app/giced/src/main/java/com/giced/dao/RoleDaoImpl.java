package com.giced.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.giced.model.Role;



@Repository
public class RoleDaoImpl implements RoleDao {

	private SessionFactory sessionFactory;
    private static final int limitResultsPerPage = 10;
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
    
    @Override
    public void addRole(Role role){
    	Session session = sessionFactory.getCurrentSession();
		session.persist(role);
    }

   	@Override
    public void updateRole(Role role) {
        Session session = sessionFactory.getCurrentSession();
        session.update(role);
    }

    @Override
    public void removeRole(String id) {
        Session session = sessionFactory.getCurrentSession();
        Role role = (Role) session.get(Role.class, id);
        if (role != null)
            session.delete(role);
    }

    @Override
    public Role getRole(String id) {
        Session session = sessionFactory.getCurrentSession();
        Role role = (Role) session.get(Role.class, id);
        return role;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Role> getRoles(Integer page) {
    	Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Role");
        query.setFirstResult((page - 1) * limitResultsPerPage);
        query.setMaxResults(limitResultsPerPage);
        List<Role> role = query.list();
        return role;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Role> getAllRoles(){
    	Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Role");
        List<Role> role = query.list();
        return role;
    }

	


}
