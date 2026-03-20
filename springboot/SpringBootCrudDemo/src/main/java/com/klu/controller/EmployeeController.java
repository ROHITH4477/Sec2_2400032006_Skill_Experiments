package com.klu.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klu.model.Employee;
import com.klu.service.EmployeeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/emp")
public class EmployeeController {
  
  @Autowired
  private EmployeeService employeeService;
  
  @PostMapping("/saveEmp")
  public ResponseEntity<Employee> saveEmployee(@RequestBody Employee e) {
    return new ResponseEntity<>(employeeService.saveEmployee(e),HttpStatus.CREATED);
  }
  
  @GetMapping("/getAllEmp")
  public ResponseEntity<List<Employee>> getEmployees(){
    return ResponseEntity.ok(employeeService.getEmployees());
  }
  
  @GetMapping("/getEmp/{id}")
  public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
    return ResponseEntity.ok(employeeService.getEmployee(id));
  }
  
  @PutMapping("/updateEmp/{id}")
  public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee e) {
    return ResponseEntity.ok(employeeService.updateEmployee(id, e));
  }
  
  @DeleteMapping("/deleteEmp/{id}")
  public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
    return ResponseEntity.ok(employeeService.deleteEmployee(id));
  }
  
  @GetMapping("/getEmpByName/{name}")
  public ResponseEntity<List<Employee>> getAllEmpByName(@PathVariable String name){
    return ResponseEntity.ok(employeeService.getAllEmpByName(name));
  }
  
  @GetMapping("/getEmpBySal/{sal}")
  public ResponseEntity<List<Employee>> getAllEmpSalGreaterthan(@PathVariable double sal){
    return ResponseEntity.ok(employeeService.getAllEmpSalGreaterthan(sal));
  }
}