package com.zloebok.notificationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Data
@Component
@AllArgsConstructor
public class Notifications {

    private ArrayList<String> notificationsArray = new ArrayList<>();

}
