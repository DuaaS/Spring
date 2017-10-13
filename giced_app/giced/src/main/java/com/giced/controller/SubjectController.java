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

import com.giced.model.Subject;
import com.giced.service.SubjectService;

@Controller
public class SubjectController {

	private SubjectService subjectService;
	
	
	@Autowired
	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}



	//Show Subject List
	@RequestMapping(value = "subjects", method = RequestMethod.GET)
	public String listAppointments(Model model) {
	        model.addAttribute("listSubject", subjectService.getAllSubjects());
	        AbstractAuthenticationToken auth = (AbstractAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
	        model.addAttribute("user_role", auth.getAuthorities());
	        return "list_subject";
	 }
	
	

	//Show Add Subject Form
	@RequestMapping(value = "add_subject", method = RequestMethod.GET)
	public String addAppointmentForm(Model model) {
		Subject design=new Subject();
		model.addAttribute("subject", design);
		return "add_subject";
	}
	
	//Add Subject 
	@RequestMapping(value = "subjects/add", method = RequestMethod.POST)
    public String addAppointment(@ModelAttribute("subject") Subject design, 
   		Model model) {
	   	try {
	   		subjectService.addSubject(design);
	   	}
	    catch(Exception ex) {
	   		model.addAttribute("errorMsg", "Subject Id already exist");
	   	    return "add_subject";
	   	}
	   	return "redirect:/subjects";
    }
	
	//Show Edit Subject Form
	@RequestMapping("editSubject/{subject_id}")
    public String editAppointmentForm(@PathVariable("subject_id") String id, Model model) {
		model.addAttribute("subject", subjectService.getSubject(id));
		return "edit_subject";
    }
	
	//Edit Subject
	@RequestMapping(value = "subjects/edit", method = RequestMethod.POST)
    public String editAppointment(@ModelAttribute("subject") Subject design,
    		final RedirectAttributes redirectAttributes) {
		subjectService.updateSubject(design);
        redirectAttributes.addFlashAttribute("msg", "Updated Successfully!");
        return "redirect:/subjects";
    }

	//Delete Appointment
	@RequestMapping("removeSubject/{subject_id}")
    public String removeAppointment(@PathVariable("subject_id") String id,
    		final RedirectAttributes redirectAttributes) {
		subjectService.removeSubject(id);
        redirectAttributes.addFlashAttribute("msg", "Deleted Successfully!");
        return "redirect:/subjects";
    }

}
