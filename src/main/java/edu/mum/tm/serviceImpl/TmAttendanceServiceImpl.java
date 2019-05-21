package edu.mum.tm.serviceImpl;

import edu.mum.tm.domain.TmAttendance;
import edu.mum.tm.repository.TmAttendanceRepository;
import edu.mum.tm.service.TmAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TmAttendanceServiceImpl implements TmAttendanceService {

    @Autowired
    private TmAttendanceRepository tmAttendanceRepository;

    @Override
    public void addTmAttendance(TmAttendance entry) {
        tmAttendanceRepository.save(entry);
    }
}
