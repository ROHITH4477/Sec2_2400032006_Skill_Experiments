package com.klu.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.dto.StudentRequestDTO;
import com.klu.dto.StudentResponseDTO;
import com.klu.model.Student;
import com.klu.repo.StudentRepo;

@Service
public class StudentService {

  @Autowired
  public StudentRepo studentRepo;

  @Autowired
  public ModelMapper modelMapper;

  // Create student
  public StudentResponseDTO addStudent(StudentRequestDTO reqdto) {

    // Step 1: Convert DTO to entity
    Student entity = modelMapper.map(reqdto, Student.class);

    // Step 2: Assign default password
    entity.setPassword("klu123");

    return modelMapper.map(studentRepo.save(entity), StudentResponseDTO.class);
  }

  // Read all students
  public List<StudentResponseDTO> getAllStudents() {
    List<Student> list = studentRepo.findAll();
    return list.stream()
        .map(student -> modelMapper.map(student, StudentResponseDTO.class))
        .collect(Collectors.toList());
  }

  // Read specific student
  public StudentResponseDTO getStudentById(Long id) {
    Student s = studentRepo.findById(id).orElseThrow();
    return modelMapper.map(s, StudentResponseDTO.class);
  }

  // Update student
  public StudentResponseDTO updateStudentById(Long id, StudentRequestDTO reqdto) {

    // Step 1: Fetch existing student
    Student exist = studentRepo.findById(id).orElseThrow();

    // Step 2: Update fields
    exist.setName(reqdto.getName());
    exist.setEmail(reqdto.getEmail());
    exist.setBranch(reqdto.getBranch());
    exist.setCourse(reqdto.getCourse());
    exist.setFees(reqdto.getFees());

    // Step 3: Save updated student
    Student updatedStudent = studentRepo.save(exist);

    // Step 4: Convert to ResponseDTO
    return modelMapper.map(updatedStudent, StudentResponseDTO.class);
  }

  // Delete student
  public String deleteStudentById(Long id) {
    studentRepo.findById(id).orElseThrow();
    studentRepo.deleteById(id);
    return "Student Deleted Successfully";
  }
}