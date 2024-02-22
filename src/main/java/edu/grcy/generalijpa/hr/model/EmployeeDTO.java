package edu.grcy.generalijpa.hr.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class EmployeeDTO {
    private final int id;
    private final String name;
    private final String surname;
    private final int salary;
    private final String email;
    private final JobDTO jobDTO;

    public EmployeeDTO(int id, String name, String surname, int salary, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.email = email;
        this.jobDTO = null;
    }
}
