package com.google.firebase.firestore.local;

import com.google.firebase.firestore.util.Consumer;

/* loaded from: classes2.dex */
final /* synthetic */ class MemoryLruReferenceDelegate$$Lambda$1 implements Consumer {
    private final long[] arg$1;

    private MemoryLruReferenceDelegate$$Lambda$1(long[] jArr) {
        this.arg$1 = jArr;
    }

    public static Consumer lambdaFactory$(long[] jArr) {
        return new MemoryLruReferenceDelegate$$Lambda$1(jArr);
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public void accept(Object obj) {
        MemoryLruReferenceDelegate.a(this.arg$1, (Long) obj);
    }
}
