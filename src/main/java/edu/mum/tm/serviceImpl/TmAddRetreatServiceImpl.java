package edu.mum.tm.serviceImpl;

import edu.mum.tm.domain.TmRetread;
import edu.mum.tm.repository.TmAddRetreatServiceRepository;
import edu.mum.tm.repository.TmRetreatServiceRepository;
import edu.mum.tm.service.TmAddRetreatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TmAddRetreatServiceImpl implements TmAddRetreatService {

    @Autowired
    public TmAddRetreatServiceRepository tmAddRetreatServiceRepository;
    @Override
    public void add(String studentId, Date date) {
        tmAddRetreatServiceRepository.add(studentId,date);
    }
}
