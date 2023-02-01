package com.example.test.services;

import com.example.test.repositories.InstructorRepository;
import com.example.test.util.instructor.Instructor;
import com.example.test.util.instructor.InstructorDtO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InstructorServiceTest {

    @Mock
    private InstructorRepository instructorRepository;

    @InjectMocks
    private InstructorService instructorService;

    @Test
    void getInstructors() {
        Instructor instructor = new Instructor(1, "New instructor", new HashSet<>());
        Optional<Instructor> optionalInstructor = Optional.of(instructor);
        when(instructorRepository.findById(1)).thenReturn(optionalInstructor);

        InstructorDtO DtOActual = instructorService.getInstructor(1);
        InstructorDtO DtOExpected = new InstructorDtO(1, "New Instructor", new HashMap<>());

//        assertEquals(DtOActual, DtOExpected);
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