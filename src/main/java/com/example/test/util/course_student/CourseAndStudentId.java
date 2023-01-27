package com.example.test.util.course_student;

import java.io.Serializable;
import java.util.Objects;

public class CourseAndStudentId implements Serializable {
    private int courseId;
    private int studentId;

    public CourseAndStudentId() {
    }

    public CourseAndStudentId(int courseId, int studentId) {
        this.courseId = courseId;
        this.studentId = studentId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseAndStudentId that = (CourseAndStudentId) o;
        return courseId == that.courseId && studentId == that.studentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, studentId);
    }
}
