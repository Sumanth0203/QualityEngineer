package com.example.java;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cards {
    public String code;
    public String value;
    public  String image;
    public String suit;
}

