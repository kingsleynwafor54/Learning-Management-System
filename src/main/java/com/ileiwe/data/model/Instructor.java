package com.ileiwe.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author oluwatobi
 * @version 1.0
 * @date on 27/10/2021
 * inside the package - com.ileiwe.data.model
 */

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Instructor extends RepresentationModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull     @NotBlank
    @Column(nullable = false)
    private String firstname;
    @NotNull     @NotBlank
    @Column(nullable = false)
    private String lastname;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String specialization;
    @Column(length = 1000)
    private String bio;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.PERSIST)
    private LearningParty learningParty;
    @OneToMany(cascade=CascadeType.PERSIST)
    private List<Course> courses;

//    public void addCourse(Course course){
//        if(courses==null){
//            courses=new ArrayList<>();
//        }
//        courses.add(course);
//    }

}
