package com.example.test.repositories;

import com.example.test.util.department.Department;
import com.example.test.util.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    @Query(value = "SELECT sum(\"Grade\")/count(CS.\"Student_ID\") AS \"Average Grade\"\n" +
            "from \"Students\" INNER JOIN \"Courses_Students\" CS on \"Students\".\"Student_ID\" = CS.\"Student_ID\"\n" +
            "WHERE \"Department_ID\"=:departmentId\n" +
            "group by \"Department_ID\"",
    nativeQuery = true)
    int getDepartmentAverageGrade(@Param("departmentId") int departmentId);


}
