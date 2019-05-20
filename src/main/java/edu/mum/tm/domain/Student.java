package edu.mum.tm.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table()
public class Student {

    @Id
    private Long mumId;

    @Column // MM-YY
    private String entry;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToMany(cascade = { CascadeType.MERGE })
    @JoinTable(name = "students_block_courses", joinColumns = {@JoinColumn(name = "student_id")}, inverseJoinColumns = {@JoinColumn(name = "course_block_id")})
    private List<CourseBlock> courses;

    @OneToMany(mappedBy = "student")
    private List<TmAttendance> tmAttendences;

    @Column
    private String ATTENDED_SESSIONS;
    @Column
    private String PERCENTAGE;

}
