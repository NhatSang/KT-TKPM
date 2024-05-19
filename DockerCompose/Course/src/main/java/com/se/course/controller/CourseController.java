package com.se.course.controller;

import com.se.course.entity.Course;
import com.se.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/save")
    public Course save(@RequestBody Course course){
        return courseService.saveCourse(course);
    }

    @GetMapping("/get/{id}")
    public Optional<Course> getById(@PathVariable int id){
        return  courseService.getCourseById(id);
    }
}
