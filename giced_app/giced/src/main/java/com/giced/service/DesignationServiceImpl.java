package com.giced.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.giced.dao.DesignationDao;
import com.giced.model.Designation;

@Service
@Component
public class DesignationServiceImpl implements DesignationService {
	
	@Autowired
	private DesignationDao designationDao;

	@Autowired	
    public DesignationDao getDesignationDao() {
		return designationDao;
	}

	@Autowired
	public void setDesignationDao(DesignationDao designationDao) {
		this.designationDao = designationDao;
	}

	@Override
    @Transactional
	public void addDesignation(Designation designation) {
		designationDao.addDesignation(designation);

	}

    @Override
    @Transactional
	public void updateDesignation(Designation designation) {
    	designationDao.updateDesignation(designation);
	}

    @Override
    @Transactional
    public void removeDesignation(String id) {
    	designationDao.removeDesignation(id);
	}

    @Override
    @Transactional
	public Designation getDesignation(String id) {
		return designationDao.getDesignation(id);
	}

    @Override
    @Transactional
	public List<Designation> getDesignations(Integer page) {
    	return designationDao.getDesignations(page);
	}

    @Override
    @Transactional
	public List<Designation> getAllDesignations() {
		return designationDao.getAllDesignations();
	}

}
