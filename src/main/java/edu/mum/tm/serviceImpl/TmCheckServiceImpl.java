package edu.mum.tm.serviceImpl;

import edu.mum.tm.domain.TmCheck;
import edu.mum.tm.repository.TmCheckRepository;
import edu.mum.tm.service.TmCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TmCheckServiceImpl implements TmCheckService {

    @Autowired
    TmCheckRepository tmCheckRepository;

    @Override
    public List<TmCheck> findAll() {
        return tmCheckRepository.findAll();
    }

    @Override
    public void save(TmCheck tmCheck) {
        tmCheckRepository.save(tmCheck);
    }

    @Override
    public void delete(TmCheck tmCheck) {
            tmCheckRepository.delete(tmCheck);
    }
}
