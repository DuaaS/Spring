package com.giced.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "appointment_type")
public class Appointment_Type {
	@Id
    @Column(name = "appointment_id")
    private String appointment_id;

    @Column(name = "appointment_name")
    private String appointment_name;

	public String getAppointment_id() {
		return appointment_id;
	}

	public void setAppointment_id(String appointment_id) {
		this.appointment_id = appointment_id;
	}

	public String getAppointment_name() {
		return appointment_name;
	}

	public void setAppointment_name(String appointment_name) {
		this.appointment_name = appointment_name;
	}

	
    
}
