package com.example.test.services;

import com.example.test.repositories.CourseAndStudentRepository;
import com.example.test.repositories.CourseRepository;
import com.example.test.repositories.InstructorRepository;
import com.example.test.util.course.Course;
import com.example.test.util.course.CourseDtO;
import com.example.test.util.course.CourseSave;
import com.example.test.util.instructor.Instructor;
import com.example.test.util.student.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private InstructorRepository instructorRepository;
    @Autowired
    private CourseAndStudentRepository courseAndStudentRepository;

    public List<CourseDtO> getCourses() {
        List<Course> courses = courseRepository.findAll();
        List<CourseDtO> courseDtOS = new ArrayList<>(courses.size());
        for (Course course : courses) {
            Map<Integer, String> students = new HashMap<>();
            for (Student student : course.getStudents()) {
                students.put(student.getId(), student.getFullName());
            }
            courseDtOS.add(new CourseDtO(course.getId(), course.getName(), students));
        }
        return courseDtOS;
    }

    public CourseDtO getCourse(int id) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course == null) return null;
        else {
            Map<Integer, String> students = new HashMap<>();
            for (Student student : course.getStudents()) {
                students.put(student.getId(), student.getFullName());
            }
            return new CourseDtO(course.getId(), course.getName(), students);
        }
    }
    @Transactional
    public void deleteCourse(int id) {
        courseAndStudentRepository.deleteCourseAndStudentByCourseId(courseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID is invalid")));
        courseRepository.deleteById(id);
    }

    public void saveOrUpdateCourse(Integer id, CourseSave course) {
        Instructor instructor = instructorRepository.findById(course.getInstructorId()).orElse(null);
        if (instructor == null) throw new IllegalArgumentException("Instructor's ID is invalid");
        if (id == null || id == course.getId()) {
            Course myCourse = new Course(course.getId(), course.getName(), instructor);
            courseRepository.save(myCourse);
        } else throw new IllegalArgumentException("Course's ID does not match with the ID given in the URL");
    }
}


