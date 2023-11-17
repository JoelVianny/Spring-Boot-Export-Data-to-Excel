package com.example.springbootdownloadexcel.controllers;


import com.example.springbootdownloadexcel.entities.Student;
import com.example.springbootdownloadexcel.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/api/student/")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/all")
    public List<Student> getAllStudent(){
        return  studentService.getAllStudent();
    }
    @GetMapping("/download")
    private ResponseEntity<InputStreamResource> download() throws IOException {
        String fileName = "student.xlsx";

        ByteArrayInputStream inputStream = studentService.getDataDownloaded();
        InputStreamResource resource =  new InputStreamResource(inputStream);
        ResponseEntity<InputStreamResource> resourceResponseEntity = ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename" +fileName)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(resource);
        return  resourceResponseEntity;
    }
}
