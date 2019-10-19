package com.attacomsian.jpa.composite.repositories;

import com.attacomsian.jpa.composite.domains.Employee;
import com.attacomsian.jpa.composite.domains.EmployeeId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, EmployeeId> {

    List<Employee> findByEmployeeIdDepartmentId(Long departmentId);
}
