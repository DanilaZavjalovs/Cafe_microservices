package com.zloebok.reservationservice.mapper;

import com.zloebok.reservationservice.dto.MealResponse;
import com.zloebok.reservationservice.model.Meal;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface mealMapper {

    MealResponse mealToResponse(Meal meal);

}
