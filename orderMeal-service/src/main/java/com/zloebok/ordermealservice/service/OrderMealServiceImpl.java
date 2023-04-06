package com.zloebok.ordermealservice.service;

import com.zloebok.ordermealservice.Errors.SaveOrderException;
import com.zloebok.ordermealservice.dto.OrderMealResponse;

import java.util.Arrays;

import com.zloebok.ordermealservice.mapper.OrderMapperImpl;
import com.zloebok.ordermealservice.model.OrderMeal;
import com.zloebok.ordermealservice.repository.OrderMealRepository;
import com.zloebok.ordermealservice.service.MealObserver.MealObserver;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class OrderMealServiceImpl implements OrderMealService {

    private final OrderMealRepository orderMealRepository;
    private final MealObserver mealObserver;
    private final OrderMapperImpl mapper;

    @Override
    public List<OrderMealResponse> getAllOrders() {

        return orderMealRepository.findAll().stream().map(orderMeal -> mapper.OrderMealMapper(orderMeal)).toList();

    }

    @Override
    public OrderMealResponse saveOrder(OrderMeal orderMeal) throws SaveOrderException {

        checkMeal(orderMeal);

        OrderMealResponse orderMealResponse = mapper.OrderMealMapper(orderMealRepository.save(orderMeal));

        return orderMealResponse;

    }

    private void checkMeal(OrderMeal orderMeal) throws SaveOrderException {

        String[] meals = new String[orderMeal.getMealNames().size()];
        String[] mealsRequest = mealObserver.getMealsRequest();

        for (int i = 0; i < orderMeal.getMealNames().size(); i++) {
            meals[i] = orderMeal.getMealNames().get(i).getName();
        }

        for (String element : meals) {

            if (!Arrays.asList(mealsRequest).contains(element)) {
                throw new SaveOrderException("Can not save order");
            }
        }

    }
}
