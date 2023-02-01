package com.example.test.services;

import com.example.test.repositories.InstructorRepository;
import com.example.test.util.instructor.Instructor;
import com.example.test.util.instructor.InstructorDtO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@TestConfiguration
class TestConfig {

    @Bean
    public InstructorService instructorService(InstructorRepository instructorRepository) {
        InstructorService instructorService = new InstructorService();
        instructorService.setInstructorRepository(instructorRepository);
        return  instructorService;
    }

    @Bean
    public InstructorRepository instructorRepository() {
        return Mockito.mock(InstructorRepository.class);
    }
}