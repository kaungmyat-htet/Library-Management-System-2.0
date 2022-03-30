package com.model;

public enum AccountStatus {
    ACTIVE(1),
    CLOSED(2),
    CANCELLED(3),
    BLACKLISTED(4);

    private final int numValue;

    AccountStatus(int numValue) {
        this.numValue = numValue;
    }

    public int getNumValue() {
        return numValue;
    }

    public static AccountStatus getStatus(int numValue) {
        AccountStatus status = null;
        if (numValue == ACTIVE.getNumValue()) {
            status = AccountStatus.ACTIVE;
        }
        if (numValue == CLOSED.getNumValue()) {
            status = AccountStatus.CLOSED;
        }
        if (numValue == CANCELLED.getNumValue()) {
            status = AccountStatus.CANCELLED;
        }
        if (numValue == BLACKLISTED.getNumValue()) {
            status = AccountStatus.BLACKLISTED;
        }
        return status;
    }
}
