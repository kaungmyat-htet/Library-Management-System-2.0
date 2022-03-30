package com.model;

public enum BookStatus {
    AVAILABLE(1),
    RESERVED(2),
    LOANED(3),
    LOST(4);

    private int numValue;

    BookStatus(int numValue) {
        this.numValue = numValue;
    }

    public int getNumValue() {
        return this.numValue;
    }
}
