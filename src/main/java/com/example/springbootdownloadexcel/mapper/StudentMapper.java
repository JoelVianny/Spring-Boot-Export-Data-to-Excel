package com.example.springbootdownloadexcel.mapper;

import com.example.springbootdownloadexcel.dto.StudentDto;
import com.example.springbootdownloadexcel.entities.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDto mapToStudentDto(Student user);

    Student mapToStudentEntity(StudentDto studentDto);
}
