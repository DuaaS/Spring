package com.giced.service;

import java.util.List;

import com.giced.model.SubCaste;



public interface SubCasteService {

	void addSubCaste(SubCaste subcaste);

    void updateSubCaste(SubCaste subcaste);

    void removeSubCaste(String id);

    SubCaste getSubCaste(String id);

    List<SubCaste> getSubCastes(Integer page);

    List<SubCaste> getSubCasteforCaste(String caste_id);
    
    List<SubCaste> getAllSubCastes();
}
