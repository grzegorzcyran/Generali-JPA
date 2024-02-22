package edu.grcy.generalijpa.hr.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class JobDTO {
    private final String jobTitle;
    private final int minSalary;
    private final int maxSalary;
}
