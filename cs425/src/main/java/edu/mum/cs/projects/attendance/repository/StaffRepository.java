package edu.mum.cs.projects.attendance.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.projects.attendance.domain.entity.Student;

@Repository
public interface StaffRepository extends CrudRepository<Student, String> {
	public void delete(String id);
	

}
