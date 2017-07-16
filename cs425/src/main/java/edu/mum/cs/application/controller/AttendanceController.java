package edu.mum.cs.application.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {
	
	@RequestMapping(value="/course/{id}", method = RequestMethod.GET)
	public String getAttendanceByCourse(@PathVariable Long id, Model model, HttpServletRequest request)
	{
		model.addAttribute("userName", request.getUserPrincipal().getName());
		
		model.addAttribute("offers", null);
		return "/attendance/byCourse";
	}

}
