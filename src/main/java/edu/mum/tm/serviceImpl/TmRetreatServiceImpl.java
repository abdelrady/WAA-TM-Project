package edu.mum.tm.serviceImpl;

import edu.mum.tm.domain.TmRetread;
import edu.mum.tm.repository.TmRetreatServiceRepository;
import edu.mum.tm.service.TmRetreatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TmRetreatServiceImpl implements TmRetreatService {

    @Autowired
    public TmRetreatServiceRepository tmRetreatServiceRepository;
    @Override
    public List<TmRetread> getAll() {
        return tmRetreatServiceRepository.getAll();
    }
}
