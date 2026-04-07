
package com.klu.controller;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.klu.dto.StudentRequestDTO;
import com.klu.dto.StudentResponseDTO;
import com.klu.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/students")
public class StudentController {
  @Autowired
  private StudentService service;

    // Single Insert
    @PostMapping
    public ResponseEntity<StudentResponseDTO> addStudent(
            @Valid @RequestBody StudentRequestDTO dto) {
        return new ResponseEntity<>(service.saveStudent(dto),HttpStatus.CREATED);
    }

    // Excel Upload
    @PostMapping("/upload")
    public ResponseEntity<List<StudentResponseDTO>> uploadExcel(
            @RequestParam("file") MultipartFile file) {
        return new ResponseEntity<>(service.saveAll(file),HttpStatus.CREATED);
    }
    
    // Excel Download
    @GetMapping("/download")
    public ResponseEntity<InputStreamResource> downloadStudents() {

        ByteArrayInputStream in = service.downloadStudents();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition",
                "attachment; filename=students.xlsx");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(in));
    }
}