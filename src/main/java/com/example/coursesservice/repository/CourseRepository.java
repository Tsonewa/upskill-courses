package com.example.coursesservice.repository;

import com.example.coursesservice.model.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, String>{
    boolean existsByName(String name);
}
