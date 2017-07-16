package edu.mum.cs.application.controller;

import edu.mum.cs.application.model.StudentViewModel;
import edu.mum.cs.projects.attendance.domain.StudentAttendance;
import edu.mum.cs.projects.attendance.domain.entity.CourseOffering;
import edu.mum.cs.projects.attendance.domain.entity.Session;
import edu.mum.cs.projects.attendance.domain.entity.Student;
import edu.mum.cs.projects.attendance.ooxml.SpreadsheetReaderDAO;
import edu.mum.cs.projects.attendance.service.AttendanceService;
import edu.mum.cs.projects.attendance.service.AttendanceServiceImpl;
import edu.mum.cs.projects.attendance.service.CourseServiceImpl;
import edu.mum.cs.projects.attendance.service.StudentServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by orifjon9 on 7/5/2017.
 * Updated by minh hieu on 7/13/2017
 */
@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private CourseServiceImpl courseServiceImpl;

	@Autowired
	private StudentServiceImpl studentServiceImpl;

	
	@RequestMapping("/courses")
	public String allCourseByStudent(HttpServletRequest request, Model model){
		Principal principal = request.getUserPrincipal();
		Date today = new Date();
		model.addAttribute("userName", principal.getName());
		model.addAttribute("enrolled", studentServiceImpl.getEnrolledByStudentId(principal.getName()));
		model.addAttribute("student",studentServiceImpl.findStudentById(principal.getName()));
		model.addAttribute("today", today);

		return "student/viewCourses";
	}
	
	@RequestMapping(value = "/attendance/{id}", method=RequestMethod.GET)
	public String allAttendanceByStudent(@PathVariable int id,HttpServletRequest request, Model model){
		
		Principal principal = request.getUserPrincipal();
		
		CourseOffering courseOffering = courseServiceImpl.getCourseOffering((long) id);
		String msg = "";
		try
        {
			msg = "Detail Record";
		    StudentAttendance attendance = studentServiceImpl.getAttendanceByCourseOffering(principal.getName(), courseOffering);
       
		    model.addAttribute("meditaionPercentage", (int)attendance.getMeditaionPercentage());
		    model.addAttribute("meditationCount", attendance.getMeditationCount());
		    model.addAttribute("numberOfRequiredSessions", attendance.getNumberOfRequiredSessions());
		    model.addAttribute("extraGrade", attendance.getMeditationExtraGrade());
			
			Map<String,Boolean> map = new LinkedHashMap<String,Boolean>();  

		    for (int i=0; i<attendance.getSessions().size(); i++) {
		      map.put(attendance.getSessions().get(i).getDate().toString(), attendance.getAttendance().get(i));    
		    }
		    
		    model.addAttribute("map", map);
        }
		catch(NullPointerException e)
        {
			msg = "No Record";
        }
		model.addAttribute("msg",msg);
		model.addAttribute("userName", principal.getName());
		model.addAttribute("student",studentServiceImpl.findStudentById(principal.getName()));

		return "student/viewAttendance";
	}
	

}
