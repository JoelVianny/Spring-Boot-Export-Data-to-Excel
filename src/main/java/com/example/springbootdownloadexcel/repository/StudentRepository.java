package com.example.springbootdownloadexcel.repository;

import com.example.springbootdownloadexcel.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  StudentRepository extends JpaRepository<Student,Long> {
    Optional<Student> findByName(String name);
    Optional<Student> findByNameAndAge(String name,int age);
}
