package edu.mum.cs.application.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.cs.projects.attendance.domain.entity.User;
import edu.mum.cs.projects.attendance.service.SecurityService;
import edu.mum.cs.projects.attendance.service.UserService;
import edu.mum.cs.projects.attendance.service.UserValidator;

@Controller

public class UserController {

	@Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
//change
        return "registration";
    }

    //commit by Pagmaa
    @RequestMapping(value = "/user/find/{userName}?", method = RequestMethod.GET)
    public String findUser(@PathVariable String userName, Model model, HttpServletRequest request) {
    	model.addAttribute("userName", request.getUserPrincipal().getName());
        model.addAttribute("users", userService.findUsers(userName));
       
        return "/user/find";
    }
    
    @RequestMapping(value = "/user/find/", method = RequestMethod.GET)
    public String findUserAll(Model model, HttpServletRequest request) {
    	model.addAttribute("userName", request.getUserPrincipal().getName());
        model.addAttribute("users", userService.findUsers(""));
       
        return "/user/find";
    }
    
   /* @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
        
    }*/

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model, HttpServletRequest request) {
    	Principal principal = request.getUserPrincipal();
    	
    	if(userService.getRoles(principal.getName()).size() == 1){
    		if(userService.getRoles(principal.getName()).get(0).getName().equals("Student")){
        		return "redirect:/students";
        	}
        	else{
        		return "redirect:/faculty";
        	}
    	}
    	else{
    		return "redirect:/faculty-students";
    	}
    	
    }
}
