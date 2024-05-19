package com.se.course.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "t-course")
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
}
