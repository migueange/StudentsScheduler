package com.mirigos.StudentScheduler.repository;

import com.mirigos.StudentScheduler.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<StudentEntity, UUID> {

    List<StudentEntity> findByStudentFirstNameOrStudentLastName(String studentFirstName, String studentLastName);

}
