package com.example.test.controllers;

import com.example.test.services.CourseService;
import com.example.test.util.course.CourseDtO;
import com.example.test.util.course.CourseSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public List<CourseDtO> getCourses() {
        return courseService.getCourses();
    }

    @GetMapping("/courses/{id}")
    public CourseDtO getCourse(@PathVariable int id) {
        return courseService.getCourse(id);
    }

    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
    }

    @PutMapping("/courses/{id}")
    public void putCourse(@PathVariable int id, @RequestBody CourseSave course) {
        courseService.saveOrUpdateCourse(id, course);
    }

    @PostMapping("/courses")
    public void postCourse(@RequestBody CourseSave course) {
        courseService.saveOrUpdateCourse(null, course);
    }
}
