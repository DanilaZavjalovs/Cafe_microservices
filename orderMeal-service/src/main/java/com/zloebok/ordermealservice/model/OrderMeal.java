package com.zloebok.ordermealservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "order_meal")
@Data
public class OrderMeal {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<MealNames> mealNames;
    private String time;

    public OrderMeal() {
        setTime(LocalDateTime.now().toString());
    }

}
