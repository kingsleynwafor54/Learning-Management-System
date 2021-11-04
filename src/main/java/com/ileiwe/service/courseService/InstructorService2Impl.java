package com.ileiwe.service.courseService;

import com.ileiwe.data.model.Course;
import com.ileiwe.data.model.Instructor;
import com.ileiwe.data.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InstructorService2Impl implements InstructorService{
    @Autowired
    InstructorRepository instructorRepository;
    @Autowired
    CourseServiceImpl courseServiceImpl;
    @Override
    public Long CreateCurse(Long id, Course course) {
        Optional<Instructor> instructor = instructorRepository.findById(1L);
        if(instructor.isPresent()){
            courseServiceImpl.create(course);
            return id;
        }
        throw new NullPointerException("Instructor with id "+id +" does not exist");
    }
}
