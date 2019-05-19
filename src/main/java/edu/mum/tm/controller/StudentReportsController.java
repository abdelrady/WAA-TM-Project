package edu.mum.tm.controller;

import edu.mum.tm.service.StudentService;
import edu.mum.tm.viewmodel.StudentTotalStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class StudentReportsController {

    @Autowired
    private StudentService studentService;

    public String getStudentTmReport(Model model){

        // TODO use current logged-in user
        StudentTotalStats stats = studentService.getStudentTotalStats(986834L);
        model.addAttribute("student", stats);

        return "StudentTmReport";
    }
}
