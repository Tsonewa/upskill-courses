package com.example.coursesservice.model.view;

public class LecturesDetailsView {

    private String resourceUrl;
    private String lectureDescription;
    private String name;

    public LecturesDetailsView() {
    }

    public LecturesDetailsView(String resourceUrl, String lectureDescription, String name) {
        this.resourceUrl = resourceUrl;
        this.lectureDescription = lectureDescription;
        this.name = name;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public LecturesDetailsView setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
        return this;
    }

    public String getLectureDescription() {
        return lectureDescription;
    }

    public LecturesDetailsView setLectureDescription(String lectureDescription) {
        this.lectureDescription = lectureDescription;
        return this;
    }

    public String getName() {
        return name;
    }

    public LecturesDetailsView setName(String name) {
        this.name = name;
        return this;
    }

}
