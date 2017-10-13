package com.giced.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.giced.dao.CategoryDao;
import com.giced.model.Category;

@Service
@Component
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao catDao;

	@Autowired  
    public CategoryDao getCatDao() {
		return catDao;
	}

	@Autowired
    public void setCatDao(CategoryDao catDao) {
		this.catDao = catDao;
	}

	@Override
    @Transactional
	public void addCategory(Category cat) {
    	catDao.addCategory(cat);

	}

    @Override
    @Transactional
	public void updateCategory(Category cat) {
    	catDao.updateCategory(cat);
	}

    @Override
    @Transactional
    public void removeCategory(String id) {
    	catDao.removeCategory(id);
	}

    @Override
    @Transactional
	public Category getCategory(String id) {
		return catDao.getCategory(id);
	}

    @Override
    @Transactional
	public List<Category> getCategories(Integer page) {
    	return catDao.getCategories(page);
	}

    @Override
    @Transactional
	public List<Category> getAllCategories(){
		return catDao.getAllCategories();
	}

}
