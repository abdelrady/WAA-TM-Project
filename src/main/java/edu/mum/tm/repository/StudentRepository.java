package edu.mum.tm.repository;

import edu.mum.tm.domain.Block;
import edu.mum.tm.domain.Student;
import edu.mum.tm.viewmodel.StudentStatistics;
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

    @Query(nativeQuery = true, value = "SELECT sbc.student_id as studentID ,sum(B.TOTAL_SESSIONS) as totalSessions\n" +
            "            FROM\n" +
            " STUDENTS_BLOCK_COURSES SBC \n" +
            "            INNER JOIN COURSE_BLOCK  CB\n" +
            "            ON CB.ID = SBC.COURSE_BLOCK_ID \n" +
            "            INNER JOIN BLOCK B\n" +
            "            ON B.ID = CB.BLOCK_ID \n" +
            "            group by sbc.student_id")
    <T> Iterable<T> getAllStudentEnrolledBlocks(Class<T> type);

    @Query(nativeQuery = true, value = "SELECT sbc.mum_id as studentID ,count(tm.*) as totalSessions\n" +
            "            FROM\n" +
            " student SBC \n" +
            "inner join tm_attendance tm on tm.student_id=sbc.mum_id\n" +
            "            group by sbc.mum_id")
    <T> Iterable<T> getAllStudentAttendanceCount(Class<T> type);

    Student getStudentByMumId(long studentId);

    @Query(nativeQuery = true, value = "SELECT DISTINCT Entry "+
            "FROM STUDENT" )
    <T> Iterable<T> getEntries();

    @Query(nativeQuery = true, value = "SELECT s.mum_id as Id, s.attended_sessions as attendedSessions,s.percentage,sum(b.total_sessions) as totalSessions\n" +
            "FROM student s inner join STUDENTS_BLOCK_COURSES SBC on sbc.student_id=s.mum_id\n" +
            "INNER JOIN COURSE_BLOCK  CB\n" +
            "ON CB.ID = SBC.COURSE_BLOCK_ID \n" +
            "INNER JOIN BLOCK B\n" +
            "ON B.ID = CB.BLOCK_ID \n" +
            "WHERE S.entry  = :entry group by s.mum_id, s.attended_sessions ,s.percentage")
    List<StudentStatistics> getStudentStatsByEntry(String entry);


    Student getStudentByUserId(int userId);

    //Long getStudentTotalBlockSessions(Long studentId);
}
