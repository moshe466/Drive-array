package com.google.firebase.firestore.util;

import com.google.firebase.firestore.util.AsyncQueue;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final /* synthetic */ class AsyncQueue$$Lambda$6 implements Comparator {
    private static final AsyncQueue$$Lambda$6 instance = new AsyncQueue$$Lambda$6();

    private AsyncQueue$$Lambda$6() {
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return AsyncQueue.a((AsyncQueue.DelayedTask) obj, (AsyncQueue.DelayedTask) obj2);
    }
}
