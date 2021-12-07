package com.mirigos.StudentScheduler.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;


/**
 * Entity for student
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "STUDENT")
public class StudentEntity {

    @Id
    @GeneratedValue
    @Column(name = "STUDENT_ID",nullable = false)
    private UUID studentId;

    @Column(name = "STUDENT_FIRST_NAME")
    private String studentFirstName;

    @Column(name = "STUDENT_LAST_NAME")
    private String studentLastName;

}
