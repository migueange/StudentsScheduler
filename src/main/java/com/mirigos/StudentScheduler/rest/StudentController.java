package com.mirigos.StudentScheduler.rest;

import com.mirigos.StudentScheduler.entity.StudentEntity;
import com.mirigos.StudentScheduler.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/student")
    public StudentEntity createStudent(@RequestBody StudentEntity student) {
        return studentRepository.save(student);
    }

    @GetMapping("/student/{studentId}")
    public StudentEntity getStudent(@PathVariable UUID studentId) {
        return studentRepository.findById(studentId).get();
    }

    @DeleteMapping("/student/{studentId}")
    public void deleteEmployee(@PathVariable UUID studentId) {
        studentRepository.deleteById(studentId);
    }

    @GetMapping("/student")
    List<StudentEntity> listStudents() {
        return studentRepository.findAll();
    }

    @PatchMapping("/student")
    public StudentEntity updateStudent(@RequestBody StudentEntity student) {
        return studentRepository.findById(student.getStudentId())
                .map(updatedStudent -> {
                    updatedStudent.setStudentFirstName(student.getStudentFirstName());
                    updatedStudent.setStudentLastName(student.getStudentLastName());
                    return studentRepository.save(updatedStudent);
                }).get();
    }

    @GetMapping("/student/find/{filter}")
    List<StudentEntity> find(@PathVariable String filter) {
        return studentRepository.findByStudentFirstNameOrStudentLastName(filter,filter);
    }

}
