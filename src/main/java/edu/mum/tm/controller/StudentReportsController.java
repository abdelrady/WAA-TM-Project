package edu.mum.tm.controller;

import edu.mum.tm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class StudentReportsController {

    @Autowired
    private StudentService studentService;

    public String getStudentTmReport(){

        return "StudentTmReport";
    }
}
