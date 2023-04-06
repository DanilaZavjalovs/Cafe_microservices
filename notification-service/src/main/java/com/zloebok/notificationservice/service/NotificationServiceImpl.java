package com.zloebok.notificationservice.service;

import com.zloebok.notificationservice.model.Notifications;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private Notifications notifications;

    @Override
    public ArrayList<String> getAllNotifications() {

        ArrayList<String> notificationsArray = notifications.getNotificationsArray();

        return notificationsArray;
    }
}
