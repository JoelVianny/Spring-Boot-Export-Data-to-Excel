package com.example.springbootdownloadexcel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private  Long id;
    private String name;
    private String surname;
    private int age;
    private String phone;


}
