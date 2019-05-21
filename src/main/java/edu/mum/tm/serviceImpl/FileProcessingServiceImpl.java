package edu.mum.tm.serviceImpl;

import edu.mum.tm.domain.FileProcessing;
import edu.mum.tm.repository.FileProcessingRepository;
import edu.mum.tm.service.FileProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileProcessingServiceImpl implements FileProcessingService {
    @Autowired
    private FileProcessingRepository fileProcessingRepository;
    @Override
    public FileProcessing getById(long fileId) {
        return fileProcessingRepository.getById(fileId);
    }

    @Override
    public List<FileProcessing> getAll() {
        return fileProcessingRepository.getAll();
    }

    @Override
    public FileProcessing Save(FileProcessing fileProcessing) {
        return fileProcessingRepository.save(fileProcessing);
    }

    @Override
    public void addFileProcessing(FileProcessing entry){fileProcessingRepository.save(entry);}
}
