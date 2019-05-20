package edu.mum.tm.controller;

import edu.mum.tm.viewmodel.AdminReportView;
import edu.mum.tm.domain.Entry;
import edu.mum.tm.domain.Student;
import edu.mum.tm.service.EntryService;
import edu.mum.tm.service.StudentService;
import edu.mum.tm.service.TmAttendanceService;
import edu.mum.tm.viewmodel.StudentTotalStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@SessionAttributes({"user", "loggedPerson"})
public class AdminController {

    @Autowired
    private EntryService entryService;

    @Autowired
    private TmAttendanceService tmAttendanceService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/admin/report")
    public String getAdminReportForm(@ModelAttribute("newEntry") Entry entry, Model model){
        model.addAttribute("entries", entryService.getAll());
        return "adminReport";
    }


    @PostMapping("/admin/report")
    public String getListStudent(@ModelAttribute("newEntry") Entry entry, Model model) {
//        entry = entryService.getById(entry.getId());
        List<Student> all = tmAttendanceService.getAll(entry.getId());

        List<AdminReportView> reports = new ArrayList<AdminReportView>();;
        AdminReportView item ;
        for (Student  student  : all){
            StudentTotalStats studentTotalStats = studentService.getStudentTotalStats(student.getMumId());
           item  = new AdminReportView();
           item.attendedSessionsPercentage = studentTotalStats.getAttendedSessionsPercentage();
           item.sessionsAttended = studentTotalStats.getSessionsAttended();
           item.totalSessions = studentTotalStats.getTotalSessions();
           item.strudentName = student.getUser().getFirstName();
           item.studentID = student.getMumId()+"";
           reports.add(item);
        }
        model.addAttribute("reports", reports);
        model.addAttribute("entries", entryService.getAll());

//
//        List<MeditationRecord> listRecord = meditationRecordService.findByStudentEntry(entry.getId());
//        List<AdminReportView> reports = new ArrayList<AdminReportView>();
//
//        List<Student> listStudent = listRecord.stream().map(a -> a.getStudent()).distinct().collect(Collectors.toList());
//        double totalSessionsPossible = blockSessionService.getTotalSessionByEntryDate(entry.getDateEntry());
//        double totalSessionsAttended;
//        AdminReportView item;
//
//        for (Student student : listStudent)
//        {
//            item = new AdminReportView();
//            List<MeditationRecord> listAttendedByStudent = listRecord.stream().filter(a -> a.getStudent() == student).collect(Collectors.toList());
//            totalSessionsAttended = listAttendedByStudent.size();
//            item.setStudent(student);
//            item.setTotalSessionsAttended(totalSessionsAttended);
//            item.setTotalSessionsPossible(totalSessionsPossible);
//            item.setPercent(myFormatter.format(totalSessionsAttended / totalSessionsPossible * 100));
//            reports.add(item);
//        }
//
//        model.addAttribute("reports", reports);
//        model.addAttribute("entries", entryService.getAll());
//        System.out.println("totalSessionsPossible = " + totalSessionsPossible);
//        System.out.println("entry date = " + entry.getDateEntry());
//
//        return "adminReport";
//    }

}
