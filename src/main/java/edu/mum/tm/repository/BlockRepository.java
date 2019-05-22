package edu.mum.tm.repository;


import edu.mum.tm.domain.Block;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface BlockRepository extends CrudRepository<Block, Long> {


    @Query(nativeQuery = true, value = "Select * from Block b where :dt between b.start_date and  b.end_date")
   Block getBlockWithDate(LocalDate dt);
}