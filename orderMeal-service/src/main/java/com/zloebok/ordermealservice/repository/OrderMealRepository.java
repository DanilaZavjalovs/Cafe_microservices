package com.zloebok.ordermealservice.repository;

import com.zloebok.ordermealservice.model.OrderMeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMealRepository extends JpaRepository<OrderMeal, String> {
}
