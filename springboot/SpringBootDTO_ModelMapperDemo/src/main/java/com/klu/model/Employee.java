package com.klu.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee1")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private double salary;

    @Column(nullable = false)
    private String password;   // hidden from UI
}