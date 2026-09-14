package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.firestore.util.Consumer;
import java.util.Map;

/* loaded from: classes2.dex */
final /* synthetic */ class SQLiteRemoteDocumentCache$$Lambda$2 implements Consumer {
    private final SQLiteRemoteDocumentCache arg$1;
    private final Map arg$2;

    private SQLiteRemoteDocumentCache$$Lambda$2(SQLiteRemoteDocumentCache sQLiteRemoteDocumentCache, Map map) {
        this.arg$1 = sQLiteRemoteDocumentCache;
        this.arg$2 = map;
    }

    public static Consumer lambdaFactory$(SQLiteRemoteDocumentCache sQLiteRemoteDocumentCache, Map map) {
        return new SQLiteRemoteDocumentCache$$Lambda$2(sQLiteRemoteDocumentCache, map);
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public void accept(Object obj) {
        SQLiteRemoteDocumentCache.a(this.arg$1, this.arg$2, (Cursor) obj);
    }
}
