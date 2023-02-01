package com.example.test.util.instructor;

import com.example.test.util.course.Course;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "`Instructors`")
public class Instructor {
    @Id
    @Column(name = "`Instructor_ID`")
    private int id;
    @Column(name = "`Instructor_fullName`")
    private String fullName;
    @OneToMany(mappedBy = "instructor", cascade = CascadeType.REMOVE)
    private Set<Course> courses;

    public Instructor(int id, String fullName, Set<Course> courses) {
        this.id = id;
        this.fullName = fullName;
        this.courses = courses;
    }
    public Instructor() {

    }
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instructor that = (Instructor) o;
        return id == that.id && fullName.equals(that.fullName);
    }
}
