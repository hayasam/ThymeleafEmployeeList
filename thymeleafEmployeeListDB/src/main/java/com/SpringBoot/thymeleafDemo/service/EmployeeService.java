package com.SpringBoot.thymeleafDemo.service;

import java.util.List;

import com.SpringBoot.thymeleafDemo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void saveEmployee(Employee employee);
	
	public void deleteById(int id);

}

