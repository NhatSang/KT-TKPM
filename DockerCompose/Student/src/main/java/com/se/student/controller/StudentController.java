package com.se.student.controller;

import com.se.student.dto.StudentDto;
import com.se.student.entity.Student;
import com.se.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public List<StudentDto> getAllStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping("/allno")
    public List<Student> getAll(){
        return studentService.getAll();
    }

    @PostMapping("/save")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }
}
