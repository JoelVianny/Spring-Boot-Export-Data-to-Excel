package com.example.springbootdownloadexcel.service;

import com.example.springbootdownloadexcel.dto.StudentDto;
import com.example.springbootdownloadexcel.entities.Student;
import com.example.springbootdownloadexcel.repository.StudentRepository;
import com.example.springbootdownloadexcel.utils.ExcelUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAllStudent(){
        return  studentRepository.findAll();
    }

    public Optional<Student> getStudentByName(String name){
        return  studentRepository.findByName(name);
    }
    public Student create(Student stu){
        return  studentRepository.save(stu);
    }
    public Student  edit(StudentDto studentDto , long id){
        Student stu = new Student();
        stu.setName(studentDto.getName());
        stu.setSurname(studentDto.getSurname());
        stu.setPhone(studentDto.getPhone());
        stu.setAge(studentDto.getAge());

        return studentRepository.save(stu);
    }

    public ByteArrayInputStream getDataDownloaded() throws IOException {
        List<Student> students = studentRepository.findAll();
        ByteArrayInputStream data = ExcelUtils.dataToExcel(students);
        return data;

    }


}
