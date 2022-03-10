package com.example.coursesservice.service.impl;

import com.example.coursesservice.exception.CourseDuplicationException;
import com.example.coursesservice.exception.CourseNotFoundException;
import com.example.coursesservice.model.binding.CourseBindingModel;
import com.example.coursesservice.model.binding.CourseEditBindingModel;
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
import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

        if (isExist(courseBindingModel.getName())) {
            throw new CourseDuplicationException();
        }
        List<LectureEntity> lectures = courseBindingModel.getLectures().stream()
                .map(lecture -> {
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

        CourseEntity course = modelMapper.map(courseBindingModel, CourseEntity.class);

        course.setCategories(categories);
        course.setLanguages(languages);
        course.setLectures(lectures);

        this.courseRepository.save(course);

    }

    @Override
    public void deleteCourse(String id) {

        this.courseRepository.deleteById(id);
    }

    @Override
    public CourseEntity getCourseEntityById(String id) {

        return this.courseRepository.getById(id);
    }

    public void edit(CourseEditBindingModel courseEditBindingModel) {

        CourseEntity courseEntity = this.courseRepository.findById(courseEditBindingModel.getId())
                .orElseThrow(() -> new CourseNotFoundException(courseEditBindingModel.getId()));

        List<LectureEntity> lectures = courseEditBindingModel.getLectures().stream()
                .map(lecture -> {
                    LectureEntity lectureEntity = modelMapper.map(lecture, LectureEntity.class);

                    this.lectureRepository.save(lectureEntity);
                    return lectureEntity;
                }).collect(Collectors.toList());

        List<LanguageEntity> languages = courseEditBindingModel.getLanguages().stream()
                .map(l -> this.languageRepository.getByName
                        (LanguageEnum.valueOf(l.getName().toUpperCase()))).collect(Collectors.toList());

        List<CategoryEntity> categories = courseEditBindingModel.getCategories().stream()
                .map(c -> this.categoryRepository.getCategoryByName
                        (CategoryNameEnum.valueOf(c.getName().toUpperCase()))).collect(Collectors.toList());

        courseEntity.setName(courseEditBindingModel.getName())
                .setLectures(lectures)
                .setLanguages(languages)
                .setCategories(categories)
                .setDescription(courseEditBindingModel.getDescription())
                .setDuration(courseEditBindingModel.getDuration())
                .setStartDate(courseEditBindingModel.getStartDate())
                .setEndDate(courseEditBindingModel.getEndDate())
                .setLector(courseEditBindingModel.getLector())
                .setLectorDescription(courseEditBindingModel.getLectorDescription())
                .setPrice(courseEditBindingModel.getPrice())
                .setSkills(courseEditBindingModel.getSkills())
                .setVideoUrl(courseEditBindingModel.getVideoUrl());

        this.courseRepository.save(courseEntity);
    }


    @Override
    public CourseEditBindingModel findCourseById(String id) {
        CourseEntity courseEntity = this.courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));

        return modelMapper.map(courseEntity, CourseEditBindingModel.class);
    }

    private boolean isExist(String name) {

        return this.courseRepository.existsByName(name);
    }
}
