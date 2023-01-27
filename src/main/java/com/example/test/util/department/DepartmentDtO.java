package com.example.test.util.department;

import java.util.Map;

public class DepartmentDtO {
    private int id;
    private String name;
    private Map<Integer, String> students;

    public DepartmentDtO(int id, String name, Map<Integer, String> students) {
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
