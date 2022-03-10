package com.example.coursesservice.web;

import com.example.coursesservice.exception.CourseDuplicationException;
import com.example.coursesservice.model.binding.CourseBindingModel;
import com.example.coursesservice.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("courses")
public class CoursesController {

    private final CourseService courseService;

    public CoursesController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/create")

    public ResponseEntity<?> create(@RequestBody CourseBindingModel courseBindingModel) throws CourseDuplicationException {

        courseService.add(courseBindingModel);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){

        this.courseService.deleteCourse(id);

        return ResponseEntity.ok().build();
    }
}
