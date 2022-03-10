package com.example.coursesservice.model.binding;

import com.example.coursesservice.model.entity.CategoryEntity;
import com.example.coursesservice.model.entity.LanguageEntity;
import com.example.coursesservice.model.entity.LectureEntity;
import com.example.coursesservice.model.enums.StatusNameEnum;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class CourseBindingModel {

    private String name;
    private BigDecimal price;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<CategoryNameBindingModel> categories;
    private List<LanguageNameBindingModel> languages;
    private List<LectureBindingModel> lectures;
    private String lector;
    private Integer duration;
    private String skills;

//    private List<UserEntity> companyOwners;
//    private List<BookingEntity> bookings;

    public CourseBindingModel() {
    }

    public String getName() {
        return name;
    }

    public CourseBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public CourseBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CourseBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getStartDate() {
        return startDate;
    }

    public CourseBindingModel setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getEndDate() {
        return endDate;
    }

    public CourseBindingModel setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public List<CategoryNameBindingModel> getCategories() {
        return categories;
    }

    public CourseBindingModel setCategories(List<CategoryNameBindingModel> categories) {
        this.categories = categories;
        return this;
    }

    public List<LanguageNameBindingModel> getLanguages() {
        return languages;
    }

    public CourseBindingModel setLanguages(List<LanguageNameBindingModel> languages) {
        this.languages = languages;
        return this;
    }

    public List<LectureBindingModel> getLectures() {
        return lectures;
    }

    public CourseBindingModel setLectures(List<LectureBindingModel> lectures) {
        this.lectures = lectures;
        return this;
    }

    public String getLector() {
        return lector;
    }

    public CourseBindingModel setLector(String lector) {
        this.lector = lector;
        return this;
    }

    public Integer getDuration() {
        return duration;
    }

    public CourseBindingModel setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public String getSkills() {
        return skills;
    }

    public CourseBindingModel setSkills(String skills) {
        this.skills = skills;
        return this;
    }
}
