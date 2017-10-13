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

import com.giced.model.Designation;
import com.giced.service.DesignationService;

@Controller
public class DesignationController {
	
private DesignationService designationService;
	
	@Autowired
	public void setDesignationService(DesignationService designationService) {
		this.designationService = designationService;
	}

	//Show Designation List
	@RequestMapping(value = "designations", method = RequestMethod.GET)
	public String listAppointments( Model model) {
	        model.addAttribute("listDesignation", designationService.getAllDesignations());
	        AbstractAuthenticationToken auth = (AbstractAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
	        model.addAttribute("user_role", auth.getAuthorities());
	        return "list_designation";
	 }
	
	

	//Show Add Designation Form
	@RequestMapping(value = "add_designation", method = RequestMethod.GET)
	public String addAppointmentForm(Model model) {
		Designation design=new Designation();
		model.addAttribute("designation", design);
		return "add_designation";
	}
	
	//Add Designation 
	@RequestMapping(value = "designations/add", method = RequestMethod.POST)
    public String addAppointment(@ModelAttribute("designation") Designation design, 
   		Model model) {
	   	try {
	   		designationService.addDesignation(design);
	   	}
	    catch(Exception ex) {
	   		model.addAttribute("errorMsg", "Designation Id already exist");
	   	    return "add_designation";
	   	}
	   	return "redirect:/designations";
    }
	
	//Show Edit Designation Form
	@RequestMapping("editDesignation/{designation_id}")
    public String editAppointmentForm(@PathVariable("designation_id") String id, Model model) {
		model.addAttribute("designation", designationService.getDesignation(id));
		return "edit_designation";
    }
	
	//Edit Designation
	@RequestMapping(value = "designations/edit", method = RequestMethod.POST)
    public String editAppointment(@ModelAttribute("designation") Designation design,
    		final RedirectAttributes redirectAttributes) {
		designationService.updateDesignation(design);
        redirectAttributes.addFlashAttribute("msg", "Updated Successfully!");
        return "redirect:/designations";
    }

	//Delete Appointment
	@RequestMapping("removeDesignation/{designation_id}")
    public String removeAppointment(@PathVariable("designation_id") String id,
    		final RedirectAttributes redirectAttributes) {
		designationService.removeDesignation(id);
        redirectAttributes.addFlashAttribute("msg", "Deleted Successfully!");
        return "redirect:/designations";
    }

}
