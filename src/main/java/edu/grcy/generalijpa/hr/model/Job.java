package edu.grcy.generalijpa.hr.model;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "JOBS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Job {
    @Id
    @Column(name = "job_id")
    @GeneratedValue(strategy = IDENTITY)
    private String id;

    //map to column job_title in table
    @Column(name = "job_title")
    private String title;

    @Column(name = "min_salary")
    private int minSalary;

    @Column(name = "max_salary")
    private int maxSalary;

    @OneToOne(mappedBy = "job")
    private Employee employee;
}
