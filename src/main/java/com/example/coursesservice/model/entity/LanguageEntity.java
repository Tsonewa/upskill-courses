package com.example.coursesservice.model.entity;

import com.example.coursesservice.model.enums.LanguageEnum;

import javax.persistence.*;

@Entity
@Table(name = "languages")
public class LanguageEntity extends BaseEntity {
    private LanguageEnum name;

    public LanguageEntity() {
    }

    @Enumerated(value = EnumType.STRING)
    public LanguageEnum getName() {
        return name;
    }

    public LanguageEntity setName(LanguageEnum name) {
        this.name = name;
        return this;
    }
}

