package com.giced.dao;

import java.util.List;

import com.giced.model.SubCaste;



public interface SubCasteDao {
	void addSubCaste(SubCaste subcaste);

    void updateSubCaste(SubCaste subcaste);

    void removeSubCaste(String id);

    SubCaste getSubCaste(String id);

    List<SubCaste> getSubCastes(Integer page);

    List<SubCaste> getSubCasteforCaste(String caste_id);
    
    List<SubCaste> getAllSubCastes();

}
