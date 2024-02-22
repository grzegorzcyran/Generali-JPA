package edu.grcy.generalijpa.hr.repos;

import edu.grcy.generalijpa.hr.model.Employee;
import edu.grcy.generalijpa.hr.model.EmployeeDTO;

import edu.grcy.generalijpa.hr.model.EmployeeJobDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Override
    List<Employee> findAll();

    @Query("SELECT new edu.grcy.generalijpa.hr.model.EmployeeDTO(e.id, e.name," +
            "e.surname, e.salary, e.email) " +
            "FROM Employee e "
    )
    List<EmployeeDTO> findAllJPQL();


    @Query(nativeQuery = true, name = "Employee.findAllNative")
    List<EmployeeDTO> findAllNative();

    @Query("SELECT new edu.grcy.generalijpa.hr.model.EmployeeDTO(" +
            "e.id, e.name, e.surname, e.salary, e.email, " +
            "new edu.grcy.generalijpa.hr.model.JobDTO(j.title, j.minSalary, j.maxSalary)) " +
            "FROM Employee e JOIN e.job j")
    List<EmployeeDTO> findAllEmployeeAndJobInfo();

    @Query("SELECT new edu.grcy.generalijpa.hr.model.EmployeeJobDTO(" +
            "e.id, e.name, e.surname, e.salary, e.email, " +
            "j.title, j.minSalary, j.maxSalary, 'text') " +
            "FROM Employee e JOIN e.job j")
    List<EmployeeJobDTO> findAllEmployeeAndJobInfoFlat();
}
