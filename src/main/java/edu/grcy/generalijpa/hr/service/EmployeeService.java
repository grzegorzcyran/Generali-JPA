package edu.grcy.generalijpa.hr.service;

import edu.grcy.generalijpa.hr.model.Employee;
import edu.grcy.generalijpa.hr.model.EmployeeDTO;
import edu.grcy.generalijpa.hr.model.EmployeeJobDTO;
import edu.grcy.generalijpa.hr.repos.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> printAllEmployees() {
        return employeeRepository.findAll();
    }

    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAllJPQL();
    }

    public List<EmployeeDTO> getAllEmployeesNative() {
        return employeeRepository.findAllNative();
    }

    public List<EmployeeDTO> getAllEmployeesAndJobs() {
        return employeeRepository.findAllEmployeeAndJobInfo();
    }

    public List<EmployeeJobDTO> getAllEmployeesAndJobsFlat() {
        return employeeRepository.findAllEmployeeAndJobInfoFlat();
    }
}
