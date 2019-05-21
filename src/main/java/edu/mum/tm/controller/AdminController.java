package edu.mum.tm.controller;

import edu.mum.tm.domain.Entry;
import edu.mum.tm.domain.Student;
import edu.mum.tm.domain.TmCheck;
import edu.mum.tm.domain.TmRetreat;
import edu.mum.tm.repository.StudentRepository;
import edu.mum.tm.service.StudentService;
import edu.mum.tm.service.TmCheckService;
import edu.mum.tm.service.TmRetreatService;
import edu.mum.tm.viewmodel.StudentStatistics;
import edu.mum.tm.viewmodel.StudentTotalStats;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TmRetreatService tmRetreatService;

    @Autowired
    private TmCheckService tmCheckService;

    @GetMapping("/report")
    public String getAdminReportEntries(Model model) {
        List<String> entries = studentService.getEntries();
        model.addAttribute("entries", entries);
        return "user/admin/entryReport";
    }

    @ResponseBody
    @GetMapping("/report/entry/{entry}")
    public List<StudentStatistics> getAdminReport(@PathVariable("entry") String entry) {
        System.out.println("in stat");
        List<StudentStatistics> entryStudents = studentService.getStudentsStats(entry);
        return entryStudents;
    }

    @GetMapping("/tmretreat")
    public String getTMRetreatForm( Model model){
        model.addAttribute("retreats",tmRetreatService.findAll());
        return "/user/admin/TmRetreat";
    }

    @PostMapping("/tmretreat")
    public String postTMRetreatForm(@ModelAttribute("TmRetreat") TmRetreat retreat, Model model){
        tmRetreatService.save(retreat);
        return "redirect:/admin/tmretreat";
    }

    @PostMapping("/deleteitem/{id}/{studentid}/{date}")
    public String postDeleted(@PathVariable("id") Long id,@PathVariable("studentid") Long studentid, @PathVariable("date") String date, Model model){
        TmRetreat retreat=new TmRetreat();
        retreat.setId(id);
        retreat.setStudentId(studentid);
        retreat.setDate(LocalDate.parse(date));
            tmRetreatService.delete(retreat);
        return "redirect:/admin/tmretreat";
    }


    @GetMapping("/tmcheck")
    public String getTMcheckForm( Model model){
        model.addAttribute("tmchecks",tmCheckService.findAll());
        return "/user/admin/TmCheck";
    }

    @PostMapping("/tmcheck")
    public String postTMRetreatForm(@ModelAttribute("TmCheck") TmCheck tmcheck, Model model){
        tmCheckService.save(tmcheck);
        return "redirect:/admin/tmcheck";
    }

    @PostMapping("/deleteTmCheck/{id}/{studentid}/{date}")
    public String tmCheckDelete(@PathVariable("id") Long id,@PathVariable("studentid") Long studentid, @PathVariable("date") String date, Model model){
        TmCheck tmCheck=new TmCheck();
        tmCheck.setId(id);
        tmCheck.setStudentId(studentid);
        tmCheck.setDate(LocalDate.parse(date));
        tmCheckService.delete(tmCheck);
        return "redirect:/admin/tmcheck";
    }
}

