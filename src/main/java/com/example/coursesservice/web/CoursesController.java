package com.example.coursesservice.web;

import com.example.coursesservice.exception.CourseDuplicationException;
import com.example.coursesservice.model.binding.CourseBindingModel;
import com.example.coursesservice.model.service.CategoryServiceDto;
import com.example.coursesservice.model.service.LanguageServiceDto;
import com.example.coursesservice.service.CategoryService;
import com.example.coursesservice.service.CourseService;
import com.example.coursesservice.service.LanguageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("courses")
public class CoursesController {

    private final CourseService courseService;
    private final LanguageService languageService;
    private final CategoryService categoryService;

    public CoursesController(CourseService courseService, LanguageService languageService, CategoryService categoryService) {
        this.courseService = courseService;
        this.languageService = languageService;
        this.categoryService = categoryService;
    }

    @PostMapping("/create")

    public ResponseEntity<?> create(@RequestBody CourseBindingModel courseBindingModel) throws CourseDuplicationException {

        courseService.add(courseBindingModel);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {

        this.courseService.deleteCourse(id);

        return ResponseEntity.ok().build();
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
