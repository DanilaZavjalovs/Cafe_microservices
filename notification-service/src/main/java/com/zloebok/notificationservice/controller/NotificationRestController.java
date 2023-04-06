package com.zloebok.notificationservice.controller;

import com.zloebok.notificationservice.service.NotificationServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/notification")
@AllArgsConstructor
public class NotificationRestController {

    private NotificationServiceImpl notificationService;

    @GetMapping
    public ArrayList<String> getAllNotifications() {

        ArrayList<String> notificationArray = notificationService.getAllNotifications();

        return notificationArray;
    }

}
