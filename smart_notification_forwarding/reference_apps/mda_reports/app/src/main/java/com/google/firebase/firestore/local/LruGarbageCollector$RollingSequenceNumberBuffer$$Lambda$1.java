package com.google.firebase.firestore.local;

import com.google.firebase.firestore.local.LruGarbageCollector;
import java.util.Comparator;

/* loaded from: classes2.dex */
final /* synthetic */ class LruGarbageCollector$RollingSequenceNumberBuffer$$Lambda$1 implements Comparator {
    private static final LruGarbageCollector$RollingSequenceNumberBuffer$$Lambda$1 instance = new LruGarbageCollector$RollingSequenceNumberBuffer$$Lambda$1();

    private LruGarbageCollector$RollingSequenceNumberBuffer$$Lambda$1() {
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return LruGarbageCollector.RollingSequenceNumberBuffer.a((Long) obj, (Long) obj2);
    }
}
