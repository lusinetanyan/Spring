package com.example.test.util.department;

import com.example.test.util.student.Student;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "`Departments`")
public class Department {
    @Id
    @Column(name = "`Department_ID`")
    private int id;
    @Column(name = "`Department_name`")
    private String name;
    @OneToMany(mappedBy = "department", cascade = CascadeType.REMOVE)
    private Set<Student> students;

    public Department(int id, String name, Set<Student> students) {
        this.id = id;
        this.name = name;
        this.students = students;
    }

    public Department() {

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

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
