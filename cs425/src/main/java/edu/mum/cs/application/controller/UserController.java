package edu.mum.cs.application.controller;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.cs.projects.attendance.domain.entity.Faculty;
import edu.mum.cs.projects.attendance.domain.entity.Role;
import edu.mum.cs.projects.attendance.domain.entity.Student;
import edu.mum.cs.projects.attendance.domain.entity.User;
import edu.mum.cs.projects.attendance.service.SecurityService;
import edu.mum.cs.projects.attendance.service.StudentService;
import edu.mum.cs.projects.attendance.service.UserService;
import edu.mum.cs.projects.attendance.service.UserValidator;

@Controller
public class UserController {

	@Autowired
    private UserService userService;
	
	@Autowired
    private StudentService studentService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/user/find/{userName}", method = RequestMethod.GET)
    public String findUser(@PathVariable String userName, Model model, HttpServletRequest request) {
    	model.addAttribute("userName", request.getUserPrincipal().getName());
        model.addAttribute("user", userService.findByUsername(userName));
       /*System.out.println(userName);
       
       for(int i =0; i<50; i++) {
    	   System.out.println("**************");
       }*/
              
        return "/user/find";
    }
    
    @RequestMapping(value = "/user/find", method = RequestMethod.GET)
    public String findUserAll(Model model, HttpServletRequest request) {
    	model.addAttribute("userName", request.getUserPrincipal().getName());
        model.addAttribute("users", userService.findUsers());
       
         
        /*for(int i =0; i<15; i++) {
     	   System.out.println("-----------------");
        }*/
        return "/user/find";
    }
    
    @RequestMapping(value = "/user/create", method = RequestMethod.GET)
    public String createUserView(Model model) {
        model.addAttribute("userForm", new User());
       // model.addAttribute("role", new Role());
        
        return "/user/create";
    }
    
    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public @ResponseBody String create(@RequestParam String username, @RequestParam String password,@RequestParam String roleId,@RequestParam String storeStudent,@RequestParam String storeFaculty) {
        
    	Long roleid = Long.parseLong(roleId);    	
    	User user = new User();
    	user.setUsername(username);
    	user.setPassword(password);
    	user.setStore(roleid == 3 ? storeFaculty : (roleid == 4 ? storeStudent : ""));
    	
    	if(roleid == 3){
    		//Faculty faculty =  
    	}else if(roleid == 4){
    		Student student = studentService.findStudentById(storeStudent);
    		if(student == null){
    			return "Student was not found.";
    		}
    	}
    	
    	Set<Role> roles = new HashSet<Role>();
    	roles.add(userService.getRole(roleid));
    	user.setRoles(roles);
    	
        userService.save(user);
        
        return "success";
        
    }
    
    @RequestMapping(value = "/user/delete/{username}")
    public String delete(@PathVariable String userName, Model model) {
        
       //userService.
        
        return "redirect:/user/find";
    }
}
