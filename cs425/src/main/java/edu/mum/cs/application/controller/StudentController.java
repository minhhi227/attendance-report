package edu.mum.cs.application.controller;

import edu.mum.cs.application.model.StudentViewModel;
import edu.mum.cs.projects.attendance.domain.entity.Student;
import edu.mum.cs.projects.attendance.ooxml.SpreadsheetReaderDAO;
import edu.mum.cs.projects.attendance.service.CourseServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by orifjon9 on 7/5/2017.
 */
@Controller
public class StudentController {
	
	@Autowired
	private CourseServiceImpl courseServiceImpl;

	
	@GetMapping("/students")
	public String students(HttpServletRequest request){
		request.setAttribute("courses", courseServiceImpl.getCourseOfferings("2017-06-26"));
		request.setAttribute("mode", "MODE_COURSE");
		return "students";
	}
	
//    @RequestMapping(method = RequestMethod.GET)
//    public List<StudentViewModel> students() {
//        return SpreadsheetReaderDAO.loadStudentList().stream()
//                .map(m->new StudentViewModel(m))
//                .collect(Collectors.toList());
//    }
//
//    @RequestMapping(value = "/{studentId}", method = RequestMethod.GET)
//    public Student student(@PathVariable String studentId) {
//        return SpreadsheetReaderDAO.findStudent(studentId);
//    }
}
