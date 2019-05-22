package edu.mum.tm.serviceImpl;

import edu.mum.tm.domain.Block;
import edu.mum.tm.domain.Student;
import edu.mum.tm.domain.TmAttendance;
import edu.mum.tm.repository.*;
import edu.mum.tm.service.StudentService;
import edu.mum.tm.viewmodel.StudentStatistics;
import edu.mum.tm.viewmodel.StudentTotalStats;
import edu.mum.tm.viewmodel.StudentTotals;
import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.collections.IteratorUtils;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TmRetreatRepository tmRetreatRepository;

    @Autowired
    private TmCheckRepository tmCheckRepository;

    @Autowired
    private BlockRepository blockRepository;

    @Autowired
    private TmAttendanceRepository tmAttendanceRepository;

    @Override
    public List<TmAttendance> getBlockStudentData(Integer blockId, Long stuId) {
        return IteratorUtils.toList(tmAttendanceRepository.findByStudentMumIdAndBlockId(stuId, blockId).iterator());
    }

    @Override
    public StudentTotalStats getStudentTotalStats(Long studentId) {
        StudentTotalStats stats = new StudentTotalStats();

        stats.setMumId(studentId);

        Long totalSessions = studentRepository.getStudentTotalBlockSessions(studentId);
        stats.setTotalSessions(totalSessions == null ? 1 : totalSessions);

        Long totalSessionsAttended = studentRepository.getStudentAttendedSessions(studentId);
        stats.setSessionsAttended(totalSessionsAttended == null ? 0 : totalSessionsAttended);

        stats.setAttendedSessionsPercentage(stats.getSessionsAttended() * 100 / stats.getTotalSessions());

        Long attendedRetreats = tmRetreatRepository.getStudentAttendedRetreats(studentId);
        stats.setAttendedRetreats(attendedRetreats == null ? 0 : attendedRetreats);

        Long attendedTmCheck = tmCheckRepository.getStudentAttendedTmCheck(studentId);
        stats.setAttendedTmCheck(attendedTmCheck == null ? 0 : attendedTmCheck);
        return stats;
    }

    @Override
    public List<Block> getStudentEnrolledBlocks(Long studentId) {
        return IteratorUtils.toList(blockRepository.findAll().iterator());
    }

    @Override
    public Student getStudentByMumId(long studentId) {

        return studentRepository.getStudentByMumId(studentId);
    }

    @Override
    public List<String> getEntries() {

        return IteratorUtils.toList(studentRepository.getEntries().iterator());
    }

    @Override
    public List<StudentStatistics> getStudentsStats(String entry) {
        return studentRepository.getStudentStatsByEntry(entry);
    }


    public Student getStudentByUserId(int userId) {
        return studentRepository.getStudentByUserId(userId);
    }

    @Override
    public List<StudentTotals> getAllStudentEnrolledBlocks() {
        return IteratorUtils.toList( studentRepository.getAllStudentEnrolledBlocks(StudentTotals.class).iterator());
    }

    @Override
    public List<StudentTotals> getAllStudentAttendanceCount() {
        return IteratorUtils.toList(studentRepository.getAllStudentAttendanceCount(StudentTotals.class).iterator());
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }
}
