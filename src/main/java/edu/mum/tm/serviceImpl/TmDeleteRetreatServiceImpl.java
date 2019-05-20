package edu.mum.tm.serviceImpl;

import edu.mum.tm.repository.TmDeleteRetreatServiceRepository;
import edu.mum.tm.service.TmDeleteRetreatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TmDeleteRetreatServiceImpl implements TmDeleteRetreatService {

    @Autowired
    public TmDeleteRetreatServiceRepository tmDeleteRetreatServiceRepository;
    @Override
    public void deleteItem(String studentid, Date date) {
        tmDeleteRetreatServiceRepository.deleteitem(studentid,date);
    }
}
