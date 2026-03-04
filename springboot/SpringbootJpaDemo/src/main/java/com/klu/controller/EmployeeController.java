package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klu.model.Employee;
import com.klu.service.EmployeeService;


@RestController
@RequestMapping("/emp5")
public class EmployeeController {
  @Autowired
  private EmployeeService employeeService;
  
  @PostMapping("/saveEmp/{id}")
  public ResponseEntity<Employee> saveEmployee(@PathVariable Long id,@RequestBody Employee e) {
    return new ResponseEntity<Employee>(employeeService.saveEmployee(id, e),HttpStatus.CREATED);
  }
  
  @GetMapping("/getAllEmp")
  public ResponseEntity<List<Employee>> getAllEmployees(){
    return ResponseEntity.ok(employeeService.getAllEmployees());
  }
  
  @GetMapping("/getEmp/{id}")
  public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
    return ResponseEntity.ok(employeeService.getEmployeeById(id));
  }
  
  @DeleteMapping("/deleteEmp/{id}")
  public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id){
    return ResponseEntity.ok(employeeService.deleteEmployeeById(id));
  }
}