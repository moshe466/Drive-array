package org.vosk;

/* loaded from: classes2.dex */
public enum LogLevel {
    WARNINGS(-1),
    INFO(0),
    DEBUG(1);

    private final int value;

    LogLevel(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
