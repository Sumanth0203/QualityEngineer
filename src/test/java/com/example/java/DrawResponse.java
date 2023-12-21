package com.example.java;

import com.example.java.Cards;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DrawResponse {
    public String deck_id;
    public boolean success;
    public List<Cards> cards;

}
