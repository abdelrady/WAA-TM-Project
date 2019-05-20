package edu.mum.tm.repository;

import edu.mum.tm.domain.TmAttendance;
import org.springframework.data.repository.CrudRepository;

import java.util.Iterator;

public interface TmAttendanceRepository extends CrudRepository<TmAttendance, Integer> {

    Iterable<TmAttendance> findByStudentMumIdAndBlockId(Long studentId, Integer blockId);
}
