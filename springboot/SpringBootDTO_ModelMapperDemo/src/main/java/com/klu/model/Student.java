package com.klu.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student1")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String branch;

    @Column(nullable = false)
    private String course;

    @Column(nullable = false)
    private double fees;

    @Column(nullable = false)
    private String password;   // hidden from UI
}