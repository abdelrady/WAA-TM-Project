package edu.mum.tm.repository;

import edu.mum.tm.domain.TmRetread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Date;

public interface TmDeleteRetreatServiceRepository extends JpaRepository<TmRetread, Integer> {
    @Modifying
    @Transactional
    @Query(value = "delete from TMRETREAD where STUDENTID=?1 and DATE=?2",nativeQuery = true)
    void deleteitem(String studentid, Date date);
}
