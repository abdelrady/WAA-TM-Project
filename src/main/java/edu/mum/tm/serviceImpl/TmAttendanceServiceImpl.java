package edu.mum.tm.serviceImpl;

import edu.mum.tm.domain.Student;
import edu.mum.tm.repository.TmAttendanceServiceRepository;
import edu.mum.tm.service.TmAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TmAttendanceServiceImpl implements TmAttendanceService {
    @Autowired
   public TmAttendanceServiceRepository tmAttendanceServiceRepository;
    @Override
    public List<Student> getAll(int blockId) {
        return tmAttendanceServiceRepository.getStudentTotalTMInBlock(blockId);
    }

}
