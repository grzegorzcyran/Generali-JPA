package edu.grcy.generalijpa.hr.rest;

import edu.grcy.generalijpa.hr.model.Employee;
import edu.grcy.generalijpa.hr.model.EmployeeDTO;
import edu.grcy.generalijpa.hr.model.EmployeeJobDTO;
import edu.grcy.generalijpa.hr.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> printAllEmployees() {
        return ResponseEntity.ok(employeeService.printAllEmployees());
    }

    @GetMapping(value = "/all", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping(value = "/allNative", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeDTO>> getAllEmployeesNative() {
        return ResponseEntity.ok(employeeService.getAllEmployeesNative());
    }

    @GetMapping(value = "/allEmployeeAndJob", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeDTO>> getAllEmployeesAndJobs() {
        return ResponseEntity.ok(employeeService.getAllEmployeesAndJobs());
    }

    @GetMapping(value = "/allEmployeeAndJobFlat", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeJobDTO>> getAllEmployeesAndJobsFlat() {
        return ResponseEntity.ok(employeeService.getAllEmployeesAndJobsFlat());
    }

    @GetMapping(value = "/salaryGreaterThan1000", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> getEmployeesWithSalaryGreaterThan() {
        return ResponseEntity.ok(employeeService.getEmployeesWithSalaryGreaterThan());
    }
}
