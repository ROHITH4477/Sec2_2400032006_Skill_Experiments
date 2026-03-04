package com.klu.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequestDTO {

    @NotEmpty(message = "Employee name is required")
    private String name;

    @Email(message = "Email must have proper format")
    private String email;

    @NotBlank(message = "Department must not be null")
    private String department;

    @Positive(message = "Salary must be positive number")
    private double salary;
}