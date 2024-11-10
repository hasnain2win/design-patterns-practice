package com.codefider.design.patterns.observer.observer;

import com.codefider.design.patterns.observer.enums.NotificationType;

public interface NotificationObserver {

    void update(NotificationType type, String productId, String message);
}
