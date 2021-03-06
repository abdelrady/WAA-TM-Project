
package edu.mum.tm.domain;

        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;

        import javax.persistence.*;
        import javax.validation.constraints.Max;
        import java.time.LocalDate;
        import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table()
public class Block {

    @Id
    private int id;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

    @Column
    //@Max(22)
    private Integer totalSessions;

    @Column
    private String MMYY;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE}, mappedBy = "block")
    private List<TmAttendance> tmAttendences;
}
