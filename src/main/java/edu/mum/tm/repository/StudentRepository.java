package edu.mum.tm.repository;

import edu.mum.tm.domain.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
