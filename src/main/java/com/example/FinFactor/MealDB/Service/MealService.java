package com.example.FinFactor.MealDB.Service;

import com.example.FinFactor.MealDB.dto.MealResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class MealService {

    private final MealDbClient mealDbClient;

    public MealService(MealDbClient mealDbClient) {
        this.mealDbClient = mealDbClient;
    }

    @Cacheable(value = "mealsByName", key = "#name")
    public MealResponse searchMealByName(String name) {
        return mealDbClient.searchMealByName(name).block();
    }

    @Cacheable(value = "randomMeal")
    public MealResponse getRandomMeal() {
        return mealDbClient.getRandomMeal().block();
    }

    @Cacheable(value = "mealsByCategory", key = "#category")
    public MealResponse getMealsByCategory(String category) {
        return mealDbClient.getMealsByCategory(category).block();
    }

    @Cacheable(value = "mealDetails", key = "#id")
    public MealResponse getMealDetails(String id) {
        return mealDbClient.getMealDetails(id).block();
    }
}
