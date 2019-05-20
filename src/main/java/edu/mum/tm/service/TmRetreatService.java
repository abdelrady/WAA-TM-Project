package edu.mum.tm.service;

import edu.mum.tm.domain.TmRetreat;

import java.time.LocalDate;
import java.util.List;

public interface TmRetreatService {
    List<TmRetreat>  findAll();

    void save(TmRetreat tmRetreat);

    void delete (TmRetreat tmRetreat);
}
