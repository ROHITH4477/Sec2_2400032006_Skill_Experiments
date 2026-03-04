package com.klu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.exception.ResourceNotFoundException;
import com.klu.model.Employee;
import com.klu.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{
  @Autowired
  private EmployeeRepo employeeRepo;
  
  @Override
  public Employee saveEmployee(Employee e) {
    // TODO Auto-generated method stub
    return employeeRepo.save(e);
  }

  @Override
  public List<Employee> getEmployees() {
    // TODO Auto-generated method stub
    return employeeRepo.findAll();
  }

  @Override
  public Employee getEmployee(Long id) {
    // first approach
//    Optional<Employee> exist = employeeRepo.findById(id);
//    if(exist.isPresent())
//      return exist.get();
//    return null;
    
    //second approach
    return employeeRepo.findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("Employee Not Found With ID:" + id));
  }

  @Override
  public Employee updateEmployee(Long id, Employee e) {
    // TODO Auto-generated method stub
    Employee exist = employeeRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Employee Not Found With ID:" + id));
    
    exist.setName(e.getName());
    exist.setEmail(e.getEmail());
    exist.setDept(e.getDept());
    exist.setDesig(e.getDesig());
    exist.setSal(e.getSal());
    return employeeRepo.save(exist);
  }

  @Override
  public String deleteEmployee(Long id) {
    // TODO Auto-generated method stub
    Employee exist = employeeRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Employee Not Found With ID:" + id));
    employeeRepo.deleteById(id);
    return "Employee Removed Successfully";
  }

  @Override
  public List<Employee> getAllEmpByName(String name) {
    // TODO Auto-generated method stub
    return employeeRepo.findByName(name);
  }

  @Override
  public List<Employee> getAllEmpSalGreaterthan(double sal) {
    // TODO Auto-generated method stub
    return employeeRepo.getAllEmpBySalGreaterThan(sal);
  }
}