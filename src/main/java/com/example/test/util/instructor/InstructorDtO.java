package com.example.test.util.instructor;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class InstructorDtO {
    private int id;
    private String fullName;
    private Map<Integer, String> courses;

    public InstructorDtO(int id, String fullName, Map<Integer, String> courses) {
        this.id = id;
        this.fullName = fullName;
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

    public Map<Integer, String> getCourses() {
        return courses;
    }

    public void setCourses(Map<Integer, String> courses) {
        this.courses = courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstructorDtO that = (InstructorDtO) o;
        return id == that.id && Objects.equals(fullName, that.fullName) && Objects.equals(courses, that.courses);
    }
}
