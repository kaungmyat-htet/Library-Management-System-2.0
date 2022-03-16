package com.model;

public enum BookFormat {
    HARDCOVER(1),
    PAPERBACK(2),
    AUDIO_CD(3);

    private int numValue;

    BookFormat(int numValue) {
        this.numValue = numValue;
    }

    public int getNumValue() {
        return numValue;
    }
}
