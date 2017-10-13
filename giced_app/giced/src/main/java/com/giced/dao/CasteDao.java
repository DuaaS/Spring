package com.giced.dao;

import java.util.List;

import com.giced.model.Caste;



public interface CasteDao {
	void addCaste(Caste caste);

    void updateCaste(Caste caste);

    void removeCaste(String id);

    Caste getCaste(String id);

    List<Caste> getCastes(Integer page);

    List<Caste> getAllCastes();

}
