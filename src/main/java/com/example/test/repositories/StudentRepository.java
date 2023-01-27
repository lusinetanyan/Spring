package com.example.test.repositories;

import com.example.test.util.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query(value = "SELECT s.*\n" +
            "from \"Students\" s INNER JOIN \"Courses_Students\" CS on s.\"Student_ID\" = CS.\"Student_ID\"\n" +
            "WHERE \"Department_ID\"=:departmentId\n" +
            "ORDER BY \"Grade\" desc\n" +
            "LIMIT 1",
            nativeQuery = true)
    List<Student> getDepartmentBestStudentID(@Param("departmentId") int departmentId);
}
