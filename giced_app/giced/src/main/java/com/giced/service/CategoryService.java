package com.giced.service;

import java.util.List;

import com.giced.model.Category;



public interface CategoryService {

	void addCategory(Category cat);

    void updateCategory(Category cat);

    void removeCategory(String id);

    Category getCategory(String id);

    List<Category> getCategories(Integer page);

    List<Category> getAllCategories();
}
