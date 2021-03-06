package edu.mum.tm.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TMCHECK")
public class TmCheck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Long Id;

    @Column(name="STUDENTID")
    private Long studentId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "Date")
    private LocalDate date;

}
