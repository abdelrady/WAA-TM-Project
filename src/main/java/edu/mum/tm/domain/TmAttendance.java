
package edu.mum.tm.domain;

        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;

        import javax.persistence.*;
        import java.time.LocalDate;
 import java.util.List;
        import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table()
public class TmAttendance {

    @Id
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private Student student;

    @Column
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column()
    private TmTimeSlot type;

    @Column()
    private String location;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "block_id")
    private Block block;

    @ManyToMany(cascade = { CascadeType.MERGE })
    private List<CourseBlock> courses;

}