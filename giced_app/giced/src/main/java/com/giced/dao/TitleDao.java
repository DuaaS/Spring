package com.giced.dao;

import java.util.List;

import com.giced.model.Title;



public interface TitleDao {
	void addTitle(Title title);

    void updateTitle(Title title);

    void removeTitle(String id);

    Title getTitle(String id);

    List<Title> getTitles(Integer page);

    List<Title> getAllTitles();

}
