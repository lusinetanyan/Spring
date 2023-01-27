package com.example.test.util.instructor;

import java.util.Map;
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
}
