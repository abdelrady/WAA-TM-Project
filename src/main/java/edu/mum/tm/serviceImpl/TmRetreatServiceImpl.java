package edu.mum.tm.serviceImpl;

import edu.mum.tm.domain.TmRetreat;
import edu.mum.tm.repository.TmRetreatRepository;
import edu.mum.tm.service.TmRetreatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TmRetreatServiceImpl implements TmRetreatService {

    @Autowired
    public TmRetreatRepository tmRetreatRepository;
    @Override
    public List<TmRetreat> findAll() {
        return tmRetreatRepository.findAll();
    }

    @Override
    public void save(TmRetreat tmRetreat) {
        //check for duplicates?
        tmRetreatRepository.save(tmRetreat);
    }

    @Override
    public void delete(TmRetreat tmRetreat) {
        tmRetreatRepository.delete(tmRetreat);
    }


}
