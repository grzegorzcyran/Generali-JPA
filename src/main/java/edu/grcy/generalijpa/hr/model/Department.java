package edu.grcy.generalijpa.hr.model;

import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Id;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "DEPARTMENTS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Department {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "department_id")
    private int id;

    //map to column department_name in table
    @Column(name = "department_name")
    private String name;

    @Column(name = "location_id")
    private int locationId;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

}
