package com.google.firebase.sessions;

import O2.c;
import android.os.SystemClock;

/* loaded from: classes.dex */
public final class TimeProviderImpl implements TimeProvider {
    public static final TimeProviderImpl INSTANCE = new TimeProviderImpl();
    private static final long US_PER_MILLIS = 1000;

    private TimeProviderImpl() {
    }

    @Override // com.google.firebase.sessions.TimeProvider
    public long currentTimeUs() {
        return System.currentTimeMillis() * US_PER_MILLIS;
    }

    @Override // com.google.firebase.sessions.TimeProvider
    /* renamed from: elapsedRealtime-UwyO8pc */
    public long mo11elapsedRealtimeUwyO8pc() {
        int i = O2.a.f1537d;
        return T.b.N(SystemClock.elapsedRealtime(), c.f1541c);
    }
}
