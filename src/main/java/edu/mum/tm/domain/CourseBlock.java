
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
public class CourseBlock {

    @Id
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    //@Fetch(FetchMode.JOIN)
    @JoinColumn
    private Course course;

    @ManyToOne(fetch = FetchType.EAGER)
    //@Fetch(FetchMode.JOIN)
    @JoinColumn
    private Block block;

    @ManyToOne(fetch = FetchType.EAGER)
    //@Fetch(FetchMode.JOIN)
    @JoinColumn
    private Professor professor;

    @ManyToMany(cascade = { CascadeType.MERGE }, mappedBy = "courses")
    private List<Student> students;

}

