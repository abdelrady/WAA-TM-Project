package edu.mum.tm.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FileProcessing")
public class FileProcessing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @Column(name="StartTime")
    private LocalDateTime StartTime;

    @Column(name="EndTIme")
    private LocalDateTime EndTIme;


    @Column()
    private boolean Done;

    @Column(name="RowsCount")
    private int RowsCount;

    @Column()
    private int Processed;

}
