package com.example.test.services;

import com.example.test.repositories.InstructorRepository;
import com.example.test.util.instructor.Instructor;
import com.example.test.util.instructor.InstructorDtO;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InstructorServiceTest {

    @Mock
    private InstructorRepository instructorRepository;

    @InjectMocks
    private InstructorService instructorService;

    @Test
    void getInstructor() {
        Instructor instructor = new Instructor(1, "New Instructor", new HashSet<>());
        Optional<Instructor> optionalInstructor = Optional.of(instructor);
        when(instructorRepository.findById(1)).thenReturn(optionalInstructor);

        InstructorDtO DtOActual = instructorService.getInstructor(1);
        InstructorDtO DtOExpected = new InstructorDtO(1, "New Instructor", new HashMap<>());

        assertEquals(DtOActual, DtOExpected);
        assertEquals(DtOActual.getId(), instructor.getId());
        assertEquals(DtOActual.getFullName(), instructor.getFullName());
    }

    @Test
    void deleteInstructor() {
        ArgumentCaptor<Integer> captorParam = ArgumentCaptor.forClass(Integer.class);
        doNothing().when(instructorRepository).deleteById(captorParam.capture());

        instructorService.deleteInstructor(1);

        assertEquals(1, captorParam.getValue());
        verify(instructorRepository, times(1))
                .deleteById(anyInt());
    }

    @Test
    void saveOrUpdateInstructorWithNullID() {
        ArgumentCaptor<Instructor> captorParam = ArgumentCaptor.forClass(Instructor.class);
        Instructor instructor = new Instructor(1, "New Instructor", new HashSet<>());

        when(instructorRepository.save(captorParam.capture())).thenReturn(any(Instructor.class));

        assertDoesNotThrow(() -> instructorService.saveOrUpdateInstructor(null, instructor));
        assertEquals(instructor, captorParam.getValue());
        verify(instructorRepository, times(1))
                .save(any(Instructor.class));
    }

    @Test
    void saveOrUpdateInstructorWithInvalidID() {
        Instructor instructor = new Instructor(1, "New Instructor", new HashSet<>());

        assertThrows(IllegalArgumentException.class, () -> instructorService.saveOrUpdateInstructor(2, instructor));
        verify(instructorRepository, times(0))
                .save(any(Instructor.class));
    }

    @Test
    void saveOrUpdateInstructorWithValidID() {
        ArgumentCaptor<Instructor> captorParam = ArgumentCaptor.forClass(Instructor.class);
        Instructor instructor = new Instructor(1, "New Instructor", new HashSet<>());

        when(instructorRepository.save(captorParam.capture())).thenReturn(any(Instructor.class));

        assertDoesNotThrow(() -> instructorService.saveOrUpdateInstructor(1, instructor));
        assertEquals(instructor, captorParam.getValue());
        verify(instructorRepository, times(1))
                .save(any(Instructor.class));
    }
}