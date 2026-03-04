package com.klu.service;

import java.util.List;

import com.klu.model.Employee;

public interface EmployeeService {
  //creating Employee info into DB
  Employee saveEmployee(Employee e);
  //retrieving all Employees from DB based on primary key
  List<Employee> getEmployees();
  //retrieving all employees from DB based on name
  List<Employee> getAllEmpByName(String name);
  //retrieving all employees from DB based on Salary greaterthan something
  List<Employee> getAllEmpSalGreaterthan(double sal);
  //retrieving specific Employee based on ID from DB
  Employee getEmployee(Long id);
  //updating existed Employee based on specific ID into DB
  Employee updateEmployee(Long id,Employee e);
  //deleting existed Employee based on specific ID from DB
  String deleteEmployee(Long id);
}