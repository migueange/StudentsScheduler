package com.mirigos.StudentScheduler.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

/**
 * Entity for course
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "COURSE")
public class CourseEntity {

    @Id
    @GeneratedValue
    @Column(name = "COURSE_CODE",nullable = false)
    private UUID courseCode;

    @Column(name = "COURSE_TITLE")
    private String courseTitle;

    @Column(name = "COURSE_DESCRIPTION")
    private String courseDescription;

}
