package edu.grcy.generalijpa.hr.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "EMPLOYEES")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NamedNativeQuery(
        name = "Employee.findAllNative",
        query = "SELECT e.employee_id as id, e.first_name as name, e.last_name as surname, e.salary as salary, e.email as email FROM employees e",
        resultSetMapping = "EmployeeDTOMapping"
)
@SqlResultSetMapping(
        name = "EmployeeDTOMapping",
        classes = @ConstructorResult(
                targetClass = EmployeeDTO.class,
                columns = {
                        @ColumnResult(name = "id", type = Integer.class),
                        @ColumnResult(name = "name", type = String.class),
                        @ColumnResult(name = "surname", type = String.class),
                        @ColumnResult(name = "salary", type = Integer.class),
                        @ColumnResult(name = "email", type = String.class)
                }
        )
)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int id;

    //map to column first_name in table
    @Column(name = "first_name")
    private String name;

    @Column(name = "last_name")
    private String surname;

    @Column(name = "salary")
    private int salary;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<JobHistory> jobHistory;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToOne
    @JoinColumn(name = "job_id")
    private Job job;
}
