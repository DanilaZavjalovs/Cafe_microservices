package com.zloebok.ordermealservice.controller;

import com.zloebok.ordermealservice.Errors.SaveOrderException;
import com.zloebok.ordermealservice.dto.OrderMealResponse;
import com.zloebok.ordermealservice.model.OrderMeal;
import com.zloebok.ordermealservice.rabbitMQ.publisher.OrderPublisher;
import com.zloebok.ordermealservice.service.OrderMealServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orderMeal")
@AllArgsConstructor
public class OrderMealController {

    private OrderMealServiceImpl orderMealService;
    private OrderPublisher orderPublisher;

    @GetMapping
    public ResponseEntity<List<OrderMealResponse>> getAllOrders() {

        return new ResponseEntity<>(orderMealService.getAllOrders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderMealResponse> saveOrder(@RequestBody OrderMeal orderMeal) {

        try {
            OrderMealResponse orderMealResponse = orderMealService.saveOrder(orderMeal);

            orderPublisher
                    .send("A new order has been sent | Id: " + orderMealResponse.getId()
                            + " | time: " + orderMealResponse.getTime());
            return new ResponseEntity<>(orderMealResponse, HttpStatus.CREATED);

        } catch (SaveOrderException ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
