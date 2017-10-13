package com.giced.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.giced.model.Users;
import com.giced.service.UsersService;

@Controller
public class LoginController  {
	
	  @Autowired
	  UsersService userService;
	  
	@Autowired 
	public UsersService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UsersService userService) {
		this.userService = userService;
	}
	
	//Show Login Page
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin() {
		ModelAndView model = new ModelAndView();
		  model.addObject("user", new Users());
		  model.setViewName("Login");
		  return model;
    }
	

	@RequestMapping(value = "/super-admin", method = RequestMethod.GET)
	public String getSuperAdmin( Model model) {
		model.addAttribute("user_name", getPrincipal().toUpperCase());
		return "Super_Admin_Login";
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String getAdmin( Model model) {
		model.addAttribute("user_name", getPrincipal().toUpperCase());
		return "Admin_Login";
	}
	
	@RequestMapping(value = "/faculty", method = RequestMethod.GET)
	public String getFaculty(Model model) {
		model.addAttribute("user", getPrincipal());
		model.addAttribute("user_name", getPrincipal().toUpperCase());
		return "Faculty_Login";
	}
	
	@RequestMapping(value = "/login_error", method = RequestMethod.GET)
	public ModelAndView loginError() {

	  ModelAndView model = new ModelAndView();
	  model.addObject("errorMsg", "Invalid Username and Password!");
	  model.addObject("user", new Users());
	  model.setViewName("Login");

	  return model;

	}
	
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        return "redirect:/login";
    }
	
	@RequestMapping(value = "cancelSuperAdmin", method = RequestMethod.GET)
	public String cancelSuperAdmin() {
		return "Super_Admin_Login";
	}
	
	@RequestMapping(value = "cancelAdmin", method = RequestMethod.GET)
	public String cancelAdmin() {
		return "Admin_Login";
	}
	
	@RequestMapping(value = "/cancelFaculty", method = RequestMethod.GET)
	public String cancelFaculty() {
		return "Faculty_Login";
	}
	
	//Show Change Password Form
			@RequestMapping(value = "change_password", method = RequestMethod.GET)
			public String listUsers(Model model) {
			    AbstractAuthenticationToken auth = (AbstractAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
			    //model.addAttribute("user_name", auth.getName());
			    model.addAttribute("user",userService.getUser(auth.getName()));
			    model.addAttribute("role", auth.getAuthorities());
			    return "change_password";
			 }
	
	 private String getPrincipal(){
	        String userName = null;
	        /*Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        if (principal instanceof Users) {
	            userName = ((Users)principal).getUser_name();
	        } else {
	            userName = principal.toString();
	        }*/
	        AbstractAuthenticationToken auth = (AbstractAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
	       
	        userName=auth.getName();
	        return userName;
	    }
	
}
