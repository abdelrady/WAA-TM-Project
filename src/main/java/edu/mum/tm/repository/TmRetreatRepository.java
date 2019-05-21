package edu.mum.tm.repository;

import edu.mum.tm.domain.TmRetreat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TmRetreatRepository extends CrudRepository<TmRetreat, Integer> {

    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM TmRetreat T WHERE T.studentId = :studentId")
    Long getStudentAttendedRetreats(Long studentId);
}
