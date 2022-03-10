package com.example.coursesservice.web;

import com.example.coursesservice.exception.CourseDuplicationException;
import com.example.coursesservice.model.binding.CourseBindingModel;
import com.example.coursesservice.model.entity.CourseEntity;
import com.example.coursesservice.model.entity.LectureEntity;
import com.example.coursesservice.model.view.CourseDetailsView;
import com.example.coursesservice.model.view.CourseStreamDetailsView;
import com.example.coursesservice.model.view.LecturesDetailsView;
import com.example.coursesservice.service.CourseService;
import com.example.coursesservice.service.LectureService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("courses")
public class CoursesController {

    private final CourseService courseService;
    private final LectureService lectureService;
    private final ModelMapper modelMapper;

    public CoursesController(CourseService courseService, LectureService lectureService, ModelMapper modelMapper) {
        this.courseService = courseService;
        this.lectureService = lectureService;
        this.modelMapper = modelMapper;
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

    @GetMapping("/details/{id}")
    public CourseDetailsView coursesDetailsList(@PathVariable String id){

        CourseEntity currentCourse = this.courseService
                .getCourseEntityById(id);

        CourseDetailsView courseDetailsView = this.modelMapper
                .map(currentCourse, CourseDetailsView.class);

        courseDetailsView.setLecturesCount(currentCourse.
                getLectures().size());

        return courseDetailsView;
    }

    @GetMapping("/lectures/{id}")
    public CourseStreamDetailsView getCourseLecturesList(@PathVariable String id){

        CourseEntity currentCourse = this.courseService
                .getCourseEntityById(id);

        List<LecturesDetailsView> lectures = currentCourse.
                getLectures().stream()
                .map(l -> {

                    return this.modelMapper.map(l, LecturesDetailsView.class);

                }).collect(Collectors.toList());

        return new CourseStreamDetailsView()
        .setLectures(lectures)
        .setLectorDescription(currentCourse.getLectorDescription());
    }

    @GetMapping("/languages")
    public List<LanguageServiceDto> getAllLanguages() {
        return this.languageService.getAllLanguages();
    }

    @GetMapping("/categories")
    public List<CategoryServiceDto> getAllCategories() {
        return this.categoryService.getAllCategories();
    }
}
