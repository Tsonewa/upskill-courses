package com.example.coursesservice.model.binding;

public class LectureBindingModel {

    private String name;
    private String resourceUrl;
    private String lectureDescription;


    public LectureBindingModel() {
    }

    public LectureBindingModel(String name, String resourceUrl) {
        this.name = name;
        this.resourceUrl = resourceUrl;
    }

    public String getName() {
        return name;
    }

    public LectureBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public LectureBindingModel setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
        return this;
    }

    public String getLectureDescription() {
        return lectureDescription;
    }

    public LectureBindingModel setLectureDescription(String lectureDescription) {
        this.lectureDescription = lectureDescription;
        return this;
    }
}
