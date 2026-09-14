package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.common.base.Function;
import com.google.firebase.firestore.model.MaybeDocument;

/* loaded from: classes2.dex */
final /* synthetic */ class SQLiteRemoteDocumentCache$$Lambda$1 implements Function {
    private final SQLiteRemoteDocumentCache arg$1;

    private SQLiteRemoteDocumentCache$$Lambda$1(SQLiteRemoteDocumentCache sQLiteRemoteDocumentCache) {
        this.arg$1 = sQLiteRemoteDocumentCache;
    }

    public static Function lambdaFactory$(SQLiteRemoteDocumentCache sQLiteRemoteDocumentCache) {
        return new SQLiteRemoteDocumentCache$$Lambda$1(sQLiteRemoteDocumentCache);
    }

    @Override // com.google.common.base.Function
    public Object apply(Object obj) {
        MaybeDocument decodeMaybeDocument;
        decodeMaybeDocument = this.arg$1.decodeMaybeDocument(((Cursor) obj).getBlob(0));
        return decodeMaybeDocument;
    }
}
