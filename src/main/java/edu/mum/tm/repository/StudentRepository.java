package edu.mum.tm.repository;

import edu.mum.tm.domain.Student;
import edu.mum.tm.viewmodel.StudentTotalStats;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {

    @Query(nativeQuery = true, value = "SELECT sum(B.TOTAL_SESSIONS) as totalSessions FROM STUDENT S\n" +
            "LEFT JOIN STUDENTS_BLOCK_COURSES SBC\n" +
            "ON S.MUM_ID = SBC.STUDENT_ID\n" +
            "LEFT JOIN COURSE_BLOCK CB\n" +
            "ON CB.Id = SBC.COURSE_BLOCK_ID\n" +
            "LEFT JOIN BLOCK B\n" +
            "ON B.ID = CB.BLOCK_ID\n" +
            "where S.MUM_ID = :studentId")
    Long getStudentTotalBlockSessions(Long studentId);

    @Query(nativeQuery = true, value = "SELECT COUNT(TMA.STUDENT_ID) FROM TM_ATTENDANCE TMA\n" +
            "where TMA.STUDENT_ID = :studentId\n" +
            "group by TMA.STUDENT_ID")
    Long getStudentAttendedSessions(Long studentId);

    //Long getStudentTotalBlockSessions(Long studentId);
}
