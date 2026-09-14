package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.firestore.util.Consumer;

/* loaded from: classes2.dex */
final /* synthetic */ class SQLiteLruReferenceDelegate$$Lambda$3 implements Consumer {
    private final SQLiteLruReferenceDelegate arg$1;
    private final int[] arg$2;

    private SQLiteLruReferenceDelegate$$Lambda$3(SQLiteLruReferenceDelegate sQLiteLruReferenceDelegate, int[] iArr) {
        this.arg$1 = sQLiteLruReferenceDelegate;
        this.arg$2 = iArr;
    }

    public static Consumer lambdaFactory$(SQLiteLruReferenceDelegate sQLiteLruReferenceDelegate, int[] iArr) {
        return new SQLiteLruReferenceDelegate$$Lambda$3(sQLiteLruReferenceDelegate, iArr);
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public void accept(Object obj) {
        SQLiteLruReferenceDelegate.a(this.arg$1, this.arg$2, (Cursor) obj);
    }
}
