package com.example.coursesservice.model.view;

import java.util.List;

public class CourseStreamDetailsView {

    private List<LecturesDetailsView> lectures;
    private String lectorDescription;

    public CourseStreamDetailsView() {
    }

    public List<LecturesDetailsView> getLectures() {
        return lectures;
    }

    public CourseStreamDetailsView setLectures(List<LecturesDetailsView> lectures) {
        this.lectures = lectures;
        return this;
    }

    public String getLectorDescription() {
        return lectorDescription;
    }

    public CourseStreamDetailsView setLectorDescription(String lectorDescription) {
        this.lectorDescription = lectorDescription;
        return this;
    }
}
