package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.local.SQLiteQueryCache;
import com.google.firebase.firestore.util.Consumer;

/* loaded from: classes2.dex */
final /* synthetic */ class SQLiteQueryCache$$Lambda$4 implements Consumer {
    private final SQLiteQueryCache arg$1;
    private final Target arg$2;
    private final SQLiteQueryCache.QueryDataHolder arg$3;

    private SQLiteQueryCache$$Lambda$4(SQLiteQueryCache sQLiteQueryCache, Target target, SQLiteQueryCache.QueryDataHolder queryDataHolder) {
        this.arg$1 = sQLiteQueryCache;
        this.arg$2 = target;
        this.arg$3 = queryDataHolder;
    }

    public static Consumer lambdaFactory$(SQLiteQueryCache sQLiteQueryCache, Target target, SQLiteQueryCache.QueryDataHolder queryDataHolder) {
        return new SQLiteQueryCache$$Lambda$4(sQLiteQueryCache, target, queryDataHolder);
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public void accept(Object obj) {
        SQLiteQueryCache.a(this.arg$1, this.arg$2, this.arg$3, (Cursor) obj);
    }
}
