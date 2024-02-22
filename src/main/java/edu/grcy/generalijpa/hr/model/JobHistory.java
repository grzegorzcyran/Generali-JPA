package edu.grcy.generalijpa.hr.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "JOB_HISTORY")
@IdClass(JobHistoryId.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class JobHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeId;

    @Id
    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "job_id")
    private String jobId;

    @Column(name = "department_id")
    private int departmentId;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
