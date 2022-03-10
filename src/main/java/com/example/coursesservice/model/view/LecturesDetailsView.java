package com.example.coursesservice.model.view;

public class LecturesDetailsView {

    private String resourceUrl;
    private String description;
    private String name;
    private String lectorDescription;

    public LecturesDetailsView() {
    }

    public LecturesDetailsView(String resourceUrl, String description, String name, String lectorDescription) {
        this.resourceUrl = resourceUrl;
        this.description = description;
        this.name = name;
        this.lectorDescription = lectorDescription;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public LecturesDetailsView setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public LecturesDetailsView setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public LecturesDetailsView setName(String name) {
        this.name = name;
        return this;
    }

    public String getLectorDescription() {
        return lectorDescription;
    }

    public LecturesDetailsView setLectorDescription(String lectorDescription) {
        this.lectorDescription = lectorDescription;
        return this;
    }
}
