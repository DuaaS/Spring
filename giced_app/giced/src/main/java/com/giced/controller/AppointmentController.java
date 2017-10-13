package com.giced.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.giced.model.Appointment_Type;
import com.giced.service.AppointmentService;


@Controller
public class AppointmentController {
	
	private AppointmentService appointmentService;
	
	@Autowired
    public void setAppointmentService(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

	//Show Appointment List
	@RequestMapping(value = "appointments", method = RequestMethod.GET)
	public String listAppointments(Model model) {
	        
	        //model.addAttribute("appt", new Appointment_Type());
	        model.addAttribute("listAppts", appointmentService.getAllAppointments());
	        AbstractAuthenticationToken auth = (AbstractAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
	        model.addAttribute("user_role", auth.getAuthorities());
	        return "list_appointment_type";
	 }
	
	//Show Add Appointment Form
	@RequestMapping(value = "add_appointment", method = RequestMethod.GET)
	public String addAppointmentForm(Model model) {
		Appointment_Type appt=new Appointment_Type();
		/*appt.setAppointment_id("");
		appt.setAppointment_name("");*/
		model.addAttribute("appointment_type", appt);
		return "add_appointment_type";
	}
	
	//Add Appointment 
	@RequestMapping(value = "appointments/add", method = RequestMethod.POST)
    public String addAppointment(@ModelAttribute("appointment_type") Appointment_Type appt, 
    		Model model) {
		try {
			appointmentService.addAppointment(appt);
		}
        catch(Exception ex) {
        	model.addAttribute("errorMsg", "Appointment Id already exist");
        	return "add_appointment_type";
        }
        return "redirect:/appointments";
    }
	
	//Show Edit Appointment Form
	@RequestMapping("editAppointment/{appointment_id}")
    public String editAppointmentForm(@PathVariable("appointment_id") String id, Model model) {
		model.addAttribute("appointment_type", appointmentService.getAppointment(id));
		return "edit_appointment_type";
    }
	
	//Edit Appointment
	@RequestMapping(value = "appointments/edit", method = RequestMethod.POST)
    public String editAppointment(@ModelAttribute("appointment_type") Appointment_Type appt,
    		final RedirectAttributes redirectAttributes) {
        appointmentService.updateAppointment(appt);
        redirectAttributes.addFlashAttribute("msg", "Updated Successfully!");
        return "redirect:/appointments";
    }

	//Delete Appointment
	@RequestMapping("removeAppointment/{appointment_id}")
    public String removeAppointment(@PathVariable("appointment_id") String id,
    		final RedirectAttributes redirectAttributes) {
        appointmentService.removeAppointment(id);
        redirectAttributes.addFlashAttribute("msg", "Deleted Successfully!");
        return "redirect:/appointments";
    }
	
	
}
