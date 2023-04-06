package com.zloebok.ordermealservice.mapper;

import com.zloebok.ordermealservice.dto.MealNamesResponse;
import com.zloebok.ordermealservice.dto.OrderMealResponse;
import com.zloebok.ordermealservice.model.OrderMeal;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public MealNamesResponse MealNamesMapper(OrderMeal orderMeal, int i) {
        return MealNamesResponse.builder()
                .id(orderMeal.getMealNames().get(i).getId())
                .name(orderMeal.getMealNames().get(i).getName())
                .build();
    }

    @Override
    public OrderMealResponse OrderMealMapper(OrderMeal orderMeal) {
        List<MealNamesResponse> listNames = new ArrayList<>();

        for (int i = 0; i < orderMeal.getMealNames().size(); i++) {
            listNames.add(MealNamesMapper(orderMeal, i));
        }

        return OrderMealResponse.builder()
                .id(orderMeal.getId())
                .mealNames(listNames)
                .time(orderMeal.getTime())
                .build();
    }
}
