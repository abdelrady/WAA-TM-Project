package edu.mum.tm.controller;

import edu.mum.tm.domain.Block;
import edu.mum.tm.service.StudentService;
import edu.mum.tm.viewmodel.StudentTotalStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/students/reports/mvc")
public class StudentReportsController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/totalStats")
    public String getStudentTmReport(Model model){

        // TODO use current logged-in user
        Long studentId = 986834L;
        StudentTotalStats stats = studentService.getStudentTotalStats(studentId);
        List<Block> blocks = studentService.getStudentEnrolledBlocks(studentId);
        model.addAttribute("student", stats);
        model.addAttribute("blocks", blocks);

        return "StudentTmReport";
    }
}
