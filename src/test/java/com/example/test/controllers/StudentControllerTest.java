package com.example.test.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@WebMvcTest(StudentController.class)
class StudentControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void getStudents() {
    }

    @Test
    void getStudent() throws Exception {
//        RequestBuilder request = MockMvcRequestBuilders.get("/students/1");
//        MvcResult result = mvc.perform(request).andReturn();
//        String s = result.getResponse().getContentAsString();
//        assertEquals("1", result.getResponse().getContentAsString());
    }

    @Test
    void deleteInstructor() {
    }

    @Test
    void putCourse() {
    }

    @Test
    void postCourse() {
    }
}