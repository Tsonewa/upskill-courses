package com.example.coursesservice.model.view;

import java.math.BigDecimal;

public class CourseCardPriceView {

    private String pictureUrl;
    private String name;
    private String lector;
    private BigDecimal price;

    public CourseCardPriceView() {
    }

    public CourseCardPriceView(String pictureUrl, String name, String lector, BigDecimal price) {
        this.pictureUrl = pictureUrl;
        this.name = name;
        this.lector = lector;
        this.price = price;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public CourseCardPriceView setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
        return this;
    }
}
