package com.ileiwe.service.courseService;

import com.ileiwe.data.model.Course;
import com.ileiwe.data.model.Instructor;
import com.ileiwe.data.repository.InstructorRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Slf4j
class InstructorServiceImplTest {
    @Autowired
    InstructorService2Impl instructorServiceImpl;
    @Autowired
    CourseServiceImpl courseServiceImpl;
    @Autowired
    InstructorRepository instructorRepository;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    @Transactional
    @Rollback(value = false)
    void createCurse() {
       Optional<Instructor> instructor = instructorRepository.findById(2L);

           Course course = new Course();
           course.setTitle("CSS");
           course.setDescription("Demystifying programming using CSS");
           course.setDuration("2 hours");
           course.setLanguage("French");
           log.info("Course before saving {}", course);
           course.setInstructor(instructor.get());
           courseServiceImpl.create(course);
           log.info("course after saving {}", course);

    }
}