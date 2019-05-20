package edu.mum.tm.repository;

import edu.mum.tm.domain.Block;
import edu.mum.tm.domain.Student;
import edu.mum.tm.viewmodel.StudentTotalStats;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

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

    @Query(nativeQuery = true, value = "SELECT B.ID as id, B.START_DATE as startDate, B.END_DATE as endDate, B.TOTAL_SESSIONS as totalSessions, B.MMYY as MMYY, '' as tmAttendences\n" +
            "FROM STUDENTS_BLOCK_COURSES SBC\n" +
            "INNER JOIN COURSE_BLOCK  CB\n" +
            "ON CB.ID = SBC.COURSE_BLOCK_ID \n" +
            "INNER JOIN BLOCK B\n" +
            "ON B.ID = CB.BLOCK_ID \n" +
            "WHERE SBC.STUDENT_ID  = :studentId")
    <T> Iterable<T> getStudentEnrolledBlocks(Long studentId, Class<T> type);

    //Long getStudentTotalBlockSessions(Long studentId);
}
