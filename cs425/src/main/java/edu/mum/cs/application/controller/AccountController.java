package edu.mum.cs.application.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.cs.projects.attendance.domain.entity.Role;
import edu.mum.cs.projects.attendance.domain.entity.User;
import edu.mum.cs.projects.attendance.service.SecurityService;
import edu.mum.cs.projects.attendance.service.UserService;
import edu.mum.cs.projects.attendance.service.UserValidator;

@Controller
public class AccountController {

	@Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");
        
        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");
         
        return "login";
    }
   
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
       
        return "redirect:/login";
    }
    
    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model, HttpServletRequest request) {
    	Principal principal = request.getUserPrincipal();
    	Role role = userService.getRoles(principal.getName()).get(0);
    	
    	if(role.getName().equals("ROLE_STUDENT")){
    		
    		return "redirect:/student/courses";
    	}
    	else if(role.getName().equals("ROLE_FACULTY")){
    		
    		return "redirect:/faculty/courses";
    	}
    	else if(role.getName().equals("ROLE_STAFF")){
    		
    		return "redirect:/student/find";
    	}
    	else{
    		
    		return "redirect:/admin/courses";
    	}

    }
}
