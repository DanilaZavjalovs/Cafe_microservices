package com.zloebok.reservationservice.mapper;

import com.zloebok.reservationservice.dto.MealResponse;
import com.zloebok.reservationservice.model.Meal;
import org.springframework.stereotype.Component;

@Component
public class mealMapperImpl implements mealMapper {

    @Override
    public MealResponse mealToResponse(Meal meal) {
        return MealResponse.builder()
                .id(meal.getId())
                .category(meal.getCategory())
                .name(meal.getName())
                .price(meal.getPrice()).build();
    }
}
