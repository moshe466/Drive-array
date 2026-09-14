package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.firestore.util.Consumer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final /* synthetic */ class SQLiteQueryCache$$Lambda$2 implements Consumer {
    private final SQLiteQueryCache arg$1;
    private final Consumer arg$2;

    private SQLiteQueryCache$$Lambda$2(SQLiteQueryCache sQLiteQueryCache, Consumer consumer) {
        this.arg$1 = sQLiteQueryCache;
        this.arg$2 = consumer;
    }

    public static Consumer lambdaFactory$(SQLiteQueryCache sQLiteQueryCache, Consumer consumer) {
        return new SQLiteQueryCache$$Lambda$2(sQLiteQueryCache, consumer);
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public void accept(Object obj) {
        SQLiteQueryCache.a(this.arg$1, this.arg$2, (Cursor) obj);
    }
}
