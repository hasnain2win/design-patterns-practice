package com.codefider.design.patterns.strategyPaymentapp.constants;

public enum PaymentStatus implements CharSequence {
    CREATED,
    APPROVED,
    REJECTED,
    CANCELLED,
    COMPLETED,
    PENDING,
    ;

    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }
}
