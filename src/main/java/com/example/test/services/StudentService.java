package com.example.test.services;

import com.example.test.repositories.CourseAndStudentRepository;
import com.example.test.repositories.DepartmentRepository;
import com.example.test.repositories.StudentRepository;
import com.example.test.util.course.Course;
import com.example.test.util.department.Department;
import com.example.test.util.student.Student;
import com.example.test.util.student.StudentDtO;
import com.example.test.util.student.StudentSave;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<StudentDtO> getStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDtO> studentDtOS = new ArrayList<>(students.size());
        for (Student student : students) {
            Map<Integer, String> courses = new HashMap<>();
            for (Course course : student.getCourses()) {
                courses.put(course.getId(), course.getName());
            }
            studentDtOS.add(new StudentDtO(student.getId(), student.getFullName(), courses));
        }
        return studentDtOS;
    }

    public StudentDtO getStudent(int id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) return null;
        else {
            Map<Integer, String> courses = new HashMap<>();
            for (Course course : student.getCourses()) {
                courses.put(course.getId(), course.getName());
            }
            return new StudentDtO(student.getId(), student.getFullName(), courses);
        }
    }

    @Transactional
    public void deleteStudent(int id) {
        studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID is invalid"));
        studentRepository.deleteById(id);
    }

    public void saveOrUpdateStudent(Integer id, StudentSave student) {
        Department department = departmentRepository.findById(student.getDepartmentId()).orElse(null);
        if (department == null) throw new IllegalArgumentException("Department's ID is invalid");
        if (id == null || id == student.getId()) {
            Student newStudent = new Student(student.getId(), student.getFullName(), student.getAge(), student.getPhone(), department);
            studentRepository.save(newStudent);
        } else throw new IllegalArgumentException("Student's ID does not match with the ID given in the URL");
    }

    public StudentDtO getDepartmentBestStudent(int departmentId) {
        departmentRepository.findById(departmentId).orElseThrow(() -> new IllegalArgumentException("Invalid department ID"));
        Student student = studentRepository.getDepartmentBestStudentID(departmentId).get(0);
        Map<Integer, String> courses = new HashMap<>();
        for (Course course : student.getCourses()) {
            courses.put(course.getId(), course.getName());
        }
        return new StudentDtO(student.getId(), student.getFullName(), courses);
    }
}
