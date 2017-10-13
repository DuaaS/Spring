package com.giced.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.giced.dao.TitleDao;
import com.giced.model.Title;

@Service
@Component
public class TitleServiceImpl implements TitleService {
	
	@Autowired
	private TitleDao titleDao;

	@Autowired	
    public TitleDao getTitleDao() {
		return titleDao;
	}

	@Autowired
	public void setTitleDao(TitleDao titleDao) {
		this.titleDao = titleDao;
	}

	@Override
    @Transactional
	public void addTitle(Title title){
    	titleDao.addTitle(title);
	}

    @Override
    @Transactional
	public void updateTitle(Title title) {
    	titleDao.updateTitle(title);
	}

    @Override
    @Transactional
    public void removeTitle(String id) {
    	titleDao.removeTitle(id);
	}

    @Override
    @Transactional
	public Title getTitle(String id){
		return titleDao.getTitle(id);
	}

    @Override
    @Transactional
	public List<Title> getTitles(Integer page) {
    	return titleDao.getTitles(page);
	}

    @Override
    @Transactional
	public List<Title> getAllTitles(){
		return titleDao.getAllTitles();
	}

}
