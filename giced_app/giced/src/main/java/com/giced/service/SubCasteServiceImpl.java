package com.giced.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.giced.dao.SubCasteDao;
import com.giced.model.SubCaste;



public class SubCasteServiceImpl implements SubCasteService {
	
	private SubCasteDao subcasteDao;
	
	@Autowired
	public SubCasteDao getSubcasteDao() {
		return subcasteDao;
	}

	@Autowired
	public void setSubcasteDao(SubCasteDao subcasteDao) {
		this.subcasteDao = subcasteDao;
	}

	@Override
	@Transactional
	public void addSubCaste(SubCaste subcaste) {
		subcasteDao.addSubCaste(subcaste);
	}

	@Override
	@Transactional
	public void updateSubCaste(SubCaste subcaste) {
		subcasteDao.updateSubCaste(subcaste);
	}

	@Override
	@Transactional
	public void removeSubCaste(String id) {
		subcasteDao.removeSubCaste(id);
	}

	@Override
	@Transactional
	public SubCaste getSubCaste(String id) {
		return subcasteDao.getSubCaste(id);
	}

	@Override
	@Transactional
	public List<SubCaste> getSubCastes(Integer page) {
		return subcasteDao.getSubCastes(page);
	}

	@Override
	@Transactional
	public List<SubCaste> getSubCasteforCaste(String caste_id) {
		return subcasteDao.getSubCasteforCaste(caste_id);
	}

	@Override
	@Transactional
	public List<SubCaste> getAllSubCastes() {
		return subcasteDao.getAllSubCastes();
	}

	
}
