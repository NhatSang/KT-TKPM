package com.se.course.service;

import com.se.course.entity.Course;
import com.se.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public Course saveCourse(Course course){
        return courseRepository.save(course);
    }

    public Optional<Course> getCourseById(int id){
        return  courseRepository.findById(id);
    }
}
