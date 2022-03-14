package com.model;

public enum AccountStatus {
    ACTIVE(1),
    CLOSED(2),
    CANCELLED(3),
    BLACKLISTED(4);

    private int numValue;

    AccountStatus(int numValue) {
        this.numValue = numValue;
    }

    public int getNumValue() {
        return numValue;
    }
}
