package com.example.test.controllers;

import com.example.test.services.CourseAndStudentService;
import com.example.test.util.course_student.CourseAndStudentDtO;
import com.example.test.util.course_student.CourseAndStudentSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseStudentController {

    @Autowired
    private CourseAndStudentService courseAndStudentService;

    @GetMapping("/coursesAndStudents")
    public List<CourseAndStudentDtO> getCoursesAndStudents(@RequestParam(required = false) Integer courseId, @RequestParam(required = false) Integer studentId) {
        return courseAndStudentService.getCoursesAndStudents(courseId, studentId);
    }

    @DeleteMapping("/coursesAndStudents")
    public void deleteCourseAndStudent(@RequestParam int courseId, @RequestParam int studentId) {
        courseAndStudentService.deleteCourseAndStudent(courseId, studentId);
    }

    @PutMapping("/coursesAndStudents")
    public void putCourseAndStudent(@RequestParam int courseId, @RequestParam int studentId, @RequestBody CourseAndStudentSave courseAndStudent) {
        courseAndStudentService.putCourseAndStudent(courseId, studentId, courseAndStudent);
    }

    @PostMapping("/coursesAndStudents")
    public void postCourseAndStudent(@RequestBody CourseAndStudentSave courseAndStudent) {
        courseAndStudentService.postCourseAndStudent(courseAndStudent);
    }
}
