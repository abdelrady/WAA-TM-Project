package edu.mum.tm.repository;

import edu.mum.tm.domain.TmRetread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;


public interface TmAddRetreatServiceRepository extends JpaRepository<TmRetread, Integer> {

//    @Query(nativeQuery = true, value = "INSERT INTO TMRETREAD (STUDENTID,date) VALUES (?1,?2) " +
////            " ON DUPLICATE KEY UPDATE STUDENTID = :studentId AND DATE =:date")
    @Modifying
    @Transactional
    @Query(value = "insert into TMRETREAD(STUDENTID,date) values(?1,?2)",nativeQuery = true)
    void add(String studentid, Date date);


}
