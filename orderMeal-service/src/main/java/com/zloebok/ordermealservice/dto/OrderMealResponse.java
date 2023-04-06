package com.zloebok.ordermealservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderMealResponse {

    private String id;
    private List<MealNamesResponse> mealNames;
    private String time;

}
