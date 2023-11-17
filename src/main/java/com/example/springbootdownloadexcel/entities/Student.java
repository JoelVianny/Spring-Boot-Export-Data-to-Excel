package com.example.springbootdownloadexcel.entities;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "student")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String name;
    private String surname;
    private int age;
    private String phone;


}
