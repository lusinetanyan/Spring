package com.example.test.controllers;

import com.example.test.services.InstructorService;
import com.example.test.util.instructor.Instructor;
import com.example.test.util.instructor.InstructorDtO;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Before;
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
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
@WebMvcTest(InstructorController.class)
class InstructorControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private InstructorService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Before
    public void beforeTest() {
        this.mvc = standaloneSetup(new InstructorController()).setControllerAdvice(new ControllerExceptionHandling()).build();
    }

    @Test
    void getInstructor() throws Exception {
        Map<Integer, String> courses = new HashMap<>();
        courses.put(3, "Data Structures");
        InstructorDtO instructor = new InstructorDtO(1, "Varduhi Yeghiazaryan", courses);
        given(service.getInstructor(1)).willReturn(instructor);

        mvc.perform(get("http://localhost:8080/instructors/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(instructor.getId()))
                .andExpect(jsonPath("$.fullName").value(instructor.getFullName()))
                .andExpect(jsonPath("$.courses['3']").value("Data Structures"));
    }

    @Test
    void putInstructorException() throws Exception {
        Instructor instructor = new Instructor(1, "New Instructor", null);
        doThrow(new IllegalArgumentException("Instructor's ID does not match with the ID given in the URL")).when(service).saveOrUpdateInstructor(2, instructor);

        mvc.perform(put("http://localhost:8080/instructors/2")
                        .content(objectMapper.writeValueAsString(instructor))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(404))
                .andExpect(content().string("Instructor's ID does not match with the ID given in the URL"));
    }

    @Test
    void putInstructor() throws Exception {
        Instructor instructor = new Instructor(2, "New Instructor", null);
        doNothing().when(service).saveOrUpdateInstructor(2, instructor);

        mvc.perform(put("http://localhost:8080/instructors/2")
                        .content(objectMapper.writeValueAsString(instructor))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200));
    }
}