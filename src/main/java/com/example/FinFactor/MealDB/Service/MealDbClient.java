package com.example.FinFactor.MealDB.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.FinFactor.MealDB.dto.MealResponse;

import reactor.core.publisher.Mono;

@Service
public class MealDbClient {

    private final WebClient webClient;

    public MealDbClient() {
        this.webClient = WebClient.builder()
                .baseUrl("https://www.themealdb.com/api/json/v1/1")
                .build();
    }

    public Mono<MealResponse> searchMealByName(String name) {
        return webClient.get()
                .uri("/search.php?s={name}", name)
                .retrieve()
                .bodyToMono(MealResponse.class);
    }

    public Mono<MealResponse> getRandomMeal() {
        return webClient.get()
                .uri("/random.php")
                .retrieve()
                .bodyToMono(MealResponse.class);
    }

    public Mono<MealResponse> getMealsByCategory(String category) {
        return webClient.get()
                .uri("/filter.php?c={category}", category)
                .retrieve()
                .bodyToMono(MealResponse.class);
    }

    public Mono<MealResponse> getMealDetails(String id) {
        return webClient.get()
                .uri("/lookup.php?i={id}", id)
                .retrieve()
                .bodyToMono(MealResponse.class);
    }
}
