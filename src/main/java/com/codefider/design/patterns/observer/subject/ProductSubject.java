package com.codefider.design.patterns.observer.subject;

import com.codefider.design.patterns.observer.enums.NotificationType;
import com.codefider.design.patterns.observer.observer.NotificationObserver;

import java.util.ArrayList;
import java.util.List;

public abstract class ProductSubject {

    private final List<NotificationObserver> observers = new ArrayList<>();

    public void addObserver(NotificationObserver observer) {
        observers.add(observer);
    }
    public void removeObserver(NotificationObserver observer) {
        observers.remove(observer);
    }
    public void notifyObservers(NotificationType type,String productId,String message) {
        for (NotificationObserver observer : observers) {
            observer.update(type, productId, message);
        }
    }
}
