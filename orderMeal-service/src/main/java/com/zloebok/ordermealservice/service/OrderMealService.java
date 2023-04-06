package com.zloebok.ordermealservice.service;

import com.zloebok.ordermealservice.Errors.SaveOrderException;
import com.zloebok.ordermealservice.dto.OrderMealResponse;
import com.zloebok.ordermealservice.model.OrderMeal;

import java.util.List;

public interface OrderMealService {
    public List<OrderMealResponse> getAllOrders();
    public OrderMealResponse saveOrder(OrderMeal orderMeal) throws SaveOrderException;
}
