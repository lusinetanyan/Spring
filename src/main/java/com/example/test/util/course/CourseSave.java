package com.example.test.util.course;

public class CourseSave {
    private int id;
    private String name;
    private int instructorId;

    public CourseSave(int id, String name, int instructorId) {
        this.id = id;
        this.name = name;
        this.instructorId = instructorId;
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

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }
}
