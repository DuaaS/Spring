package com.giced.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.giced.model.Role;
import com.giced.service.RoleService;

@Controller
public class RoleController {

	private RoleService roleService;

	@Autowired
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	//Show Role List
		@RequestMapping(value = "roles", method = RequestMethod.GET)
		public String listAppointments(Model model) {
		        model.addAttribute("role", new Role());
		        model.addAttribute("listRole", roleService.getAllRoles());
		        return "list_role";
		 }
		
		//Show Add Role Form
		@RequestMapping(value = "add_role", method = RequestMethod.GET)
		public String addAppointmentForm(Model model) {
			Role role=new Role();
			model.addAttribute("role", role);
			return "add_role";
		}
		
		//Add Role 
		@RequestMapping(value = "roles/add", method = RequestMethod.POST)
	    public String addAppointment(@ModelAttribute("role") Role role, 
	    		Model model){
			try {
				 roleService.addRole(role);
			}
	        catch(Exception ex) {
	        	model.addAttribute("errorMsg", "Role Id already exist");
	        	return "add_role";
	        }
			return "redirect:/roles";
	        
	    }
		
		//Show Edit Role Form
		@RequestMapping("editRole/{role_id}")
	    public String editAppointmentForm(@PathVariable("role_id") String id, Model model) {
			model.addAttribute("role", roleService.getRole(id));
			return "edit_role";
	    }
		
		//Edit Role
		@RequestMapping(value = "roles/edit", method = RequestMethod.POST)
	    public String editAppointment(@ModelAttribute("role") Role role,
	    		final RedirectAttributes redirectAttributes) {
	        roleService.updateRole(role);
	        redirectAttributes.addFlashAttribute("msg", "Updated Successfully!");
	        return "redirect:/roles";
	    }

		//Delete Role
		@RequestMapping("removeRole/{role_id}")
	    public String removeAppointment(@PathVariable("role_id") String id,
	    		final RedirectAttributes redirectAttributes) {
	       roleService.removeRole(id);
	        redirectAttributes.addFlashAttribute("msg", "Deleted Successfully!");
	        return "redirect:/roles";
	    }
}
