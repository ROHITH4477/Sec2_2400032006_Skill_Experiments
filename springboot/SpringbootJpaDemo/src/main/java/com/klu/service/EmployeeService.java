package com.klu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.model.Department;
import com.klu.model.Employee;
import com.klu.repo.DepartmentRepo;
import com.klu.repo.EmployeeRepo;

@Service
public class EmployeeService {
  @Autowired
  private EmployeeRepo employeeRepo;
  @Autowired
  private DepartmentRepo departmentRepo;
  
  public Employee saveEmployee(Long id,Employee e) {
    //step-1: fetch Department based on given id
    Department dept = departmentRepo.findById(id).orElseThrow();
    e.setDepartment(dept);
    return employeeRepo.save(e);
  }
  
  public List<Employee> getAllEmployees(){
    return employeeRepo.findAll();
  }
  
  public Employee getEmployeeById(Long id) {
    return employeeRepo.findById(id).orElseThrow();
  }
  
  public String deleteEmployeeById(Long id) {
    employeeRepo.findById(id).orElseThrow();
    employeeRepo.deleteById(id);
    return "Employee Deleted successfully";
  }
}