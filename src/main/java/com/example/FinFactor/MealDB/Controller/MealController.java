package com.example.FinFactor.MealDB.Controller;

import com.example.FinFactor.MealDB.dto.MealResponse;
import com.example.FinFactor.MealDB.Service.MealService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/meals", produces = MediaType.APPLICATION_JSON_VALUE)
public class MealController {

    private final MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping("/search")
    public ResponseEntity<MealResponse> searchMeal(@RequestParam String name) {
        MealResponse resp = mealService.searchMealByName(name);
        if (resp == null || resp.getMeals() == null || resp.getMeals().isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(resp);
    }

    @GetMapping("/random")
    public ResponseEntity<MealResponse> getRandomMeal() {
        MealResponse resp = mealService.getRandomMeal();
        if (resp == null || resp.getMeals() == null || resp.getMeals().isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(resp);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<MealResponse> getMealsByCategory(@PathVariable String category) {
        MealResponse resp = mealService.getMealsByCategory(category);
        if (resp == null || resp.getMeals() == null || resp.getMeals().isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(resp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MealResponse> getMealDetails(@PathVariable String id) {
        MealResponse resp = mealService.getMealDetails(id);
        if (resp == null || resp.getMeals() == null || resp.getMeals().isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(resp);
    }
}
