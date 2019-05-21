package edu.mum.tm.controller;

import edu.mum.tm.domain.Block;
import edu.mum.tm.domain.User;
import edu.mum.tm.service.StudentService;
import edu.mum.tm.service.UserService;
import edu.mum.tm.viewmodel.StudentTotalStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/student/reports/mvc")
public class StudentReportsController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public User getLoggedInUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userService.findUserByEmail(auth.getName());
    }

    @GetMapping("/totalStats")
    public String getStudentTmReport(Model model, HttpSession session){

        User loggedInUser = (User)model.asMap().get("user");//(User)session.getAttribute("auhenticatedUser");

        Long studentId = studentService.getStudentByUserId(loggedInUser.getId()).getMumId();

        StudentTotalStats stats = studentService.getStudentTotalStats(studentId);
        List<Block> blocks = studentService.getStudentEnrolledBlocks(studentId);
        model.addAttribute("student", stats);
        model.addAttribute("blocks", blocks);

        return "user/student/StudentTmReport";
    }
}
