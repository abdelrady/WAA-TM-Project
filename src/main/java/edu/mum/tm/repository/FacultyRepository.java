package edu.mum.tm.repository;

import edu.mum.tm.domain.Professor;
import edu.mum.tm.viewmodel.ILookupItem;
import edu.mum.tm.viewmodel.LookupItem;
import edu.mum.tm.viewmodel.StudentsExtraCredit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FacultyRepository extends CrudRepository<Professor, Long> {

    //@Query(value = "SELECT new edu.mum.tm.viewmodel.LookupItem(cb.id, cb.course.name) from CourseBlock cb where cb.professor.id = :facultyId")
    @Query(nativeQuery = true, value = "SELECT CB.ID as id, C.NAME || ' - ' || B.MMYY as name\n" +
            "FROM COURSE_BLOCK CB\n" +
            "INNER JOIN COURSE C\n" +
            "ON C.ID = CB.COURSE_ID \n" +
            "INNER JOIN BLOCK B\n" +
            "ON B.ID = CB.BLOCK_ID \n" +
            "where CB.PROFESSOR_ID = :facultyId")
    List<ILookupItem> getFacultyCourses(Long facultyId);

    @Query(nativeQuery = true, value = "SELECT SR.AttendedPercentage, SR.STUDENT_ID as StudentId, CASE \n" +
            "\tWHEN SR.AttendedPercentage >= 90 THEN 1.5\n" +
            "\tWHEN SR.AttendedPercentage >= 80 THEN 1.0\n" +
            "\tWHEN SR.AttendedPercentage >= 70 THEN 0.5\n" +
            "\tELSE 0\n" +
            "\tEND AS ExtraCredits\n" +
            "  FROM\n" +
            "(SELECT count(*) * 100 / B.TOTAL_SESSIONS as AttendedPercentage, T.STUDENT_ID FROM COURSE_BLOCK CB\n" +
            "INNER JOIN STUDENTS_BLOCK_COURSES SBC\n" +
            "ON SBC.COURSE_BLOCK_ID = CB.ID\n" +
            "INNER JOIN TM_ATTENDANCE T\n" +
            "ON T.STUDENT_ID = SBC.STUDENT_ID AND T.BLOCK_ID = CB.BLOCK_ID \n" +
            "INNER JOIN BLOCK B ON B.ID = CB.BLOCK_ID \n" +
            "where CB.ID = :courseBlockId\n" +
            "group by B.TOTAL_SESSIONS, T.STUDENT_ID) as SR\n" +
            "where SR.AttendedPercentage >= 70\n")
    List<StudentsExtraCredit> getCourseStudentsExtraCredits(Integer courseBlockId);
}
