package com.SpringBoot.thymeleafDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.thymeleafDemo.DAO.EmployeeRepository;
import com.SpringBoot.thymeleafDemo.entity.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository=theEmployeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> result = employeeRepository.findById(id);
		Employee temp = null;
		if(result.isPresent()) {
			temp = result.get();
		}else {
			throw new RuntimeException("Don't find this id :- " + id);
		}
		
		return temp;
	}

	@Override
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
		
	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}


	

}
