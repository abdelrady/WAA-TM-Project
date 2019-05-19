package edu.mum.tm.viewmodel;

import lombok.*;

import java.util.Dictionary;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentBlockData {
    private Long studentId;

    private String blockId;

    private int sessionsCount;

    private int daysPresent;

    private double percentageAttended;

    private double extraCredits;

    private Dictionary<String, Boolean> daysRecords;

}
