package com.klu.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.klu.dto.StudentRequestDTO;
import com.klu.dto.StudentResponseDTO;
import com.klu.model.Student;
import com.klu.repo.StudentRepo;
import com.klu.util.ExcelHelper;

@Service
public class StudentService {
  @Autowired
  private StudentRepo studentRepo;
  @Autowired
  private ModelMapper modelMapper;
  
  // Single Student Save
    public StudentResponseDTO saveStudent(StudentRequestDTO dto) {

        Student student = modelMapper.map(dto, Student.class);
        Student saved = studentRepo.save(student);

        return modelMapper.map(saved, StudentResponseDTO.class);
    }

    // Bulk Upload
    public List<StudentResponseDTO> saveAll(MultipartFile file) {

        try {
            List<Student> students = ExcelHelper.convertExcelToList(file.getInputStream());
            List<Student> saved = studentRepo.saveAll(students);

            return saved.stream()
                    .map(s -> modelMapper.map(s, StudentResponseDTO.class))
                    .toList();

        } catch (Exception e) {
            throw new RuntimeException("Excel file processing failed");
        }
    }
    
    // Bulk Download in Excel format
    public ByteArrayInputStream downloadStudents() {

        List<Student> students = studentRepo.findAll();

        return ExcelHelper.studentsToExcel(students);
    }
}