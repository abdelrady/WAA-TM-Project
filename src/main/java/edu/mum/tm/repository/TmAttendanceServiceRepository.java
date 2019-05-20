package edu.mum.tm.repository;

import edu.mum.tm.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TmAttendanceServiceRepository extends JpaRepository<Student,Integer> {

    @Query(nativeQuery = true, value = "select * From Student")
    List<Student> getStudentTotalTMInBlock(int blockId);
}
