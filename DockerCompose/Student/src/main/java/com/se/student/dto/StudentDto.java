package com.se.student.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDto {
    private int id;
    private String name;
    private int age;
    private String gender;
    private Course course;
}
