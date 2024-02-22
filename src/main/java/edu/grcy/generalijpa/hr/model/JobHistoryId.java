package edu.grcy.generalijpa.hr.model;

import java.io.Serializable;
import java.util.Objects;

public class JobHistoryId implements Serializable {
    private int employeeId;
    private String startDate;

    // getters, setters, equals, and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobHistoryId that = (JobHistoryId) o;
        return employeeId == that.employeeId && Objects.equals(startDate, that.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, startDate);
    }
}