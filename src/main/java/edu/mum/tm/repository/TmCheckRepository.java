package edu.mum.tm.repository;

import edu.mum.tm.domain.TmCheck;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TmCheckRepository extends CrudRepository<TmCheck, Integer> {

    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM TmCheck T WHERE T.studentId = :studentId")
    Long getStudentAttendedTmCheck(Long studentId);
}