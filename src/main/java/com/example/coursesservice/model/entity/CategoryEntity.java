package com.example.coursesservice.model.entity;

import com.example.coursesservice.model.enums.CategoryNameEnum;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {
    private CategoryNameEnum name;

    public CategoryEntity() {
    }

    @Enumerated(value = EnumType.STRING)
    public CategoryNameEnum getName() {
        return name;
    }

    public CategoryEntity setName(CategoryNameEnum name) {
        this.name = name;
        return this;
    }

}
