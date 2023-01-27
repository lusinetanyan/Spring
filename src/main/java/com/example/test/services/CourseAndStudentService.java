package com.example.test.services;

import com.example.test.repositories.CourseAndStudentRepository;
import com.example.test.repositories.CourseRepository;
import com.example.test.repositories.StudentRepository;
import com.example.test.util.course.Course;
import com.example.test.util.course_student.CourseAndStudent;
import com.example.test.util.course_student.CourseAndStudentDtO;
import com.example.test.util.course_student.CourseAndStudentId;
import com.example.test.util.course_student.CourseAndStudentSave;
import com.example.test.util.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourseAndStudentService {

    @Autowired
    private CourseAndStudentRepository courseAndStudentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;

    public void postCourseAndStudent(CourseAndStudentSave courseAndStudent) {
        saveCourseAndStudent(courseAndStudent);
    }

    public List<CourseAndStudentDtO> getCoursesAndStudents(Integer courseId, Integer studentId) {
        List<CourseAndStudent> courseAndStudentList = courseAndStudentRepository.findAll();
        List<CourseAndStudentDtO> courseAndStudentDtOList = new ArrayList<>(courseAndStudentList.size());
        for (CourseAndStudent courseAndStudent : courseAndStudentList) {
            Course course = courseAndStudent.getCourseId();
            if (courseId != null && course.getId() != courseId) continue;
            Student student = courseAndStudent.getStudentId();
            if (studentId != null && student.getId() != studentId) continue;
            Map<Integer, String> courseMap = new HashMap<>();
            Map<Integer, String> studentMap = new HashMap<>();
            courseMap.put(course.getId(), course.getName());
            studentMap.put(student.getId(), student.getFullName());
            courseAndStudentDtOList.add(new CourseAndStudentDtO(courseMap, studentMap, courseAndStudent.getGrade()));
        }
        return courseAndStudentDtOList;
    }

    public void putCourseAndStudent(int courseId, int studentId, CourseAndStudentSave courseAndStudent) {
        CourseAndStudent courseAndStudentOriginal = courseAndStudentRepository.findById(new CourseAndStudentId(courseId, studentId)).orElse(null);
        if (courseAndStudentOriginal == null) throw new IllegalArgumentException("Wrong IDs specified");
        else {
            saveCourseAndStudent(courseAndStudent);
            courseAndStudentRepository.delete(courseAndStudentOriginal);
        }
    }

    public void deleteCourseAndStudent(int courseId, int studentId) {
        courseAndStudentRepository.deleteById(new CourseAndStudentId(courseId, studentId));
    }

    private void saveCourseAndStudent(CourseAndStudentSave courseAndStudent) {
        Course course = courseRepository.findById(courseAndStudent.getCourseId()).orElse(null);
        Student student = studentRepository.findById(courseAndStudent.getStudentId()).orElse(null);
        if (course == null || student == null) throw new IllegalArgumentException("Wrong IDs specified");
        else courseAndStudentRepository.save(new CourseAndStudent(course, student, courseAndStudent.getGrade()));
    }

}
