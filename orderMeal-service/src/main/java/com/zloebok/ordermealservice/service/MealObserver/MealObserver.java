package com.zloebok.ordermealservice.service.MealObserver;

import com.zloebok.ordermealservice.dto.MealRequest;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@Data
public class MealObserver {

    private final WebClient.Builder webClient;
    private String[] mealsRequest;

    private void update(String[] mealsRequest) {
        this.mealsRequest = mealsRequest;
    }

    public MealObserver(WebClient.Builder webClient) {
        this.webClient = webClient;
        MealRequest[] request = this.webClient.build().get()
                .uri("http://reservation-service/api/meal")
                .retrieve()
                .bodyToMono(MealRequest[].class)
                .block();

        mealsRequest = new String[request.length];

        for (int i = 0; i < request.length; i++) {
            mealsRequest[i] = request[i].getName();
        }
    }
}
