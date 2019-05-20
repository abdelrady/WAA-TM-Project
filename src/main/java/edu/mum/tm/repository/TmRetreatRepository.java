package edu.mum.tm.repository;

import edu.mum.tm.domain.Role;
import edu.mum.tm.domain.TmRetreat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;


public interface TmRetreatRepository extends CrudRepository<TmRetreat, Integer> {

    List<TmRetreat> findAll();

}
