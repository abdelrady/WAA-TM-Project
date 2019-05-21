package edu.mum.tm.service;


import edu.mum.tm.domain.TmCheck;

import java.util.List;

public interface TmCheckService {
    List<TmCheck> findAll();

    void save(TmCheck tmCheck);

    void delete (TmCheck tmCheck);
}
