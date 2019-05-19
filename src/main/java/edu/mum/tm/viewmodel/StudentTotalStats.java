package edu.mum.tm.viewmodel;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentTotalStats {

    private Long totalSessions;

    private Long sessionsAttended;

    private double attendedSessionsPercentage;
}
