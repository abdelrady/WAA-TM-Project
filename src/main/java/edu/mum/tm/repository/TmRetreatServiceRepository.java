package edu.mum.tm.repository;

import edu.mum.tm.domain.TmCheck;
import edu.mum.tm.domain.TmRetread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TmRetreatServiceRepository extends JpaRepository<TmRetread, Integer> {
    @Query(nativeQuery = true, value = "SELECT * From TMRETREAD")
     List<TmRetread> getAll();
}
