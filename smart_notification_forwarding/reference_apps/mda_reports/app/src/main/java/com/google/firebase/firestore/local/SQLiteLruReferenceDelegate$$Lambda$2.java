package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.firestore.util.Consumer;

/* loaded from: classes2.dex */
final /* synthetic */ class SQLiteLruReferenceDelegate$$Lambda$2 implements Consumer {
    private final Consumer arg$1;

    private SQLiteLruReferenceDelegate$$Lambda$2(Consumer consumer) {
        this.arg$1 = consumer;
    }

    public static Consumer lambdaFactory$(Consumer consumer) {
        return new SQLiteLruReferenceDelegate$$Lambda$2(consumer);
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public void accept(Object obj) {
        SQLiteLruReferenceDelegate.a(this.arg$1, (Cursor) obj);
    }
}
