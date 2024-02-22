package edu.grcy.generalijpa.hr.service;

import edu.grcy.generalijpa.hr.model.Employee;
import edu.grcy.generalijpa.hr.model.EmployeeDTO;
import edu.grcy.generalijpa.hr.model.EmployeeJobDTO;
import edu.grcy.generalijpa.hr.repos.EmployeeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @PersistenceContext
    private EntityManager entityManager;

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

    public List<Employee> getEmployeesWithSalaryGreaterThan() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
        Root<Employee> employeeRoot = query.from(Employee.class);

        Predicate salaryGreaterThan = cb.greaterThan(employeeRoot.get("salary"), 1000);
        query.where(salaryGreaterThan);

        return entityManager.createQuery(query).getResultList();
    }
}
