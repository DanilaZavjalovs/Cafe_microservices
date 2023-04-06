package com.zloebok.ordermealservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "meal_names")
public class MealNames {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

}
