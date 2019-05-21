package edu.mum.tm.serviceImpl;

import edu.mum.tm.domain.Block;
import edu.mum.tm.domain.Student;
import edu.mum.tm.domain.TmAttendance;
import edu.mum.tm.repository.BlockRepository;
import edu.mum.tm.repository.StudentRepository;
import edu.mum.tm.repository.TmAttendanceRepository;
import edu.mum.tm.service.StudentService;
import edu.mum.tm.viewmodel.StudentBlockData;
import edu.mum.tm.viewmodel.StudentTotalStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.collections.IteratorUtils;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

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
        stats.setTotalSessions(totalSessions);

        Long totalSessionsAttended = studentRepository.getStudentAttendedSessions(studentId);
        stats.setSessionsAttended(totalSessionsAttended);

        stats.setAttendedSessionsPercentage(totalSessionsAttended * 100 / totalSessions);

        return stats;
    }

    @Override
    public List<Block> getStudentEnrolledBlocks(Long studentId) {
        return IteratorUtils.toList(blockRepository.findAll().iterator());
        //return IteratorUtils.toList(studentRepository.getStudentEnrolledBlocks(studentId, Block.class).iterator());
    }

    @Override
    public Student getStudentByMumId(long studentId) {

        return studentRepository.getStudentByMumId(studentId);
    }
}
