package edu.mum.tm.service;

import edu.mum.tm.domain.Entry;

import java.util.List;

public interface EntryService {
    List<Entry> getAll();
    Entry getById(Integer entryId);
}
