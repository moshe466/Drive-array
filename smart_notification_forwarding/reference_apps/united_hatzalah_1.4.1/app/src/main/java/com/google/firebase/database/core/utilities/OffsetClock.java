package com.google.firebase.database.core.utilities;

/* loaded from: classes.dex */
public class OffsetClock implements Clock {
    private final Clock baseClock;
    private long offset;

    public OffsetClock(Clock clock, long j2) {
        this.baseClock = clock;
        this.offset = j2;
    }

    @Override // com.google.firebase.database.core.utilities.Clock
    public long millis() {
        return this.baseClock.millis() + this.offset;
    }

    public void setOffset(long j2) {
        this.offset = j2;
    }
}
