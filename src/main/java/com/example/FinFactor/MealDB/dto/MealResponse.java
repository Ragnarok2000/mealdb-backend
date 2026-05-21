package com.example.FinFactor.MealDB.dto;

import java.io.Serializable;
import java.util.List;

public class MealResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<MealDto> meals;

    public List<MealDto> getMeals() {
        return meals;
    }

    public void setMeals(List<MealDto> meals) {
        this.meals = meals;
    }
}
