package com.example.test.controllers;

import com.example.test.services.StudentService;
import com.example.test.util.student.StudentDtO;
import com.example.test.util.student.StudentSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<StudentDtO> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/students/{id}")
    public StudentDtO getStudent(@PathVariable int id) {
        return studentService.getStudent(id);
    }

    @DeleteMapping("/students/{id}")
    public void deleteInstructor(@PathVariable int id) {
        studentService.deleteStudent(id);
    }

    @PutMapping("/students/{id}")
    public void putCourse(@PathVariable int id, @RequestBody StudentSave student) {
        studentService.saveOrUpdateStudent(id, student);
    }

    @PostMapping("/students")
    public void postCourse(@RequestBody StudentSave student) {
        studentService.saveOrUpdateStudent(null, student);
    }

}
