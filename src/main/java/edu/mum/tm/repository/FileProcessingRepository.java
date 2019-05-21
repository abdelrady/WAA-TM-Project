package edu.mum.tm.repository;

import edu.mum.tm.domain.FileProcessing;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FileProcessingRepository extends CrudRepository<FileProcessing, Long>  {
    @Query(nativeQuery = true, value = "SELECT * From FileProcessing" )
    List<FileProcessing> getAll();


    @Query(nativeQuery = true, value = "SELECT * From FILE_PROCESSING  f where f.Id = :fileId" )
    FileProcessing getById(long fileId);
}
