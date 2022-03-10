package com.example.coursesservice.service.impl;

import com.example.coursesservice.exception.CourseDuplicationException;
import com.example.coursesservice.model.binding.CourseBindingModel;
import com.example.coursesservice.model.entity.CategoryEntity;
import com.example.coursesservice.model.entity.CourseEntity;
import com.example.coursesservice.model.entity.LanguageEntity;
import com.example.coursesservice.model.entity.LectureEntity;
import com.example.coursesservice.model.enums.CategoryNameEnum;
import com.example.coursesservice.model.enums.LanguageEnum;
import com.example.coursesservice.repository.CategoryRepository;
import com.example.coursesservice.repository.CourseRepository;
import com.example.coursesservice.repository.LanguageRepository;
import com.example.coursesservice.repository.LectureRepository;
import com.example.coursesservice.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final ModelMapper modelMapper;
    private final LectureRepository lectureRepository;
    private final LanguageRepository languageRepository;
    private final CategoryRepository categoryRepository;
    private final CourseRepository courseRepository;

    public CourseServiceImpl(ModelMapper modelMapper, LectureRepository lectureRepository, LanguageRepository languageRepository, CategoryRepository categoryRepository, CourseRepository courseRepository) {
        this.modelMapper = modelMapper;
        this.lectureRepository = lectureRepository;
        this.languageRepository = languageRepository;
        this.categoryRepository = categoryRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void add(CourseBindingModel courseBindingModel) throws CourseDuplicationException {

        if(isExist(courseBindingModel.getName())){
            throw new CourseDuplicationException();
        }
        List<LectureEntity> lectures = courseBindingModel.getLectures().stream()
                .map(lecture-> {
                    LectureEntity lectureEntity = modelMapper.map(lecture, LectureEntity.class);

                    this.lectureRepository.save(lectureEntity);
                    return lectureEntity;
                }).collect(Collectors.toList());

        List<LanguageEntity> languages = courseBindingModel.getLanguages().stream()
                .map(l -> this.languageRepository.getByName
                        (LanguageEnum.valueOf(l.getName().toUpperCase()))).collect(Collectors.toList());

        List<CategoryEntity> categories = courseBindingModel.getCategories().stream()
                .map(c -> this.categoryRepository.getCategoryByName
                        (CategoryNameEnum.valueOf(c.getName().toUpperCase()))).collect(Collectors.toList());

        CourseEntity course= modelMapper.map(courseBindingModel, CourseEntity.class);

        course.setCategories(categories);
        course.setLanguages(languages);
        course.setLectures(lectures);

        this.courseRepository.save(course);

    }

    @Override
    public void deleteCourse(String id) {

        this.courseRepository.deleteById(id);
    }

    private boolean isExist(String name) {

        return this.courseRepository.existsByName(name);
    }
}
