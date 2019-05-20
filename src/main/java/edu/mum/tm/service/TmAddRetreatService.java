package edu.mum.tm.service;

import edu.mum.tm.domain.TmRetread;

import java.util.Date;
import java.util.List;

public interface TmAddRetreatService {
    void add(String studentId, Date date);
}
