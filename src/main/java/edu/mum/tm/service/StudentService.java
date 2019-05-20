package edu.mum.tm.service;

import edu.mum.tm.domain.Block;
import edu.mum.tm.domain.TmAttendance;
import edu.mum.tm.viewmodel.StudentStatistics;
import edu.mum.tm.viewmodel.StudentTotalStats;

import java.util.List;

public interface StudentService {
    List<TmAttendance> getBlockStudentData(Integer blockId, Long stuId);

    StudentTotalStats getStudentTotalStats(Long studentId);

    List<Block> getStudentEnrolledBlocks(Long studentId);

    List<String> getEntries();

    List<StudentStatistics> getStudentsStats(String entry);
}
