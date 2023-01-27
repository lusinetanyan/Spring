package com.example.test.util.student;

import com.example.test.util.course.Course;
import com.example.test.util.department.Department;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "`Students`")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Student {
    @Id
    @Column(name = "`Student_ID`")
    private int id;
    @Column(name = "`Student_fullName`")
    private String fullName;
    @Column(name = "`Student_Age`")
    private int age;
    @Column(name = "`Student_Phone`")
    private String phone;
    @ManyToOne()
    @JoinColumn(name = "`Department_ID`", referencedColumnName = "`Department_ID`")
    private Department department;
    @ManyToMany
    @JoinTable(
            name = "`Courses_Students`",
            joinColumns = @JoinColumn(name = "`Student_ID`"),
            inverseJoinColumns = @JoinColumn(name = "`Course_ID`"))
    private Set<Course> courses;

    public Student() {
    }

    public Student(int id, String fullName, int age, String phone, Department department) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.phone = phone;
        this.department = department;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
