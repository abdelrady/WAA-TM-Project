package edu.mum.tm.serviceImpl;

import edu.mum.tm.repository.StudentRepository;
import edu.mum.tm.service.StudentService;
import edu.mum.tm.viewmodel.StudentBlockData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentBlockData getBlockStudentData(String block, Long stuId) {
        return null;
    }
}
