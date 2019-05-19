package edu.mum.tm.serviceImpl;

import edu.mum.tm.domain.Entry;
import edu.mum.tm.repository.EntryRepository;
import edu.mum.tm.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryServiceImpl implements EntryService {

    @Autowired
    private EntryRepository entryRepository;

    @Override
    public List<Entry> getAll() {
        return entryRepository.findAll();
    }

    @Override
    public Entry getById(Integer entryId) {
        return entryRepository.findById(entryId).get();
    }

}
