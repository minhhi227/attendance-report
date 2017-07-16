package edu.mum.cs.application.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.cs.projects.attendance.service.AttendanceService;
import edu.mum.cs.projects.attendance.service.UserValidator;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {
	
	@Autowired
    private AttendanceService attendanceService;
	
	@RequestMapping(value="/course/{id}", method = RequestMethod.GET)
	public String getAttendanceByCourse(@PathVariable Long id, Model model, HttpServletRequest request)
	{
		model.addAttribute("userName", request.getUserPrincipal().getName());
		
		model.addAttribute("studentattendances", attendanceService.getStudentAttendanceRecordsByCourseOffering(id));
		
		return "/attendance/byCourse";
	}

}
