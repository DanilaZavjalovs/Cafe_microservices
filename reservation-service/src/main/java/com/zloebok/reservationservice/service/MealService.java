package com.zloebok.reservationservice.service;

import com.zloebok.reservationservice.dto.MealResponse;
import com.zloebok.reservationservice.mapper.mealMapperImpl;
import com.zloebok.reservationservice.model.Meal;
import com.zloebok.reservationservice.repository.MealRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MealService {
    private final MealRepository mealRepository;
    private final mealMapperImpl mapper;

    public List<MealResponse> getAllMeal() {
        List<Meal> listMeal = mealRepository.findAll();
        return listMeal.stream().map(meal -> mapper.mealToResponse(meal)).toList();
    }

    public void createMeal(Meal meal) {
        mealRepository.save(meal);
    }

    public Optional<MealResponse> getMealById(String id) {
        Meal meal = mealRepository.findById(id).get();
        Optional<MealResponse> mealResponse = Optional.of(mapper.mealToResponse(meal));

        return mealResponse;
    }
}
