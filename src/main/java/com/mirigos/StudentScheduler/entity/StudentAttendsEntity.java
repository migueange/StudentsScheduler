package com.mirigos.StudentScheduler.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

/**
 * Entity for subscribing students to course
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "STUDENT_ATTENDS")
public class StudentAttendsEntity {

    @Id
    @GeneratedValue
    @Column(name = "STUDENT_ATTENDS_ID",nullable = false)
    private UUID studenAttendsId;

    @Column(name = "FK_STUDENT_ID")
    private UUID fkStudentId;

    @Column(name = "FK_COURSE_CODE")
    private UUID fkCourseCode;

}
