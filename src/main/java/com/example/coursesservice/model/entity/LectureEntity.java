package com.example.coursesservice.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="lectures")
public class LectureEntity extends BaseEntity{

    private String name;
    private String resourceUrl;

    public LectureEntity() {
    }

    public LectureEntity(String name, String resourceUrl) {
        this.name = name;
        this.resourceUrl = resourceUrl;
    }

    public String getName() {
        return name;
    }

    public LectureEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public LectureEntity setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
        return this;
    }
}
