package com.example.test.util.course;

import java.util.Map;

public class CourseDtO {
    private int id;
    private String name;
    Map<Integer, String> students;

    public CourseDtO(int id, String name, Map<Integer, String> students) {
        this.id = id;
        this.name = name;
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

    public Map<Integer, String> getStudents() {
        return students;
    }

    public void setStudents(Map<Integer, String> students) {
        this.students = students;
    }
}
