package com.giced.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "title")
public class Title {
	@Id
    @Column(name = "title_id")
    private String title_id;

    @Column(name = "title_name")
    private String title_name;
    
    @Column(name = "title_description")
    private String title_description;

	public String getTitle_id() {
		return title_id;
	}

	public void setTitle_id(String title_id) {
		this.title_id = title_id;
	}

	public String getTitle_name() {
		return title_name;
	}

	public void setTitle_name(String title_name) {
		this.title_name = title_name;
	}

	public String getTitle_description() {
		return title_description;
	}

	public void setTitle_description(String title_description) {
		this.title_description = title_description;
	}

	
}
