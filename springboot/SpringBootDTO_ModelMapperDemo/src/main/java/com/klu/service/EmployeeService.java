package com.klu.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.dto.EmployeeRequestDTO;
import com.klu.dto.EmployeeResponseDTO;
import com.klu.model.Employee;
import com.klu.repo.EmployeeRepo;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;

    // Create employee
    public EmployeeResponseDTO addEmployee(EmployeeRequestDTO dto) {

        Employee entity = modelMapper.map(dto, Employee.class);
        entity.setPassword("emp123");

        return modelMapper.map(employeeRepo.save(entity), EmployeeResponseDTO.class);
    }

    // Read all employees
    public List<EmployeeResponseDTO> getAllEmployees() {

        return employeeRepo.findAll()
                .stream()
                .map(emp -> modelMapper.map(emp, EmployeeResponseDTO.class))
                .collect(Collectors.toList());
    }

    // Read employee by id
    public EmployeeResponseDTO getEmployeeById(Long id) {

        Employee emp = employeeRepo.findById(id).orElseThrow();

        return modelMapper.map(emp, EmployeeResponseDTO.class);
    }

    // Update employee
    public EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO dto) {

        Employee emp = employeeRepo.findById(id).orElseThrow();

        emp.setName(dto.getName());
        emp.setEmail(dto.getEmail());
        emp.setDepartment(dto.getDepartment());
        emp.setSalary(dto.getSalary());

        return modelMapper.map(employeeRepo.save(emp), EmployeeResponseDTO.class);
    }

    // Delete employee
    public String deleteEmployee(Long id) {

        employeeRepo.findById(id).orElseThrow();
        employeeRepo.deleteById(id);

        return "Employee Deleted Successfully";
    }
}