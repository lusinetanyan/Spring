package com.example.test.controllers;

import com.example.test.services.InstructorService;
import com.example.test.util.instructor.Instructor;
import com.example.test.util.instructor.InstructorDtO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InstructorController {
    @Autowired
    private InstructorService instructorService;

    @GetMapping("/instructors")
    public List<InstructorDtO> getInstructors() {
        return instructorService.getInstructors();
    }

    @GetMapping("/instructors/{id}")
    public InstructorDtO getInstructor(@PathVariable int id) {
        return instructorService.getInstructor(id);
    }

    @DeleteMapping("/instructors/{id}")
    public void deleteInstructor(@PathVariable int id) {
        instructorService.deleteInstructor(id);
    }

    @PutMapping("/instructors/{id}")
    public void putInstructor(@PathVariable int id, @RequestBody Instructor instructor) {
        instructorService.saveOrUpdateInstructor(id, instructor);
    }

    @PostMapping("/instructors")
    public void postInstructor(@RequestBody Instructor instructor) {
        instructorService.saveOrUpdateInstructor(null, instructor);
    }
}
