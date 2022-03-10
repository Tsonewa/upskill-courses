package com.example.coursesservice.model.view;

import java.math.BigDecimal;

public class CourseCardLectureCountView {


    private String pictureUrl;
    private String name;
    private String lector;
    private Integer lecturesCount;

    public CourseCardLectureCountView() {
    }

    public CourseCardLectureCountView(String pictureUrl, String name, String lector, Integer lecturesCount) {
        this.pictureUrl = pictureUrl;
        this.name = name;
        this.lector = lector;
        this.lecturesCount = lecturesCount;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public CourseCardLectureCountView setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
        return this;
    }
}
