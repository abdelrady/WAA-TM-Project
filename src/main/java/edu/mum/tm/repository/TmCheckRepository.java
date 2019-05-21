package edu.mum.tm.repository;

import edu.mum.tm.domain.TmCheck;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TmCheckRepository extends CrudRepository<TmCheck, Integer> {

    List<TmCheck> findAll();
}