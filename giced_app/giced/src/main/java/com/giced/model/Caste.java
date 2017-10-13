package com.giced.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "caste")
public class Caste {
	@Id
    @Column(name = "caste_id")
    private String caste_id;

    @Column(name = "caste_name")
    private String caste_name;

	public String getCaste_id() {
		return caste_id;
	}

	public void setCaste_id(String caste_id) {
		this.caste_id = caste_id;
	}

	public String getCaste_name() {
		return caste_name;
	}

	public void setCaste_name(String caste_name) {
		this.caste_name = caste_name;
	}

	
}
