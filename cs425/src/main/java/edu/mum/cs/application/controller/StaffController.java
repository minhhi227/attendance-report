package edu.mum.cs.application.controller;

import java.security.Principal;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.cs.projects.attendance.domain.StudentAttendance;
import edu.mum.cs.projects.attendance.domain.entity.CourseOffering;
import edu.mum.cs.projects.attendance.repository.StaffRepository;
import edu.mum.cs.projects.attendance.service.CourseService;
import edu.mum.cs.projects.attendance.service.StudentService;

@Controller
@RequestMapping("/staff")
public class StaffController {

	
	
	@Autowired
	private StaffRepository staffRepository ;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private CourseService courseService;
	
	//String id;
	
		
	/*@RequestMapping(value="/course/{studentId}", method=RequestMethod.GET)
	public String allCourseByStudent(@PathVariable("studentId") String studentId, HttpServletRequest request,Model model){
		
		Principal principal = request.getUserPrincipal();
		id=studentId;
		Date today = new Date();
		model.addAttribute("userName", principal.getName());
		model.addAttribute("enrolled", studentService.getEnrolledByStudentId(studentId));
		model.addAttribute("student",studentService.findStudentById(studentId));
		model.addAttribute("today", today);

		return "staff/courses";
	}*/
	
	
	
	@RequestMapping(value = "/attendance/{courseid}/{studentId}", method=RequestMethod.GET)
	public String allAttendanceByStudent(@PathVariable Long courseid,@PathVariable String studentId, HttpServletRequest request, Model model){
		
		System.out.println("----------------------------------");
		System.out.println(courseid);
		
		CourseOffering courseOffering = courseService.getCourseOffering(courseid);
		String msg = "";
		try
        {
			msg = "Detail Record";
		    StudentAttendance attendance = studentService.getAttendanceByCourseOffering(studentId, courseOffering);
       
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
		model.addAttribute("userName", studentId);
		model.addAttribute("student",studentService.findStudentById(studentId));

		return "staff/viewAttendanceByStudent";
	}
		
	@RequestMapping(value="/attendance/delete/{studentId}/{date}")
	public String  deleteAttendanceRecordByStudentId(Model model, @PathVariable String studentId){
		String msg="";
		studentService.findStudentById(studentId);
		
		try{
		staffRepository.delete(studentId);
	       msg = "record deleted successfully !";
		}
		catch(Exception ex){
			msg = "Error deleting record";
			ex.printStackTrace();
		}
		model.addAttribute("msg",msg);
		return "";
	}
	
	
	/*@RequestMapping(value = "/addAttendanceRecord")
	public String addAttendanceRecord(@RequestParam("studentid") String studentid
			, @RequestParam("date") String date,Model model ){
		
		String msg= "";
		try{
			staffRepository.addRecord(studentid,date);
			msg = "Record added successfully !";
		} 
		catch(Exception ex){
			ex.printStackTrace();
			msg= "Error adding record !";
		}
		model.addAttribute("msg",msg);
		
		
		return "";
	}*/
}
