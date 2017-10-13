package com.giced.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subcaste")
public class SubCaste {
	@Id
    @Column(name = "subcaste_id")
    private String subcaste_id;

    @Column(name = "subcaste_name")
    private String subcaste_name;
    
    @Column(name = "caste_id")
    private String caste_id;

	public String getSubcaste_id() {
		return subcaste_id;
	}

	public void setSubcaste_id(String subcaste_id) {
		this.subcaste_id = subcaste_id;
	}

	public String getSubcaste_name() {
		return subcaste_name;
	}

	public void setSubcaste_name(String subcaste_name) {
		this.subcaste_name = subcaste_name;
	}

	public String getCaste_id() {
		return caste_id;
	}

	public void setCaste_id(String caste_id) {
		this.caste_id = caste_id;
	}

	
}
