package com.google.firebase.firestore.local;

import com.google.firebase.firestore.local.LruGarbageCollector;
import com.google.firebase.firestore.util.Supplier;

/* loaded from: classes2.dex */
public final /* synthetic */ class LocalStore$$Lambda$10 implements Supplier {
    private final LocalStore arg$1;
    private final LruGarbageCollector arg$2;

    private LocalStore$$Lambda$10(LocalStore localStore, LruGarbageCollector lruGarbageCollector) {
        this.arg$1 = localStore;
        this.arg$2 = lruGarbageCollector;
    }

    public static Supplier lambdaFactory$(LocalStore localStore, LruGarbageCollector lruGarbageCollector) {
        return new LocalStore$$Lambda$10(localStore, lruGarbageCollector);
    }

    @Override // com.google.firebase.firestore.util.Supplier
    public Object get() {
        LruGarbageCollector.Results a;
        a = this.arg$2.a(this.arg$1.queryDataByTarget);
        return a;
    }
}
