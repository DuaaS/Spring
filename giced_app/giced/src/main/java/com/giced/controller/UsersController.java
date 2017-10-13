package com.giced.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.giced.model.Users;
import com.giced.service.RoleService;
import com.giced.service.UsersService;

@Controller
public class UsersController {

	private UsersService userService;
	private RoleService roleService;

	@Autowired
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	@Autowired
	public void setUserService(UsersService userService) {
		this.userService = userService;
	}
	
	//Show User List
		@RequestMapping(value = "users", method = RequestMethod.GET)
		public String listUsers( Model model) {
		        model.addAttribute("user", new Users());
		        model.addAttribute("listUser", userService.getAllUsers());
		        model.addAttribute("listRole", roleService.getAllRoles());
		        return "list_user";
		 }
		
		//Show Add User Form
		@RequestMapping(value = "add_user", method = RequestMethod.GET)
		public String addUserForm(Model model) {
			Users user=new Users();
			model.addAttribute("listRole", roleService.getAllRoles());
			model.addAttribute("user", user);
			return "add_user";
		}
		
		//Add User 
		@RequestMapping(value = "users/add", method = RequestMethod.POST)
	    public String addUser(@ModelAttribute("user") Users user, Model model) {
			try {
				userService.addUser(user);
			}
	        catch(Exception ex) {
	        	model.addAttribute("errorMsg", "Username already exist");
	        	model.addAttribute("listRole", roleService.getAllRoles());
	        	return "add_user";
	        }
	        return "redirect:/users";
	    }
		
		//Show Edit User Form
		@RequestMapping("editUser/{user_name}")
	    public String editUserForm(@PathVariable("user_name") String id, Model model) {
			Users user=userService.getUser(id);
			model.addAttribute("user",user );
			model.addAttribute("listRole", roleService.getAllRoles());
			return "edit_user";
	    }
		
		//Edit User
		@RequestMapping(value = "users/edit/{role}", method = RequestMethod.POST)
	    public String editUser(@ModelAttribute("user") Users user,@PathVariable("role") String role, Model model) {
			try {
				userService.updateUser(user);
			}
	        catch(Exception ex) {
	        	model.addAttribute("errorMsg", "Username already exist");
	        	model.addAttribute("listRole", roleService.getAllRoles());
	        	return "add_user";
	        }
			String page=null;
			if(role.equals("[ROLE_SUPER_ADMIN]")) page="redirect:/users";
			else if(role.equals("[ROLE_ADMIN]")) page="Admin_Login";
			else page="Faculty_Login";
	        return page;
	    }

		//Delete User
		@RequestMapping("removeUser/{user_name}")
	    public String removeUser(@PathVariable("user_name") String id) {
	        userService.removeUser(id);
	        return "redirect:/users";
	    }
}
