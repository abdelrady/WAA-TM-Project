package edu.mum.tm.serviceImpl;

import edu.mum.tm.domain.Block;
import edu.mum.tm.repository.BlockRepository;
import edu.mum.tm.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BlockServiceImpl implements BlockService {

    @Autowired
    BlockRepository blockRepository;

    @Override
    public Block getBlockWithDate(LocalDate dt) {
        return blockRepository.getBlockWithDate(dt);
    }
}
