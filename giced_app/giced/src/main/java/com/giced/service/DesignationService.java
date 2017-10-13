package com.giced.service;

import java.util.List;

import com.giced.model.Designation;



public interface DesignationService {

	void addDesignation(Designation designation);

    void updateDesignation(Designation designation);

    void removeDesignation(String id);

    Designation getDesignation(String id);

    List<Designation> getDesignations(Integer page);

    List<Designation> getAllDesignations();
}
