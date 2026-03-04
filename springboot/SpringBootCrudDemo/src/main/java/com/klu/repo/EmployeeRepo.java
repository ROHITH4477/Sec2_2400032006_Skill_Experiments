package com.klu.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klu.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{
  public List<Employee> findByName(String name);
  @Query("select e from Employee e where e.sal > ?1")
  public List<Employee> getAllEmpBySalGreaterThan(double sal);
}