package edu.mum.tm.controller;

import edu.mum.tm.domain.Block;
import edu.mum.tm.domain.User;
import edu.mum.tm.service.FacultyService;
import edu.mum.tm.service.StudentService;
import edu.mum.tm.viewmodel.FacultyViewModel;
import edu.mum.tm.viewmodel.LookupItem;
import edu.mum.tm.viewmodel.StudentTotalStats;
import edu.mum.tm.viewmodel.StudentsExtraCredit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/faculty/reports/mvc")
public class FacultyReportController {
    @Autowired
    private FacultyService facultyService;

    @GetMapping("/statsPerBlock")
    public String getFacultyReport(Model model, HttpSession session) throws Exception{
        FacultyViewModel faculty = new FacultyViewModel();

        User loggedInUser = (User)session.getAttribute("auhenticatedUser");

        Long facultyId = facultyService.getFacultyIdByUserId(loggedInUser.getId()).getId();

        faculty.setId(facultyId);

        faculty.setCourses(facultyService.getFacultyCourses(faculty.getId()));

        model.addAttribute("faculty", faculty);

        return "FacultyReport";
    }

    @ResponseBody
    @GetMapping("/courseBlock/{courseBlockId}/stats")
    public List<StudentsExtraCredit> getCourseStudentsExtraCredits(@PathVariable Integer courseBlockId){
        return facultyService.getCourseStudentsExtraCredits(courseBlockId);
    }

}
