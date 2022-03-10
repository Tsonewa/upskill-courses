package com.example.coursesservice.service;

import com.example.coursesservice.exception.CourseDuplicationException;
import com.example.coursesservice.model.binding.CourseBindingModel;
import com.example.coursesservice.model.binding.CourseEditBindingModel;

public interface CourseService {
    void add(CourseBindingModel courseBindingModel) throws CourseDuplicationException;

    void deleteCourse(String id);

    void edit(CourseEditBindingModel courseEditBindingModel);

    CourseEditBindingModel findCourseById(String id);

}

