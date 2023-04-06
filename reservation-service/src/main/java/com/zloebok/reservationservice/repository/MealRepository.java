package com.zloebok.reservationservice.repository;

import com.zloebok.reservationservice.model.Meal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MealRepository extends MongoRepository<Meal, String> {
}
