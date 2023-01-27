package com.example.test.services;

import com.example.test.repositories.DepartmentRepository;
import com.example.test.repositories.StudentRepository;
import com.example.test.util.department.Department;
import com.example.test.util.department.DepartmentDtO;
import com.example.test.util.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    public List<DepartmentDtO> getDepartments() {
        List<Department> departments = departmentRepository.findAll();
        List<DepartmentDtO> departmentDtOS = new ArrayList<>(departments.size());
        for (Department department : departments) {
            Map<Integer, String> students = new HashMap<>();
            for (Student student : department.getStudents()) {
                students.put(student.getId(), student.getFullName());
            }
            departmentDtOS.add(new DepartmentDtO(department.getId(), department.getName(), students));
        }
        return departmentDtOS;
    }

    public DepartmentDtO getDepartment(int id) {
        Department department = departmentRepository.findById(id).orElse(null);
        if (department == null) return null;
        else {
            Map<Integer, String> students = new HashMap<>();
            for (Student student : department.getStudents()) {
                students.put(student.getId(), student.getFullName());
            }
            return new DepartmentDtO(department.getId(), department.getName(), students);
        }
    }

    public void deleteDepartment(int id) {
        departmentRepository.deleteById(id);
    }

    public void saveOrUpdateDepartment(Integer id, Department department) {
        if (id == null)
            departmentRepository.save(department);
        else {
            if (id != department.getId())
                throw new IllegalArgumentException("Department's ID does not match with the ID given in the URL");
            else departmentRepository.save(department);
        }
    }

    public int getDepartmentAverageGrade(int departmentId) {
        departmentRepository.findById(departmentId).orElseThrow(() -> new IllegalArgumentException("Invalid department ID"));
        return departmentRepository.getDepartmentAverageGrade(departmentId);
    }


}
