package com.zloebok.reservationservice.controller;


import com.zloebok.reservationservice.dto.MealResponse;
import com.zloebok.reservationservice.model.Meal;
import com.zloebok.reservationservice.service.MealService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meal")
@AllArgsConstructor
public class MealController {

    private MealService mealService;

    @GetMapping
    public ResponseEntity<List<MealResponse>> getAllMeal() {

        return new ResponseEntity<>(mealService.getAllMeal(), HttpStatus.OK);

    }


    @PostMapping
    public ResponseEntity createMeal(@RequestBody Meal meal) {
        mealService.createMeal(meal);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    ResponseEntity<MealResponse> getMealById(@PathVariable String id) {
        MealResponse mealResponse = mealService.getMealById(id).get();

        return new ResponseEntity<>(mealResponse, HttpStatus.OK);
    }

}
