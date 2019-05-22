package edu.mum.tm.service;

import edu.mum.tm.domain.Block;
import edu.mum.tm.domain.Student;
import edu.mum.tm.domain.TmAttendance;
import edu.mum.tm.viewmodel.StudentBlockData;
import edu.mum.tm.viewmodel.StudentStatistics;
import edu.mum.tm.viewmodel.StudentTotalStats;
import edu.mum.tm.viewmodel.StudentTotals;

import java.util.List;

public interface StudentService {
    List<TmAttendance> getBlockStudentData(Integer blockId, Long stuId);

    StudentTotalStats getStudentTotalStats(Long studentId);

    List<Block> getStudentEnrolledBlocks(Long studentId);

    Student getStudentByMumId(long parseLong);

    List<String> getEntries();

    List<StudentStatistics> getStudentsStats(String entry);
    Student getStudentByUserId(int userId);

    List<StudentTotals> getAllStudentEnrolledBlocks();

    List<StudentTotals>  getAllStudentAttendanceCount();

    public void save(Student student);
}
