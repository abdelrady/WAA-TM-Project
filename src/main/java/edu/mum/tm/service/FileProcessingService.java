package edu.mum.tm.service;


import edu.mum.tm.domain.FileProcessing;

import java.util.List;


public interface FileProcessingService {
    FileProcessing getById(Integer fileId);
    List<FileProcessing> getAll();

    FileProcessing Save(FileProcessing fileProcessing);
    void addFileProcessing(FileProcessing entry);
}
