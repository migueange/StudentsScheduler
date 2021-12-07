package com.mirigos.StudentScheduler.rest;

import com.mirigos.StudentScheduler.entity.CourseEntity;
import com.mirigos.StudentScheduler.entity.StudentAttendsEntity;
import com.mirigos.StudentScheduler.entity.StudentEntity;
import com.mirigos.StudentScheduler.repository.CourseRepository;
import com.mirigos.StudentScheduler.repository.StudentAttendsRepository;
import com.mirigos.StudentScheduler.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class StudentAttendsController {

    @Autowired
    private StudentAttendsRepository studentAttendsRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/subscribe")
    public StudentAttendsEntity createStudent(@RequestBody StudentAttendsEntity studentAttends) {
        if(studentAttendsRepository.findByFkStudentIdAndFkCourseCode(studentAttends.getFkStudentId(),studentAttends.getFkCourseCode()) == null)
            return studentAttendsRepository.save(studentAttends);
        throw new IllegalArgumentException("Student already subscribed");
    }

    @GetMapping("/student/courses/{studentId}")
    public List<CourseEntity> getStudentCourses(@PathVariable UUID studentId) {
        List<UUID> courseCodesList = studentAttendsRepository.findByFkStudentId(studentId)
                .stream()
                .map(StudentAttendsEntity::getFkCourseCode)
                .collect(Collectors.toList());
        return courseRepository.findAllById(courseCodesList);
    }

    @GetMapping("/course/student/{courseCode}")
    public List<StudentEntity> getCourseStudents(@PathVariable UUID courseCode) {
        List<UUID> studentIdList = studentAttendsRepository.findByFkCourseCode(courseCode)
                .stream()
                .map(StudentAttendsEntity::getFkStudentId)
                .collect(Collectors.toList());
        return studentRepository.findAllById(studentIdList);
    }

}
