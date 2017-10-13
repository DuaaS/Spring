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
import com.giced.model.Duration;
import com.giced.service.DurationService;

@Controller
public class DurationController {
	
	private DurationService durationService;
	
	
	@Autowired
	public void setDurationService(DurationService durationService) {
		this.durationService = durationService;
	}



	//Show Duration List
	@RequestMapping(value = "durations", method = RequestMethod.GET)
	public String listDurations( Model model) {
	        model.addAttribute("listDuration", durationService.getAllDurations());
	        AbstractAuthenticationToken auth = (AbstractAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
	        model.addAttribute("user_role", auth.getAuthorities());
	        return "list_duration";
	 }
	
	

	//Show Add Duration Form
	@RequestMapping(value = "add_duration", method = RequestMethod.GET)
	public String addDurationForm(Model model) {
		Duration duration=new Duration();
		model.addAttribute("duration", duration);
		return "add_duration";
	}
	
	//Add Designation 
	@RequestMapping(value = "durations/add", method = RequestMethod.POST)
    public String addAppointment(@ModelAttribute("duration") Duration duration, 
   		Model model) {
	   	try {
	   		durationService.addDuration(duration);;
	   	}
	    catch(Exception ex) {
	   		model.addAttribute("errorMsg", "Duration Id already exist");
	   	    return "add_durations";
	   	}
	   	return "redirect:/durations";
    }
	
	//Show Edit Designation Form
	@RequestMapping("editDuration/{duration_id}")
    public String editAppointmentForm(@PathVariable("duration_id") String id, Model model) {
		model.addAttribute("duration", durationService.getDuration(id));
		return "edit_duration";
    }
	
	//Edit Designation
	@RequestMapping(value = "durations/edit", method = RequestMethod.POST)
    public String editAppointment(@ModelAttribute("duration") Duration duration) {
		durationService.updateDuration(duration);
        return "redirect:/durations";
    }

	//Delete Appointment
	@RequestMapping("removeDuration/{duration_id}")
    public String removeAppointment(@PathVariable("duration_id") String id) {
		durationService.removeDuration(id);
        return "redirect:/durations";
    }

}
