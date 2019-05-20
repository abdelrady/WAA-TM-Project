package edu.mum.tm.controller;

import edu.mum.tm.domain.Entry;
import edu.mum.tm.domain.Student;
import edu.mum.tm.repository.StudentRepository;
import edu.mum.tm.service.EntryService;
import edu.mum.tm.service.StudentService;
import edu.mum.tm.viewmodel.StudentStatistics;
import edu.mum.tm.viewmodel.StudentTotalStats;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private EntryService entryService;

    @Autowired
    private StudentService studentService;

//    @GetMapping("/admin/report")
//    public String getAdminReportForm(@ModelAttribute("newEntry") Entry entry, Model model){
//        model.addAttribute("entries", entryService.getAll());
//        return "adminReport";
//    }

    @GetMapping("/report")
    public String getAdminReportEntries(Model model){
        List<String> entries=studentService.getEntries();
        model.addAttribute("entries",entries);
        return "user/admin/entryReport";
    }

    @ResponseBody
    @GetMapping("/report/entry/{entry}")
    public List<StudentStatistics> getAdminReport(@PathVariable("entry") String entry)
    {
        System.out.println("in stat");
        List<StudentStatistics> entryStudents=studentService.getStudentsStats(entry);
//        List<StudentTotalStats> studentTotalStats=new ArrayList<>();
//        for (Student entryStat:entryStudents) {
//            StudentTotalStats studentStat=new StudentTotalStats();
//            studentStat.setMumId(entryStat.getMumId());
//            studentStat.setAttendedSessionsPercentage(entryStat.getPercentage());
//            studentStat.setSessionsAttended(entryStat.getAttendedSessions());
//            //studentStat.setTotalSessions(entryStat());
//            studentTotalStats.add(studentStat);
//        }

        return entryStudents;
    }


//    @PostMapping("/admin/report")
//    public String getListStudent(@ModelAttribute("newEntry") Entry entry, Model model) {
//        entry = entryService.getById(entry.getId());
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
