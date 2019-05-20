
package edu.mum.tm.domain;

        import com.fasterxml.jackson.annotation.JsonIgnore;
        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;
        import org.hibernate.annotations.Fetch;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    @JsonIgnore
    private Student student;

    @Column
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column()
    private TmTimeSlot type;

    @Column()
    private String location;

    @ManyToOne(fetch=FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "block_id")
    @JsonIgnore
    private Block block;

//    @ManyToMany(cascade = { CascadeType.MERGE })
//    private List<CourseBlock> courses;

}