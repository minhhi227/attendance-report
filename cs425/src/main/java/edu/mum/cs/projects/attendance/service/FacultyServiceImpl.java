package edu.mum.cs.projects.attendance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.projects.attendance.domain.entity.Faculty;
import edu.mum.cs.projects.attendance.repository.FacultyRepository;

@Service
public class FacultyServiceImpl implements FacultyService
{
	@Autowired
	private FacultyRepository facultyRepository;
	
	@Override
	public Faculty findFaculty(Long id) {
		return facultyRepository.findById(id);
	}

}
