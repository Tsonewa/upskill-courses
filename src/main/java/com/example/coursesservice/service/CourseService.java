package com.example.coursesservice.service;

import com.example.coursesservice.exception.CourseDuplicationException;
import com.example.coursesservice.model.binding.CourseBindingModel;

public interface CourseService {
    void add(CourseBindingModel courseBindingModel) throws CourseDuplicationException;

    void deleteCourse(String id);
}

