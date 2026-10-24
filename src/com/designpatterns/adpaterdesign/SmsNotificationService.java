package com.designpatterns.adpaterdesign;

public class SmsNotificationService implements NotificationService {

    @Override
    public void sendNotification() {

        System.out.println("SMS Sent");
    }
}
