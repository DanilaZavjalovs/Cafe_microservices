package com.zloebok.notificationservice.rabbitMQ.consumer;

import com.zloebok.notificationservice.service.NotificationServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class OrderConsumer {

    private NotificationServiceImpl notificationService;

    @RabbitListener(queues = {"${queue.name}"})
    public void receive(@Payload String order) {
        notificationService.getAllNotifications().add(order);
    }

}
