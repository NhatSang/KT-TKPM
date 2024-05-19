package com.se.student.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "t-student")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String gender;
    private int courseId;
}
