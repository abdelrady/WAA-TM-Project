package edu.mum.tm.service;

import edu.mum.tm.domain.Block;

import java.time.LocalDate;

public interface BlockService {
    public Block getBlockWithDate(LocalDate dt);
}
