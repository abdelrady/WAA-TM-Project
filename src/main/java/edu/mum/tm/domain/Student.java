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
    private String mumId;

    @Column
    private String entry;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToMany(cascade = { CascadeType.MERGE })
    private List<CourseBlock> courses;

    @OneToMany(mappedBy = "student")
    private List<TmAttendance> tmAttendences;
}
