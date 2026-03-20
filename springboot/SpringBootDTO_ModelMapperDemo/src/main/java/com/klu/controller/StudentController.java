package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klu.dto.StudentRequestDTO;
import com.klu.dto.StudentResponseDTO;
import com.klu.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/stud")
@CrossOrigin("*")
public class StudentController {

  @Autowired
  private StudentService studentService;

  // Create Student
  @PostMapping("/addStudent")
  public ResponseEntity<StudentResponseDTO> addStudent(
      @Valid @RequestBody StudentRequestDTO dto) {

    return new ResponseEntity<>(
        studentService.addStudent(dto),
        HttpStatus.CREATED);
  }

  // Get all students
  @GetMapping("/getAllStudents")
  public ResponseEntity<List<StudentResponseDTO>> getAllStudents() {

    return ResponseEntity.ok(studentService.getAllStudents());
  }

  // Get student by id
  @GetMapping("/getStudent/{id}")
  public ResponseEntity<StudentResponseDTO> getStudentById(
      @PathVariable Long id) {

    return ResponseEntity.ok(studentService.getStudentById(id));
  }

  // Update student
  @PutMapping("/updateStudent/{id}")
  public ResponseEntity<StudentResponseDTO> updateStudent(
      @PathVariable Long id,
      @Valid @RequestBody StudentRequestDTO reqDto) {

    return ResponseEntity.ok(
        studentService.updateStudentById(id, reqDto));
  }

  // Delete student
  @DeleteMapping("/deleteStudent/{id}")
  public ResponseEntity<String> deleteStudent(
      @PathVariable Long id) {

    return ResponseEntity.ok(
        studentService.deleteStudentById(id));
  }
}