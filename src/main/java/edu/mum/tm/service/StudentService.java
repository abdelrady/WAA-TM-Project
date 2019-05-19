package edu.mum.tm.service;

import edu.mum.tm.viewmodel.StudentBlockData;

public interface StudentService {
    StudentBlockData getBlockStudentData(String block, Long stuId);
}
