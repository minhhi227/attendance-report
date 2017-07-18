package edu.mum.cs.application.controller;


import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.cs.projects.attendance.domain.entity.User;
import edu.mum.cs.projects.attendance.service.CourseService;
import edu.mum.cs.projects.attendance.service.UserService;

/**
 * Created by minh hieu on 7/5/2017.
 */
@Controller
@RequestMapping("/faculty")
public class FacultyController {
	@Autowired
	private CourseService  courseService;
	
	@Autowired
	private UserService  userService;
	
	@RequestMapping("/courses")
	public String facultyCourses(HttpServletRequest request, Model model) {

		Principal principal = request.getUserPrincipal();
		User user = userService.findByUsername(principal.getName());
		
        model.addAttribute("userName", principal.getName());
		model.addAttribute("listOfAll", courseService.getCourseOfferingByFaculty(Long.parseLong(user.getStore())));

		return "faculty/viewCourses";

	}
	
}

