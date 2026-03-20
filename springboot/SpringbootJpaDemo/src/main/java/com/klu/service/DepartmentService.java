package com.klu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.model.Department;
import com.klu.repo.DepartmentRepo;

@Service
public class DepartmentService {
  @Autowired
  private DepartmentRepo departmentRepo;
  
  public Department saveDept(Department dept) {
    return departmentRepo.save(dept);
  }
  
  public List<Department> getAllDept(){
    return departmentRepo.findAll();
  }
  
  public Department getDeptById(Long id) {
    return departmentRepo.findById(id).orElseThrow();
  }
  
  public String deleteDeptById(Long id) {
    departmentRepo.findById(id).orElseThrow();
    departmentRepo.deleteById(id);
    return "Department Deleted successfully";
  }
}