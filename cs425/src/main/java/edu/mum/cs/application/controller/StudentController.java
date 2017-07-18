package edu.mum.cs.application.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.googlecode.charts4j.AxisLabelsFactory;
import com.googlecode.charts4j.BarChart;
import com.googlecode.charts4j.Color;
import com.googlecode.charts4j.Data;
import com.googlecode.charts4j.GCharts;
import com.googlecode.charts4j.PieChart;
import com.googlecode.charts4j.Plot;
import com.googlecode.charts4j.Plots;
import com.googlecode.charts4j.Slice;

import edu.mum.cs.projects.attendance.domain.StudentAttendance;
import edu.mum.cs.projects.attendance.domain.entity.CourseOffering;
import edu.mum.cs.projects.attendance.domain.entity.Enrollment;
import edu.mum.cs.projects.attendance.domain.entity.Student;
import edu.mum.cs.projects.attendance.domain.entity.User;
import edu.mum.cs.projects.attendance.service.CourseServiceImpl;
import edu.mum.cs.projects.attendance.service.StudentService;
import edu.mum.cs.projects.attendance.service.StudentServiceImpl;
import edu.mum.cs.projects.attendance.service.UserService;

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
	
	@Autowired
	private UserService  userService;
	
	@RequestMapping("/courses")
	public String allCourseByStudent(HttpServletRequest request, Model model){
		Principal principal = request.getUserPrincipal();
		User user = userService.findByUsername(principal.getName());
		
        model.addAttribute("userName", principal.getName());
        
		Date today = new Date();
		model.addAttribute("enrolled", studentServiceImpl.getEnrolledByStudentId(user.getStore()));
		model.addAttribute("today", today);

		return "student/viewCourses";

	}
	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public String allReport(HttpServletRequest request, Model model){
		Principal principal = request.getUserPrincipal();
		List<Enrollment> enrollments = studentServiceImpl.getEnrolledByStudentId(principal.getName());
		List<Integer> number = new ArrayList();
		List<String> xAxis = new ArrayList();
		
		for(Enrollment e: enrollments ){
			xAxis.add(e.getOffering().getCourse().getNumber());
			try{
			StudentAttendance attendance = studentServiceImpl.getAttendanceByCourseOffering(principal.getName(), e.getOffering());
			number.add((int)attendance.getMeditationCount()*(100/25));
			}
			catch(NullPointerException ex)
	        {
				number.add(0);
	        }
		}
		
		
		Plot plot1 = Plots.newBarChartPlot(Data.newData(number), Color.BLUE);

		BarChart chart= GCharts.newBarChart(plot1);
		chart.setTitle("Attendance");
		chart.setSize(400, 300);
		chart.setBarWidth(40);
		//chart.setGrid(10, 10, 2, 2);
		chart.addXAxisLabels(AxisLabelsFactory.newAxisLabels(xAxis));
		chart.addYAxisLabels(AxisLabelsFactory.newAxisLabels("0","5","10","15","20","25"));

		model.addAttribute("chart", chart.toURLString());
		
		return "student/report";
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

	
	@RequestMapping("/find/{studentId}")
	public String student(@PathVariable String studentId, HttpServletRequest request, Model model){
		
		Principal principal = request.getUserPrincipal();
		
		Student studentById = studentService.findStudentById(studentId);
	
		model.addAttribute("userName", principal.getName());
		model.addAttribute("student", studentById);
		model.addAttribute("enrolled", studentServiceImpl.getEnrolledByStudentId(studentById.getId()));
		
		model.addAttribute("today", new Date());
		
		return "student/find";
		
	}

}
