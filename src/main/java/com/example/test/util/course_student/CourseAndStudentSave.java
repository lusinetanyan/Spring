package com.example.test.util.course_student;

public class CourseAndStudentSave {
    private int courseId;
    private int studentId;
    private int grade;

    public CourseAndStudentSave(int courseId, int studentId, int grade) {
        this.courseId = courseId;
        this.studentId = studentId;
        this.grade = grade;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
