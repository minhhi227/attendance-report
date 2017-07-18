package edu.mum.cs.application.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.cs.projects.attendance.domain.StudentAttendance;
import edu.mum.cs.projects.attendance.domain.entity.CourseOffering;
import edu.mum.cs.projects.attendance.domain.entity.Student;
import edu.mum.cs.projects.attendance.service.CourseServiceImpl;
import edu.mum.cs.projects.attendance.service.StudentService;
import edu.mum.cs.projects.attendance.service.StudentServiceImpl;

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
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/courses")
	public String allCourseByStudent(HttpServletRequest request, Model model){
		//Principal principal = request.getUserPrincipal();
		//HttpSession session=request.getSession();
		//String studentId = request.getParameter("studentId");
		//String studentId=session.getAttribute("studentId").toString();
		//System.out.println("+++++++"+studentId);
		Date today = new Date();
		//model.addAttribute("userName", principal.getName());
		model.addAttribute("enrolled", studentServiceImpl.getEnrolledByStudentId("000-98-2670"));
		//model.addAttribute("student",studentServiceImpl.findStudentById(principal.getName()));
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
	
	
	@RequestMapping("/find")
	public String student(HttpServletRequest request, Model model){
		model.addAttribute("userName", request.getUserPrincipal().getName());
		return "student/find";
		
	}

	// 000-98-3209
	@RequestMapping("/find/{studentId}")
	public String student(@PathVariable String studentId, HttpServletRequest request, Model model){
		
		Principal principal = request.getUserPrincipal();
		
		Student studentById = studentService.findStudentById(studentId);
	
		model.addAttribute("userName", principal.getName());
		model.addAttribute("student", studentById);
		model.addAttribute("enrolled", studentServiceImpl.getEnrolledByStudentId(studentById.getId()));
		//model.addAttribute("student",studentServiceImpl.findStudentById(principal.getName()));
		model.addAttribute("today", new Date());
		
		return "student/find";
		
	}

}
