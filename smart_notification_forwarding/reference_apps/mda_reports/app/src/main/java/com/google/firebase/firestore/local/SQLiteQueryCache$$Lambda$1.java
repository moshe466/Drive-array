package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.firestore.util.Consumer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final /* synthetic */ class SQLiteQueryCache$$Lambda$1 implements Consumer {
    private final SQLiteQueryCache arg$1;

    private SQLiteQueryCache$$Lambda$1(SQLiteQueryCache sQLiteQueryCache) {
        this.arg$1 = sQLiteQueryCache;
    }

    public static Consumer lambdaFactory$(SQLiteQueryCache sQLiteQueryCache) {
        return new SQLiteQueryCache$$Lambda$1(sQLiteQueryCache);
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public void accept(Object obj) {
        SQLiteQueryCache.a(this.arg$1, (Cursor) obj);
    }
}
