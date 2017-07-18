package edu.mum.cs.projects.attendance.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.projects.attendance.domain.entity.Faculty;

@Repository
public interface FacultyRepository extends CrudRepository<Faculty, Long> {
	Faculty findById(Long id);
}