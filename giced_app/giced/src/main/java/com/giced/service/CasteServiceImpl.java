package com.giced.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.giced.dao.CasteDao;
import com.giced.model.Caste;

@Service
@Component
public class CasteServiceImpl implements CasteService {
	
	@Autowired
	private CasteDao casteDao;

	@Autowired
    public void setCasteDao(CasteDao casteDao) {
        this.casteDao = casteDao;
    }

	@Autowired
    public CasteDao getCasteDao() {
         return casteDao;
    }
	
    @Override
    @Transactional
	public void addCaste(Caste caste) {
    	casteDao.addCaste(caste);

	}

    @Override
    @Transactional
	public void updateCaste(Caste caste) {
    	casteDao.updateCaste(caste);
	}

    @Override
    @Transactional
    public void removeCaste(String id) {
    	casteDao.removeCaste(id);
	}

    @Override
    @Transactional
	public Caste getCaste(String id) {
		return casteDao.getCaste(id);
	}

    @Override
    @Transactional
	public List<Caste> getCastes(Integer page) {
    	return casteDao.getCastes(page);
	}

    @Override
    @Transactional
	public List<Caste> getAllCastes() {
		return casteDao.getAllCastes();
	}

}
