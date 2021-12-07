package com.mirigos.StudentScheduler.rest;

import com.mirigos.StudentScheduler.entity.CourseEntity;
import com.mirigos.StudentScheduler.entity.StudentEntity;
import com.mirigos.StudentScheduler.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping("/course")
    public CourseEntity createCourse(@RequestBody CourseEntity course) {
        return courseRepository.save(course);
    }

    @GetMapping("/course/{courseCode}")
    public CourseEntity getCourse(@PathVariable UUID courseCode) {
        return courseRepository.findById(courseCode).get();
    }

    @DeleteMapping("/course/{courseCode}")
    public void deleteCourse(@PathVariable UUID courseCode) {
        courseRepository.deleteById(courseCode);
    }

        @GetMapping("/course")
    List<CourseEntity> listCourses() {
        return courseRepository.findAll();
    }

    @PatchMapping("/course")
    public CourseEntity updateCourse(@RequestBody CourseEntity course) {
        return courseRepository.findById(course.getCourseCode())
                .map(updatedCourse -> {
                    updatedCourse.setCourseTitle(course.getCourseTitle());
                    updatedCourse.setCourseDescription(course.getCourseDescription());
                    return courseRepository.save(updatedCourse);
                }).get();
    }

    @GetMapping("/course/find/{filter}")
    List<CourseEntity> find(@PathVariable String filter) {
        return courseRepository.findByCourseTitleOrCourseDescription(filter,filter);
    }

}
