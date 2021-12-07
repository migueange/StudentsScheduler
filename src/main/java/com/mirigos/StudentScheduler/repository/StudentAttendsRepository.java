package com.mirigos.StudentScheduler.repository;

import com.mirigos.StudentScheduler.entity.StudentAttendsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface StudentAttendsRepository extends JpaRepository<StudentAttendsEntity, UUID> {

    List<StudentAttendsEntity> findByFkStudentId(UUID fkStudentId);

    StudentAttendsEntity findByFkStudentIdAndFkCourseCode(UUID fkStudentId, UUID fkCourseCode);

    List<StudentAttendsEntity> findByFkCourseCode(UUID fkCourseCode);

}
