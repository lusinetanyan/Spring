package com.example.test.services;

import com.example.test.repositories.InstructorRepository;
import com.example.test.util.course.Course;
import com.example.test.util.instructor.Instructor;
import com.example.test.util.instructor.InstructorDtO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;

    public List<InstructorDtO> getInstructors() {
        List<Instructor> instructors = instructorRepository.findAll();
        List<InstructorDtO> instructorDtOs = new ArrayList<>(instructors.size());
        for (Instructor instructor : instructors) {
            Map<Integer, String> courses = new HashMap<>();
            for (Course course : instructor.getCourses()) {
                courses.put(course.getId(), course.getName());
            }
            instructorDtOs.add(new InstructorDtO(instructor.getId(), instructor.getFullName(), courses));
        }
        return instructorDtOs;
    }

    public InstructorDtO getInstructor(int id) {
        Instructor instructor = instructorRepository.findById(id).orElse(null);
        if (instructor == null) return null;
        else {
            Map<Integer, String> courses = new HashMap<>();
            for (Course course : instructor.getCourses()) {
                courses.put(course.getId(), course.getName());
            }
            return new InstructorDtO(instructor.getId(), instructor.getFullName(), courses);
        }
    }

    public void deleteInstructor(int id) {
        instructorRepository.deleteById(id);
    }

    public void saveOrUpdateInstructor(Integer id, Instructor instructor) {
        if (id == null)
            instructorRepository.save(instructor);
        else {
            if (id != instructor.getId())
                throw new IllegalArgumentException("Instructor's ID does not match with the ID given in the URL");
            else instructorRepository.save(instructor);
        }
    }
}
