package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.firestore.local.SQLiteQueryCache;
import com.google.firebase.firestore.util.Consumer;

/* loaded from: classes2.dex */
final /* synthetic */ class SQLiteQueryCache$$Lambda$5 implements Consumer {
    private final SQLiteQueryCache.DocumentKeysHolder arg$1;

    private SQLiteQueryCache$$Lambda$5(SQLiteQueryCache.DocumentKeysHolder documentKeysHolder) {
        this.arg$1 = documentKeysHolder;
    }

    public static Consumer lambdaFactory$(SQLiteQueryCache.DocumentKeysHolder documentKeysHolder) {
        return new SQLiteQueryCache$$Lambda$5(documentKeysHolder);
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public void accept(Object obj) {
        SQLiteQueryCache.a(this.arg$1, (Cursor) obj);
    }
}
