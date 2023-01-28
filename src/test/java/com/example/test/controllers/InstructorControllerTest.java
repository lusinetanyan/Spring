package com.example.test.controllers;

import com.example.test.services.InstructorService;
import com.example.test.util.instructor.InstructorDtO;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.BDDMockito.given;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(InstructorController.class)
class InstructorControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private InstructorService service;

    @Test
    void getInstructor() throws Exception {
        Map<Integer, String> courses = new HashMap<>();
        courses.put(1, "Calculus 1");
        courses.put(5, "Calculus 2");
        InstructorDtO instructor = new InstructorDtO(1, "Karen Keryan", courses);
        given(service.getInstructor(1)).willReturn(instructor);

        mvc.perform(get("http://localhost:8080/instructors/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(instructor.getId()))
                .andExpect(jsonPath("$.fullName").value(instructor.getFullName()))
                .andExpect(jsonPath("$.courses['1']").value("Calculus 1"))
                .andExpect(jsonPath("$.courses['5']").value("Calculus 2"));
    }
}