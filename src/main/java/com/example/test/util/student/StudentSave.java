package com.example.test.util.student;

import com.example.test.util.department.Department;

public class StudentSave {
    private int id;
    private String fullName;
    private int age;
    private String phone;
    private int departmentId;

    public StudentSave(int id, String fullName, int age, String phone, int departmentId) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.phone = phone;
        this.departmentId = departmentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
