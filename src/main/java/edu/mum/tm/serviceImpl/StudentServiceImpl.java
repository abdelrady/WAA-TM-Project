package edu.mum.tm.serviceImpl;

import edu.mum.tm.repository.StudentRepository;
import edu.mum.tm.service.StudentService;
import edu.mum.tm.viewmodel.StudentBlockData;
import edu.mum.tm.viewmodel.StudentTotalStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentBlockData getBlockStudentData(String block, Long stuId) {
        return null;
    }

    @Override
    public StudentTotalStats getStudentTotalStats(Long studentId) {
        StudentTotalStats stats = new StudentTotalStats();
        Long totalSessions = studentRepository.getStudentTotalBlockSessions(studentId);
        stats.setTotalSessions(totalSessions);

        Long totalSessionsAttended = studentRepository.getStudentAttendedSessions(studentId);
        stats.setSessionsAttended(totalSessionsAttended);

        stats.setAttendedSessionsPercentage(totalSessionsAttended * 100 / totalSessions);

        return stats;
    }
}
