package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.firestore.util.Consumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class SQLiteSchema$$Lambda$11 implements Consumer {
    private final Consumer arg$1;

    private SQLiteSchema$$Lambda$11(Consumer consumer) {
        this.arg$1 = consumer;
    }

    public static Consumer lambdaFactory$(Consumer consumer) {
        return new SQLiteSchema$$Lambda$11(consumer);
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public void accept(Object obj) {
        this.arg$1.accept(EncodedPath.a(((Cursor) obj).getString(0)).popLast());
    }
}
