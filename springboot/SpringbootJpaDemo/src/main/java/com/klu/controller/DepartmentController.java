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

import com.klu.model.Department;
import com.klu.service.DepartmentService;

@RestController
@RequestMapping("/dept")
public class DepartmentController {
  @Autowired
  private DepartmentService departmentService;
  
  @PostMapping("/saveDept")
  public ResponseEntity<Department> saveDept(@RequestBody Department dept){
    return new ResponseEntity<Department>(departmentService.saveDept(dept),HttpStatus.CREATED);
  }
  
  @GetMapping("/getAllDept")
  public ResponseEntity<List<Department>> getAllDept(){
    return ResponseEntity.ok(departmentService.getAllDept());
  }
  
  @GetMapping("/getDept/{id}")
  public ResponseEntity<Department> getDeptById(@PathVariable Long id){
    return ResponseEntity.ok(departmentService.getDeptById(id));
  }
  
  @DeleteMapping("/deleteDept/{id}")
  public ResponseEntity<String> deleteDeptById(@PathVariable Long id){
    return ResponseEntity.ok(departmentService.deleteDeptById(id));
  }
}