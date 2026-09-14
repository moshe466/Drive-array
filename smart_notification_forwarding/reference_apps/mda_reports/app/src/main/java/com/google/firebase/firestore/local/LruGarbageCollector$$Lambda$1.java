package com.google.firebase.firestore.local;

import com.google.firebase.firestore.local.LruGarbageCollector;
import com.google.firebase.firestore.util.Consumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class LruGarbageCollector$$Lambda$1 implements Consumer {
    private final LruGarbageCollector.RollingSequenceNumberBuffer arg$1;

    private LruGarbageCollector$$Lambda$1(LruGarbageCollector.RollingSequenceNumberBuffer rollingSequenceNumberBuffer) {
        this.arg$1 = rollingSequenceNumberBuffer;
    }

    public static Consumer lambdaFactory$(LruGarbageCollector.RollingSequenceNumberBuffer rollingSequenceNumberBuffer) {
        return new LruGarbageCollector$$Lambda$1(rollingSequenceNumberBuffer);
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public void accept(Object obj) {
        this.arg$1.a(Long.valueOf(((QueryData) obj).getSequenceNumber()));
    }
}
