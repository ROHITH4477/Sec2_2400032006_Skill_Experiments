package com.klu.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Positive;

@Data
public class StudentRequestDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Course is required")
    private String course;

    @NotBlank(message = "Branch is required")
    private String branch;

    @NotNull(message = "Fees cannot be null")
    @Positive(message = "Fees must be positive")
    private Double fees;
    
}