package com.example.coursesservice.web;

import com.example.coursesservice.exception.CourseDuplicationException;
import com.example.coursesservice.model.binding.CourseBindingModel;
import com.example.coursesservice.model.entity.LectureEntity;
import com.example.coursesservice.service.CourseService;
import com.example.coursesservice.service.LectureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("courses")
public class CoursesController {

    private final CourseService courseService;
    private final LectureService lectureService;

    public CoursesController(CourseService courseService, LectureService lectureService) {
        this.courseService = courseService;
        this.lectureService = lectureService;
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

    @GetMapping("/languages")
        public List<LectureEntity> getAllLanguages(){
        return null;
        }
}
