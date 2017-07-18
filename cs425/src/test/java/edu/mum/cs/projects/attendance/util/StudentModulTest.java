package edu.mum.cs.projects.attendance.util;
import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.cs.projects.attendance.domain.StudentAttendance;
import edu.mum.cs.projects.attendance.domain.entity.CourseOffering;
import edu.mum.cs.projects.attendance.service.CourseServiceImpl;
import edu.mum.cs.projects.attendance.service.StudentServiceImpl;

public class StudentModulTest {
	
	@Autowired
	private CourseServiceImpl courseServiceImpl ;
	@Autowired
	private StudentServiceImpl studentServiceImpl ;
	
	@Test
	public void run() {
		
		CourseOffering courseOffering = courseServiceImpl.getCourseOffering((long)1466);
		StudentAttendance attendance = studentServiceImpl.getAttendanceByCourseOffering("000-98-3209", courseOffering);
		assertEquals(38, courseOffering.getEnrolled());
		assertEquals(72, (int)attendance.getMeditaionPercentage());
		assertEquals(16, attendance.getMeditationCount());
		assertEquals(22, attendance.getNumberOfRequiredSessions());
		
	}

}
