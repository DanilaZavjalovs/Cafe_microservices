package com.zloebok.reservationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("meal")
@AllArgsConstructor
@Data
public class Meal {

    @Id
    private String id;

    private String category;
    private String name;
    private int price;

}
