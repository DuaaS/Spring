package com.giced.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "duration")
public class Duration {
	@Id
    @Column(name = "duration_id")
    private String duration_id;

    @Column(name = "duration_name")
    private String duration_name;
    
    @Column(name = "duration_description")
    private String duration_description;

	public String getDuration_id() {
		return duration_id;
	}

	public void setDuration_id(String duration_id) {
		this.duration_id = duration_id;
	}

	public String getDuration_name() {
		return duration_name;
	}

	public void setDuration_name(String duration_name) {
		this.duration_name = duration_name;
	}

	public String getDuration_description() {
		return duration_description;
	}

	public void setDuration_description(String duration_description) {
		this.duration_description = duration_description;
	}
    
	
}
