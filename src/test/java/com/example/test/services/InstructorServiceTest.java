package com.example.test.services;

import com.example.test.repositories.InstructorRepository;
import com.example.test.util.instructor.Instructor;
import com.example.test.util.instructor.InstructorDtO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
class InstructorServiceTest {

    @MockBean
    private InstructorRepository instructorRepository;

    @InjectMocks
    private InstructorService instructorService;

    @Test
    void getInstructors() {
        Instructor instructor = new Instructor(1, "New instructor", new HashSet<>());
        Optional<Instructor> optionalInstructor = Optional.of(instructor);
        given(instructorRepository.findById(1)).willReturn(optionalInstructor);

        InstructorDtO DtOActual = instructorService.getInstructor(1);
        InstructorDtO DtOExpected = new InstructorDtO(1, "New Instructor", new HashMap<>());

        assertEquals(DtOActual, DtOExpected);
        assertEquals(DtOActual.getId(), instructor.getId());
        assertEquals(DtOActual.getFullName(), instructor.getFullName());
    }

    @Test
    void getInstructor() {
    }

    @Test
    void deleteInstructor() {
    }

    @Test
    void saveOrUpdateInstructor() {
    }
}