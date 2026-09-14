package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* loaded from: classes.dex */
final /* synthetic */ class SQLiteEventStore$$Lambda$8 implements SQLiteEventStore.Function {
    private static final SQLiteEventStore$$Lambda$8 instance = new SQLiteEventStore$$Lambda$8();

    private SQLiteEventStore$$Lambda$8() {
    }

    public static SQLiteEventStore.Function lambdaFactory$() {
        return instance;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        Long valueOf;
        valueOf = Long.valueOf(r2.moveToNext() ? ((Cursor) obj).getLong(0) : 0L);
        return valueOf;
    }
}
