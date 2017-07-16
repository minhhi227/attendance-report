package edu.mum.cs.application.controller;


import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import edu.mum.cs.projects.attendance.domain.entity.CourseOffering;
import edu.mum.cs.projects.attendance.service.CourseService;

/**
 * Created by minh hieu on 7/5/2017.
 */
@Controller
public class FacultyController {
	@Autowired
	  private CourseService  courseService ;
	@GetMapping("/faculty")
	public String faculty(HttpServletRequest request){
		return "faculty";
	}
	
	@GetMapping("/faculty-students")
	public String facultyStudent(HttpServletRequest request){
		request.setAttribute("mode", "MODE_COURSE");
		return "faculty";
	}
	
	@GetMapping("/faculty-Courses")
	public String facultyCourses(HttpServletRequest request){
		
	  Principal principal = request.getUserPrincipal();
	  //System.out.println("---------"+principal.getName());
		String id=principal.getName();
		
		 //String id=principal.getName();
		// System.out.println(id);
		
		
		int iD=Integer.parseInt(id);
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
	System.out.println(listOfAllCourses.size());
			
		
	request.setAttribute("listOfAll",listOfAllCourses);

		return "courseViewByFaculty";
		
	}
	}

