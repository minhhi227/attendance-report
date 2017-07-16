package edu.mum.cs.application.controller;


import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.cs.projects.attendance.service.CourseService;

/**
 * Created by minh hieu on 7/5/2017.
 */
@Controller
@RequestMapping("/faculty")
public class FacultyController {
	@Autowired
	  private CourseService  courseService ;
	
				
	@RequestMapping("/courses")
	public String facultyCourses(HttpServletRequest request, Model model) {

		Principal principal = request.getUserPrincipal();
		// System.out.println("---------"+principal.getName());
        model.addAttribute("userName", principal.getName());
		model.addAttribute("listOfAll", courseService.getCourseOfferingByFaculty(Long.parseLong("107")));

		return "faculty/viewCourses";

	}
	
}

