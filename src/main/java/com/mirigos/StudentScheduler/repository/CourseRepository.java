package com.mirigos.StudentScheduler.repository;

import com.mirigos.StudentScheduler.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {

    List<CourseEntity> findByCourseTitleOrCourseDescription(String courseTitle, String courseDescription);

}
