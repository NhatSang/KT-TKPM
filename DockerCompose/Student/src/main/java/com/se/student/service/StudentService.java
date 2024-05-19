package com.se.student.service;

import com.se.student.dto.Course;
import com.se.student.dto.StudentDto;
import com.se.student.entity.Student;
import com.se.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RestTemplate restTemplate;

    public List<StudentDto> getAllStudent() {
        List<StudentDto> list = new ArrayList<StudentDto>();
        studentRepository.findAll().forEach((s)->{
            Course course = restTemplate.getForObject("http://course-service:8081/course/get/"+s.getCourseId(),Course.class);
            list.add(new StudentDto(s.getId(),s.getName(),s.getAge(),s.getGender(),course));
        });
        return list;
    }

    public List<Student> getAll(){
        return studentRepository.findAll();
    }
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }


}
