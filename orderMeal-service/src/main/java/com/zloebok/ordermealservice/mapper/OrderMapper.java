package com.zloebok.ordermealservice.mapper;

import com.zloebok.ordermealservice.dto.MealNamesResponse;
import com.zloebok.ordermealservice.dto.OrderMealResponse;
import com.zloebok.ordermealservice.model.OrderMeal;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    MealNamesResponse MealNamesMapper (OrderMeal orderMeal, int i);
    OrderMealResponse OrderMealMapper(OrderMeal orderMeal);

}
