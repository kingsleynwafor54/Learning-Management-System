package com.ileiwe.service.courseService;

import com.ileiwe.data.dto.CourseDto;
import com.ileiwe.data.model.Course;
import com.ileiwe.data.model.Instructor;
import com.ileiwe.data.repository.CourseRepository;
import com.ileiwe.data.repository.InstructorRepository;
import com.ileiwe.web.CourseAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    CourseRepository courseRepository;

    @Override
    @Transactional
    public Course create(Course course) {
        Course courseInRepo = courseRepository.findCourseByTitle(course.getTitle());
     if(courseInRepo != null){
          throw new CourseAlreadyExistException("Course with tile "+course.getTitle() +" already exists");
      }
        Course createdCourse =courseRepository.save(course);
        return createdCourse;

    }

    private Course getCourse(CourseDto courseDto, Instructor instructor, Course course) {
        course.setTitle(courseDto.getTitle());
        course.setDescription(courseDto.getDescription());
        course.setDuration(courseDto.getDuration());
        course.setLanguage(courseDto.getLanguage());
        course.setImageUrls(courseDto.getImgUrl());
        course.setInstructor(instructor);

        return courseRepository.save(course);
    }

    @Override
    public Course update(CourseDto courseDto,Long id,Long num) {
        Course course = courseRepository.findById(id).orElse(null);
        if (instructorRepository.findById(id).isPresent()) {
            Instructor instructor = instructorRepository.findById(id).get();

            int num1 = Math.toIntExact(num);

            if (course != null) {
                return getCourse(courseDto, instructor, course);

            } else {
                throw new NullPointerException("Instructor with id " + id + " not found");
            }

        }
        return courseRepository.save(course);
    }
    @Override
    public void update(String title) {

    }

    @Override
    public void delete(Long id) {
        Optional<Course> course=courseRepository.findById(id);
        course.ifPresent(value -> courseRepository.delete(value));
        throw new NullPointerException("Course with id "+id +" not found");

    }

    @Override
    public Course viewCourse(Long id) {

        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public void publishCourse(Long id) {

    }

    @Override
    public Course findCourseByTitle(String title) {
        List<Course> courses = courseRepository.findAll();
        for(Course course : courses){
            if(course.getTitle().equals(title)){
                return course;
            }
        }
        return null;
    }
}
