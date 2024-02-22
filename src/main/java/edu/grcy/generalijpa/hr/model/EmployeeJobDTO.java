package edu.grcy.generalijpa.hr.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class EmployeeJobDTO {
    private final int id;
    private final String name;
    private final String surname;
    private final int salary;
    private final String email;
    private final String jobTitle;
    private final int minSalary;
    private final int maxSalary;
    private final String text;

}
