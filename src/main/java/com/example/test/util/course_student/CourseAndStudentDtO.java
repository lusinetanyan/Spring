package com.example.test.util.course_student;

import java.util.Map;

public class CourseAndStudentDtO {
    private Map<Integer, String> course;
    private Map<Integer, String> student;
    private int grade;

    public CourseAndStudentDtO(Map<Integer, String> course, Map<Integer, String> student, int grade) {
        this.course = course;
        this.student = student;
        this.grade = grade;
    }

    public Map<Integer, String> getCourse() {
        return course;
    }

    public void setCourse(Map<Integer, String> course) {
        this.course = course;
    }

    public Map<Integer, String> getStudent() {
        return student;
    }

    public void setStudent(Map<Integer, String> student) {
        this.student = student;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
