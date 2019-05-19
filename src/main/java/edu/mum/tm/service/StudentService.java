package edu.mum.tm.service;

import edu.mum.tm.viewmodel.StudentBlockData;
import edu.mum.tm.viewmodel.StudentTotalStats;

public interface StudentService {
    StudentBlockData getBlockStudentData(String block, Long stuId);

    StudentTotalStats getStudentTotalStats(Long studentId);
}
