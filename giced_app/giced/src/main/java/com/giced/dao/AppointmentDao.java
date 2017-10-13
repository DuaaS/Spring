package com.giced.dao;

import java.util.List;

import com.giced.model.Appointment_Type;



public interface AppointmentDao {
	void addAppointment(Appointment_Type appt);

    void updateAppointment(Appointment_Type appt);

    void removeAppointment(String id);

    Appointment_Type getAppointment(String id);

    List<Appointment_Type> getAppointments(Integer page);

    List<Appointment_Type> getAllAppointments();

    
}
