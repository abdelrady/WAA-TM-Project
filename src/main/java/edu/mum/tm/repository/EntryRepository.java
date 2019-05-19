package edu.mum.tm.repository;

import edu.mum.tm.domain.Entry;
import edu.mum.tm.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EntryRepository extends JpaRepository<Entry, Integer> {

}
