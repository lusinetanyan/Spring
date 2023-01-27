package com.example.test.util.course_student;

import com.example.test.util.course.Course;
import com.example.test.util.student.Student;
import jakarta.persistence.*;

@Entity
@Table(name = "`Courses_Students`")
@IdClass(CourseAndStudentId.class)
public class CourseAndStudent {

    @Id
    @ManyToOne
    @JoinColumn(name = "`Course_ID`", referencedColumnName = "`Course_ID`")
    private Course courseId;
    @Id
    @ManyToOne
    @JoinColumn(name = "`Student_ID`", referencedColumnName = "`Student_ID`")
    private Student studentId;
    @Column(name = "`Grade`")
    private int grade;

    public CourseAndStudent() {
    }

    public CourseAndStudent(Course courseId, Student studentId, int grade) {
        this.courseId = courseId;
        this.studentId = studentId;
        this.grade = grade;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
