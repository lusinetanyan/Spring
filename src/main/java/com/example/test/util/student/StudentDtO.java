package com.example.test.util.student;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class StudentDtO {

    private int id;
    private String name;
    Map<Integer, String> courses;

    public StudentDtO(int id, String name, Map<Integer, String> courses) {
        this.id = id;
        this.name = name;
        this.courses = courses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Integer, String> getCourses() {
        return courses;
    }

    public void setCourses(Map<Integer, String> courses) {
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
