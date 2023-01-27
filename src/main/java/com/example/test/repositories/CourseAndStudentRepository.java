package com.example.test.repositories;

import com.example.test.util.course.Course;
import com.example.test.util.course_student.CourseAndStudent;
import com.example.test.util.course_student.CourseAndStudentId;
import com.example.test.util.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseAndStudentRepository extends JpaRepository<CourseAndStudent, CourseAndStudentId> {

    List<CourseAndStudent> deleteCourseAndStudentByCourseId(Course courseId);

}
