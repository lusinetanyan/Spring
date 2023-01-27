package com.example.test.util.course;

import com.example.test.util.instructor.Instructor;
import com.example.test.util.student.Student;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "`Courses`")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Course {
    @Id
    @Column(name = "`Course_ID`")
    private int id;
    @Column(name = "`Course_name`")
    private String name;
    @ManyToOne
    @JoinColumn(name = "`Instructor_ID`", referencedColumnName = "`Instructor_ID`", nullable = false)
    private Instructor instructor;
    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;


    public Course(int id, String name, Instructor instructor) {
        this.id = id;
        this.name = name;
        this.instructor = instructor;
    }

    public Course() {

    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
