package edu.mum.tm.controller;

import edu.mum.tm.domain.TmAttendance;
import edu.mum.tm.service.StudentService;
import edu.mum.tm.viewmodel.StudentBlockData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/students/reports/rest")
public class StudentReportsRestController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/block/{blockId}/student/{stuId}")
    public List<TmAttendance> getBlockStudentData(@PathVariable Integer blockId, @PathVariable Long stuId){
        return studentService.getBlockStudentData(blockId, stuId);
    }
}
