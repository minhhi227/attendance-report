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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.cs.projects.attendance.domain.entity.Role;
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

        return "registration";
    }


    @RequestMapping(value = "/user/find/{userName}", method = RequestMethod.GET)
    public String findUser(@PathVariable String userName, Model model, HttpServletRequest request) {
    	model.addAttribute("userName", request.getUserPrincipal().getName());
        model.addAttribute("user", userService.findByUsername(userName));
       System.out.println(userName);
       
       for(int i =0; i<50; i++) {
    	   System.out.println("**************");
       }
       
       
        return "/user/find";
    }
    
    @RequestMapping(value = "/user/find", method = RequestMethod.GET)
    public String findUserAll(Model model, HttpServletRequest request) {
    	model.addAttribute("userName", request.getUserPrincipal().getName());
        model.addAttribute("users", userService.findUsers());
       
         
        for(int i =0; i<15; i++) {
     	   System.out.println("-----------------");
        }
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

    
}
