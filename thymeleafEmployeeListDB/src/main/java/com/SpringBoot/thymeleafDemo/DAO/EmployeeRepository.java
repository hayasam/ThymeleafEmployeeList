package com.SpringBoot.thymeleafDemo.DAO;
import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBoot.thymeleafDemo.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it no need to write any code.
	
}
