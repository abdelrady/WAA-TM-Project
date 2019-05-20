package edu.mum.tm.viewmodel;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentTotalStats {

    private Long mumId;

    private Long totalSessions;

    private Long sessionsAttended;

    private double attendedSessionsPercentage;

    public Long getTotalSessions() {
        return totalSessions;
    }

    public void setTotalSessions(Long totalSessions) {
        this.totalSessions = totalSessions;
    }

    public Long getSessionsAttended() {
        return sessionsAttended;
    }

    public void setSessionsAttended(Long sessionsAttended) {
        this.sessionsAttended = sessionsAttended;
    }

    public double getAttendedSessionsPercentage() {
        return attendedSessionsPercentage;
    }

    public void setAttendedSessionsPercentage(double attendedSessionsPercentage) {
        this.attendedSessionsPercentage = attendedSessionsPercentage;
    }
}
