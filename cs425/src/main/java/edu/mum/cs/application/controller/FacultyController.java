package edu.mum.cs.application.controller;


import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.cs.projects.attendance.domain.entity.CourseOffering;
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
	public String facultyCourses(HttpServletRequest request, Model model){
		
	  Principal principal = request.getUserPrincipal();
	  //System.out.println("---------"+principal.getName());
		
		
		 //String id=principal.getName();
		// System.out.println(id);
		
		
		/*int iD=Integer.parseInt(id);
		LocalDate today=LocalDate.now();
		LocalDate beforeSixMonths =today.minusMonths(6);
		
		List<CourseOffering> courseOfferings = courseService.allOfferingCourse();
		List<CourseOffering>listOfAllCourses=new ArrayList<>();
		
		
		for(CourseOffering course:courseOfferings ){
			if(iD==course.getFaculty().getId()){
				Date startDate = course.getStartDate();
				String  startDatecon=startDate.toString();
				LocalDate entryDate=LocalDate.parse(startDatecon);
				if(entryDate.isAfter(beforeSixMonths) && entryDate.isBefore(today)){
					
					listOfAllCourses.add(course);

					}
						
			}
			}
			
			
		
		System.out.println(listOfAllCourses);
	System.out.println(listOfAllCourses.size());*/
		model.addAttribute("userName", principal.getName());
		
		model.addAttribute("listOfAll", courseService.getCourseOfferingByFaculty(Long.parseLong("107")));

		return "faculty/viewCourses";
		
	}
	}

