package com.giced.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject {
	@Id
    @Column(name = "subject_id")
    private String subject_id;

    @Column(name = "subject_name")
    private String subject_name;
    
    @Column(name = "subject_duration")
    private String subject_duration;

	public String getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(String subject_id) {
		this.subject_id = subject_id;
	}

	public String getSubject_name() {
		return subject_name;
	}

	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}

	public String getSubject_duration() {
		return subject_duration;
	}

	public void setSubject_duration(String subject_duration) {
		this.subject_duration = subject_duration;
	}

	
	
}
