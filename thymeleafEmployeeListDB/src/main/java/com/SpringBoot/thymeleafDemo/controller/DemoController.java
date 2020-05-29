package com.SpringBoot.thymeleafDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SpringBoot.thymeleafDemo.entity.Employee;
import com.SpringBoot.thymeleafDemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class DemoController {


	private EmployeeService employeeService;

	@Autowired
	public DemoController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}

	@GetMapping("/list")
	public String showemployeeList(Model model) {
		List<Employee> employeeList = employeeService.findAll();
		model.addAttribute("employees",employeeList);
		return "list-employee";
	}

	@GetMapping("/showaddform")
	public String addForm(Model model){
		Employee employee = new Employee();
		model.addAttribute("employee",employee); 
		return "add-employee";
	}
	
	@PostMapping("/save")
	public String processForm(@ModelAttribute("employee")Employee theEmployee,Model model) {
		employeeService.saveEmployee(theEmployee);
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showformforupdate")
	public String showupdateForm(@RequestParam("employeeId")int employeeId,Model model) {
		Employee employee = employeeService.findById(employeeId);
		model.addAttribute("employee",employee);
		return "add-employee";
	}
	
	@RequestMapping("/showformfordelete")
	public String showdeleteForm(@RequestParam("employeeId")int employeeId,Model model) {
		employeeService.deleteById(employeeId);
		return "redirect:/employees/list";
	}
}
