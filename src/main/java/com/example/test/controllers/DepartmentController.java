package com.example.test.controllers;

import com.example.test.services.DepartmentService;
import com.example.test.services.StudentService;
import com.example.test.util.department.Department;
import com.example.test.util.department.DepartmentDtO;
import com.example.test.util.student.StudentDtO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/departments")
    public List<DepartmentDtO> getDepartments() {
        return departmentService.getDepartments();
    }

    @GetMapping("/departments/{id}")
    public DepartmentDtO getDepartment(@PathVariable int id) {
        return departmentService.getDepartment(id);
    }

    @DeleteMapping("/departments/{id}")
    public void deleteDepartment(@PathVariable int id) {
        departmentService.deleteDepartment(id);
    }

    @PutMapping("/departments/{id}")
    public void putDepartment(@PathVariable int id, @RequestBody Department department) {
        departmentService.saveOrUpdateDepartment(id, department);
    }

    @PostMapping("/departments")
    public void postDepartment(@RequestBody Department department) {
        departmentService.saveOrUpdateDepartment(null, department);
    }

    @GetMapping("departments/{id}/average-grade")
    public int getAverageGrade(@PathVariable int id){
        return departmentService.getDepartmentAverageGrade(id);
    }

    @GetMapping("departments/{id}/best-student")
    public StudentDtO getBestStudent(@PathVariable int id){
        return studentService.getDepartmentBestStudent(id);
    }
}
