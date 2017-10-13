package com.giced.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.giced.dao.AppointmentDao;
import com.giced.model.Appointment_Type;

@Service
@Component
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	private AppointmentDao appointmentDao;

	@Autowired
    public void setAppointmentDao(AppointmentDao appointmentDao) {
        this.appointmentDao = appointmentDao;
    }

	@Autowired
    public AppointmentDao getAppointmentDao() {
         return appointmentDao;
    }
	
    @Override
    @Transactional
	public void addAppointment(Appointment_Type appt) {
    	appointmentDao.addAppointment(appt);

	}

    @Override
    @Transactional
	public void updateAppointment(Appointment_Type appt) {
    	appointmentDao.updateAppointment(appt);
	}

    @Override
    @Transactional
    public void removeAppointment(String id) {
    	appointmentDao.removeAppointment(id);
	}

    @Override
    @Transactional
	public Appointment_Type getAppointment(String id) {
		return appointmentDao.getAppointment(id);
	}

    @Override
    @Transactional
	public List<Appointment_Type> getAppointments(Integer page) {
    	return appointmentDao.getAppointments(page);
	}

    @Override
    @Transactional
	public List<Appointment_Type> getAllAppointments() {
		return appointmentDao.getAllAppointments();
	}

}
